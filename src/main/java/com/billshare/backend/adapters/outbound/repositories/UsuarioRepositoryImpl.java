package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.adapters.outbound.entities.JpaUsuario;
import com.billshare.backend.domain.userContext.Usuario;
import com.billshare.backend.domain.userContext.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UserRepository {

    private final JpaUsuarioRepository jpaUsuarioRepository;
    public UsuarioRepositoryImpl(JpaUsuarioRepository userRepository){
        this.jpaUsuarioRepository = userRepository;
    }

    private JpaUsuario convertToJpa(Usuario usuario) {
        return new JpaUsuario(usuario.getUserName(), usuario.getEmail());
    }

    @Override
    public Usuario save(Usuario usuario) {
        JpaUsuario savedJpaUsuario = jpaUsuarioRepository.save(convertToJpa(usuario));
        return new Usuario(
                savedJpaUsuario.getId(),
                savedJpaUsuario.getUserName(),
                savedJpaUsuario.getEmail()
        );
    }

    @Override
    public boolean existsById(Long idUsuario) {
        return jpaUsuarioRepository.existsById(idUsuario);
    }

}
