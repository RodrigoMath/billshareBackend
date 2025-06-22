package com.billshare.backend.domain.checkinContext;

import com.billshare.backend.domain.checkinContext.Checkin;
import com.billshare.backend.domain.checkinContext.dto.CheckinSummaryDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CheckinRepository
{
    void save(Checkin checkin);
    Optional<List<CheckinSummaryDTO>> findAllCheckinsByUserAndMonth(LocalDateTime dataInicio, LocalDateTime dataFim);

}
