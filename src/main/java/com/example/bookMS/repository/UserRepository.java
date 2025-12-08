// src/main/java/com/example/bookMS/repository/UserRepository.java
package com.example.bookMS.repository;

import com.example.bookMS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
