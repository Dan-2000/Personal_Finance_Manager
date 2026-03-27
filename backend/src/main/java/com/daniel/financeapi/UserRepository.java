package com.daniel.financeapi;
import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.financeapi.model.User;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}