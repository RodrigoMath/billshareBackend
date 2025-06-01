package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.adapters.outbound.entities.JpaCheckin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCheckinRepository extends JpaRepository<JpaCheckin,Long> {
}
