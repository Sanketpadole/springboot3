package com.example.springboot2.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot2.Entities.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByEmail(String email);

	Optional<Users> findByPassword(String password);
}
