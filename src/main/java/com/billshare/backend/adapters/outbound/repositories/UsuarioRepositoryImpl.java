package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.adapters.outbound.entities.JpaUsuario;
import com.billshare.backend.domain.userContext.Usuario;
import com.billshare.backend.domain.userContext.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UserRepository {

    private final JpaUsuarioRepository userRepository;
    public UsuarioRepositoryImpl(JpaUsuarioRepository userRepository){
        this.userRepository = userRepository;
    }

    private Usuario convertToDomain(JpaUsuario jpaUser) {
        return new Usuario();
    }

    private JpaUsuario convertToJpa(Usuario usuario) {
        return new JpaUsuario();
    }

    @Override
    public Long contagemDeLoginPorMesEUsuario(Long month, Long userId){
       //return userRepository.findAllById(userId).
        return 0L;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return null;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<Usuario> findAllActiveUsers() {
        return null;
    }

    @Override
    public void delete(Usuario usuario) {

    }

    @Override
    public boolean existsByEmailAndActiveTrue(String email) {
        return false;
    }
}
