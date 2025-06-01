package com.billshare.backend.domain.userContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CheckinRepository
{
    Checkin save(Checkin checkin);
    Optional<List<Checkin>> findAllCheckinsByUser(long idUser);
    Optional<List<Checkin>> findByUserIdAndPeriod(long userId, LocalDate start, LocalDate end);
}
