package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.adapters.outbound.entities.JpaCheckin;
import com.billshare.backend.domain.checkinContext.Checkin;
import com.billshare.backend.domain.checkinContext.CheckinRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class CheckinRepositoryImpl implements CheckinRepository {
    private final JpaCheckinRepository jpaCheckinRepository;

    public CheckinRepositoryImpl(JpaCheckinRepository jpaCheckinRepository) {
        this.jpaCheckinRepository = jpaCheckinRepository;
    }

    public JpaCheckin convertToJpa(Checkin checkin) {
        return new JpaCheckin(checkin.getIdUsuario(), checkin.getDiaHoraCheckin());
    }



    @Override
    public void save(Checkin checkin) {
        jpaCheckinRepository.save(convertToJpa(checkin));
    }

    @Override
    public Optional<List<Checkin>> findAllCheckinsByUserAndMonth(long idUsuario, LocalDate mesAno) {
        return Optional.empty();
    }
}
