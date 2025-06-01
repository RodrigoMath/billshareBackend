package com.billshare.backend.application.services;

import com.billshare.backend.adapters.outbound.repositories.JpaCheckinRepository;
import com.billshare.backend.domain.userContext.Checkin;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CheckinService {
    @Autowired
    JpaCheckinRepository jpaUsuarioRepository;

    /**
     * Realiza o check-in do usuário, aplicando validações de duplicidade.
     */
    public Checkin realizarCheckin(Long idUsuario) {
        return null;
    }

    /**
     * Retorna todos os check-ins de um usuário.
     */
    public List<Checkin> listarCheckins(Long idUsuario) {
        return null;
    }

    /**
     * Retorna o último check-in de um usuário.
     */
    public Optional<Checkin> buscarUltimoCheckin(Long idUsuario) {
        return null;
    }

    /**
     * Retorna todos os check-ins em um intervalo de datas.
     */
    public List<Checkin> buscarCheckinsPorPeriodo(Long idUsuario, LocalDate inicio, LocalDate fim) {
        // implementar no repository depois
        return List.of();
    }
}
