package com.billshare.backend.domain.userContext;

import java.time.LocalDateTime;

public class Checkin {
     LocalDateTime diaHoraCheckin;

     Long id;
     Long idUsuario;

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
