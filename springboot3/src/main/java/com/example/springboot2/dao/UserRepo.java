package com.example.springboot2.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot2.entities.Users;
@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{
	Optional<Users> findByEmail(String email);

//	Object getPassword();
	
	Optional<Users> findByPassword(String password);
}
