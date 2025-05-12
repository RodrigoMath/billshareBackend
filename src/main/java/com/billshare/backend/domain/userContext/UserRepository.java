package com.billshare.backend.domain.userContext;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    List<User> findAllActiveUsers();
    void delete(User user);

    Long contagemDeLoginPorMesEUsuario(Long month, Long userId);
    boolean existsByEmailAndActiveTrue(String email);
}
