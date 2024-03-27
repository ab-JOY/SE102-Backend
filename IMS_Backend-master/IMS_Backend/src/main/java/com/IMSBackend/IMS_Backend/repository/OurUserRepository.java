package com.IMSBackend.IMS_Backend.repository;

import com.IMSBackend.IMS_Backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OurUserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String Email);
}
