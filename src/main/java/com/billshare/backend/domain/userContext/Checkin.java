package com.billshare.backend.domain.userContext;

import java.time.LocalDateTime;

public class Checkin {
     LocalDateTime diaHoraCheckin;

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
