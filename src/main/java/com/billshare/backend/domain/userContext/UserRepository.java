package com.billshare.backend.domain.userContext;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Usuario save(Usuario usuario);

    boolean existsById(Long idUsuario);
}
