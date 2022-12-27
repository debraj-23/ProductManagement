package com.cts.Productmanagement.repository;

import com.cts.Productmanagement.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Merchant, Long> {
    Boolean existsByEmail(String email);
    Optional<Merchant> findByEmail(String email);
}