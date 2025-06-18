package com.billshare.backend.domain.checkinContext;

import com.billshare.backend.domain.checkinContext.Checkin;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CheckinRepository
{
    void save(Checkin checkin);
    Optional<List<Checkin>> findAllCheckinsByUserAndMonth(long idUsuario, LocalDate mesAno);

}
