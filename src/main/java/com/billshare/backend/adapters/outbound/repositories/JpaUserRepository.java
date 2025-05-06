package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.adapters.outbound.entities.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<JpaUser,Long> {

}
