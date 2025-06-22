package com.billshare.backend.adapters.inbound.controller.usuarioContext;

import com.billshare.backend.adapters.outbound.repositories.JpaCheckinRepository;
import com.billshare.backend.application.useCases.CheckinUseCase;
import com.billshare.backend.application.useCases.EmailUseCase;
import com.billshare.backend.application.useCases.UsuarioUseCase;
import com.billshare.backend.domain.checkinContext.Checkin;
import com.billshare.backend.domain.checkinContext.CheckinRepository;
import com.billshare.backend.domain.checkinContext.dto.CheckinSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CheckinController {

    @Autowired
    UsuarioUseCase usuarioUseCase;

    @Autowired
    CheckinRepository checkinRepository;

    @Autowired
    CheckinUseCase checkinUseCase;

    @Autowired
    EmailUseCase emailUseCase;

    @PostMapping("/checkin")
    public ResponseEntity<String> registerCheckin(@RequestBody Checkin checkin) {
        try {
            usuarioUseCase.checaSeUsuarioExiste(checkin.getIdUsuario());
            checkinRepository.save(checkin);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/checkin/mensal")
    public ResponseEntity<List<CheckinSummaryDTO>> getMonthlySummary(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate month) {

        try {
            LocalDate referenceDate = (month != null) ? month : LocalDate.now();
            HashMap<String, Long> usuarioCheckins = checkinUseCase.contagemMensalPorUsuario(referenceDate);
            if (usuarioCheckins.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            emailUseCase.enviarEmailComRelatorioMensal(usuarioCheckins);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
