package com.billshare.backend.adapters.outbound.repositories;

import com.billshare.backend.adapters.outbound.entities.JpaUser;
import com.billshare.backend.domain.userContext.User;
import com.billshare.backend.domain.userContext.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository userRepository;
    public UserRepositoryImpl( JpaUserRepository userRepository){
        this.userRepository = userRepository;
    }

    private User convertToDomain(JpaUser jpaUser) {
        return new User();
    }

    private JpaUser convertToJpa(User user) {
        return new JpaUser();
    }

    @Override
    public Long contagemDeLoginPorMesEUsuario(Long month, Long userId){
       //return userRepository.findAllById(userId).
        return 0L;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<User> findAllActiveUsers() {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public boolean existsByEmailAndActiveTrue(String email) {
        return false;
    }
}
