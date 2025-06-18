package com.billshare.backend.adapters.outbound.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "checkin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JpaCheckin {
    public JpaCheckin(Long idUsuario, LocalDateTime diaHoraCheckin){
        this.idUsuario = idUsuario;
        this.diaHoraCheckin = diaHoraCheckin;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long idUsuario;

    LocalDateTime diaHoraCheckin;
}
