package com.vafaill.flightboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vafaill.flightboot.model.concrete.user.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    // rest is Auto-implemented by Spring CrudRepository
}
