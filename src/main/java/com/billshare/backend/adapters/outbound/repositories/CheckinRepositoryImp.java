package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.domain.userContext.Checkin;
import com.billshare.backend.domain.userContext.CheckinRepository;

import java.time.LocalDate;
import java.util.*;

public class CheckinRepositoryImp implements CheckinRepository {

    @Override
    public Checkin save(Checkin checkin) { return null; }

    @Override
    public Optional<List<Checkin>> findAllCheckinsByUser(long idUser) { return Optional.empty(); }

    @Override
    public Optional<List<Checkin>> findByUserIdAndPeriod(long userId, LocalDate start, LocalDate end) {return Optional.empty(); }
}
