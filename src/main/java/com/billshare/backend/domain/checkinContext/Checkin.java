package com.billshare.backend.domain.checkinContext;

import com.billshare.backend.adapters.outbound.repositories.JpaCheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Checkin {
     LocalDateTime diaHoraCheckin;

     Long id;
     Long idUsuario;

    public Checkin() {
        this.diaHoraCheckin = LocalDateTime.now();
    }

    public Checkin(Long idUsuario) {
        this();
        this.idUsuario = idUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Checkin(LocalDateTime diaHoraCheckin) {
          this.diaHoraCheckin = diaHoraCheckin;
     }

     public LocalDateTime getDiaHoraCheckin() {
          return diaHoraCheckin;
     }

     public void setDiaHoraCheckin(LocalDateTime diaHoraCheckin) {
          this.diaHoraCheckin = diaHoraCheckin;
     }
}
