package com.billshare.backend.application.services;

import com.billshare.backend.application.useCases.CheckinUseCase;
import com.billshare.backend.domain.checkinContext.CheckinRepository;
import com.billshare.backend.domain.checkinContext.dto.CheckinSummaryDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@Service
public class CheckinService implements CheckinUseCase {

    private final CheckinRepository checkinRepository;
    public CheckinService(CheckinRepository checkinRepository) {
        this.checkinRepository = checkinRepository;
    }

    @Override
    public HashMap<String, Long> contagemMensalPorUsuario(LocalDate mesReferencia) {
        LocalDateTime startOfMonth = mesReferencia.withDayOfMonth(1).atStartOfDay();
        LocalDateTime endOfMonth = mesReferencia.withDayOfMonth(mesReferencia.lengthOfMonth()).atTime(LocalTime.MAX);

        Optional<List<CheckinSummaryDTO>> checkins = checkinRepository.findAllCheckinsByUserAndMonth(startOfMonth, endOfMonth);

        HashMap<String, Long> resultado = new HashMap<>();

        checkins.ifPresent(lista -> {
            for (CheckinSummaryDTO dto : lista) {
                resultado.put(dto.getUserName(), dto.getTotalCheckins());
            }
        });

        return resultado;
    }
}
