package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.adapters.outbound.entities.JpaCheckin;
import com.billshare.backend.domain.checkinContext.dto.CheckinSummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaCheckinRepository extends JpaRepository<JpaCheckin,Long> {

    @Query(value = """
    SELECT u.user_name AS userName, COUNT(c.id) AS totalCheckins
    FROM usuario u
    LEFT JOIN checkin c ON c.id_usuario = u.id
    WHERE c.dia_hora_checkin BETWEEN :startOfMonth AND :endOfMonth
    GROUP BY u.user_name
    """, nativeQuery = true)
    Optional<List<CheckinSummaryDTO>> findMonthlyCheckinsNative(
            @Param("startOfMonth") LocalDateTime startOfMonth,
            @Param("endOfMonth") LocalDateTime endOfMonth
    );
}
