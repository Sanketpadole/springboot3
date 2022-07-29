package com.example.springboot2.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot2.entities.Users;

public interface UserRepo extends JpaRepository<Users,Integer>{
	Optional<Users> findByEmail(String email);
}
