package com.example.cars_dealership.repository;

import com.example.cars_dealership.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAdresseEmail(String adresseEmail);
    Optional<User> findById(Long id_user);
}
