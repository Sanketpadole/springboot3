package com.example.springboot2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot2.Entities.Users;
@Repository
public interface AuthRepository extends JpaRepository<Users ,Integer> {

}
