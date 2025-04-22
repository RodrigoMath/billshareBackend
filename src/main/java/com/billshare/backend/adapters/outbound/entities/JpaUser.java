package com.billshare.backend.adapters.outbound.entities;

import com.billshare.backend.domain.user.EUserPlan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class JpaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    boolean active;
    String email;
    List<String> emails;
    String password;
    EUserPlan plano;
}
