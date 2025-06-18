package com.billshare.backend.adapters.inbound.controller.usuarioContext;

import com.billshare.backend.adapters.outbound.repositories.JpaCheckinRepository;
import com.billshare.backend.domain.checkinContext.Checkin;
import com.billshare.backend.domain.checkinContext.CheckinRepository;
import com.billshare.backend.domain.checkinContext.dto.CheckinSummaryDTO;
import com.billshare.backend.domain.userContext.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CheckinController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    CheckinRepository checkinRepository;

    @Autowired
    JpaCheckinRepository jpaCheckinRepository;

    @PostMapping("/checkin")
    public ResponseEntity<String> registerCheckin(@RequestBody Checkin checkin) {
        try {
            usuarioService.checaSeUsuarioExiste(checkin.getIdUsuario());
            checkinRepository.save(checkin);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/checkin/mensal")
    public ResponseEntity<List<CheckinSummaryDTO>> getMonthlySummary(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate month) {

        LocalDate referenceDate = (month != null) ? month : LocalDate.now();
//        return ResponseEntity.ok(checkinService.getCheckinsSummaryByMonth(referenceDate));
        return null ;
    }
}
