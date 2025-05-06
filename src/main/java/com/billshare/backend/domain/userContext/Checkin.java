package com.billshare.backend.domain.userContext;

import java.time.LocalDateTime;

public class Checkin {

     Long id;
     LocalDateTime diaHoraCheckin;

     public Checkin(LocalDateTime diaHoraCheckin) {
          this.diaHoraCheckin = diaHoraCheckin;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public LocalDateTime getDiaHoraCheckin() {
          return diaHoraCheckin;
     }

     public void setDiaHoraCheckin(LocalDateTime diaHoraCheckin) {
          this.diaHoraCheckin = diaHoraCheckin;
     }
}
