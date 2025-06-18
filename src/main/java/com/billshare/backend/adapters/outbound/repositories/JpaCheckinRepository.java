package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.adapters.outbound.entities.JpaCheckin;
import com.billshare.backend.domain.checkinContext.dto.CheckinSummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaCheckinRepository extends JpaRepository<JpaCheckin,Long> {

    @Query(value = "SELECT u.user_name as userName, COUNT(c.id) as totalCheckins " +
            "FROM checkin c " +
            "JOIN usuario u ON c.id_usuario = u.id " +
            "WHERE EXTRACT(YEAR FROM c.dia_hora_checkin) = EXTRACT(YEAR FROM CURRENT_DATE) " +
            "AND EXTRACT(MONTH FROM c.dia_hora_checkin) = EXTRACT(MONTH FROM CURRENT_DATE) " +
            "GROUP BY u.user_name",
            nativeQuery = true)
    List<CheckinSummaryDTO> findMonthlyCheckinsNative();
}
