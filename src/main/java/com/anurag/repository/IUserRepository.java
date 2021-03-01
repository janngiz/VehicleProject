package com.anurag.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

  Optional<User>	findByUsername(String username);
}
