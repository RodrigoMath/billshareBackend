package com.billshare.backend.domain.userContext;

import com.billshare.backend.adapters.inbound.UsuarioDTO;
import com.billshare.backend.adapters.outbound.repositories.JpaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UserRepository userRepository;

    public void checaSeUsuarioExiste(Long idUsuario){
        if (!userRepository.existsById(idUsuario)) {
            throw new RuntimeException("Usuário não encontrado.");
        }
    }

    public void validaUsuario(UsuarioDTO usuario) {
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new RuntimeException("O e-mail é obrigatório.");
        }

        if (!isEmailValido(usuario.getEmail())) {
            throw new RuntimeException("E-mail inválido. Use o formato: usuario@dominio.com");
        }
    }

    private boolean isEmailValido(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(regex);
    }
}

