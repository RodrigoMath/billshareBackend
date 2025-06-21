package com.billshare.backend.application.services;

import com.billshare.backend.adapters.inbound.UsuarioDTO;
import com.billshare.backend.adapters.outbound.repositories.JpaUsuarioRepository;
import com.billshare.backend.application.useCases.EmailUseCase;
import com.billshare.backend.application.useCases.UsuarioUseCase;
import com.billshare.backend.domain.userContext.UserRepository;
import com.billshare.backend.domain.userContext.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UsuarioUseCase {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailUseCase emailUseCase;

    @Override
    public void checaSeUsuarioExiste(Long idUsuario){
        if (!userRepository.existsById(idUsuario)) {
            throw new RuntimeException("Usuário não encontrado.");
        }
    }
    @Override
    public void validaUsuario(UsuarioDTO usuario) {
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new RuntimeException("O e-mail é obrigatório.");
        }

        if (!isEmailValido(usuario.getEmail())) {
            throw new RuntimeException("E-mail inválido. Use o formato: usuario@dominio.com");
        }
    }
    @Override
    public boolean isEmailValido(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(regex);
    }

    @Override
    public String enviarCodigoAoUsuario(Usuario usuario) {
        return emailUseCase.enviarMensagemDeEmail(
                usuario.getEmail(),
                "Código de Login Plataforma Monte Jiu Jitsu - Pomerode",
                String.format("Seu código, para realizar marcar presença nas aulas é: %d", usuario.getId())
        );
    }
}

