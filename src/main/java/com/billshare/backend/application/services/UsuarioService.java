package com.billshare.backend.application.services;

import com.billshare.backend.adapters.inbound.UsuarioDTO;
import com.billshare.backend.adapters.outbound.repositories.JpaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioService {
    @Autowired
    JpaUsuarioRepository jpaUsuarioRepository;



    public void validaUsuario(UsuarioDTO usuario) {
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            //throw new ValidationException("O e-mail é obrigatório.");
        }

        if (!isEmailValido(usuario.getEmail())) {
            //throw new ValidationException("E-mail inválido. Use o formato: usuario@dominio.com");
        }
    }

    private boolean isEmailValido(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(regex);
    }
}

