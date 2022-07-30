package com.example.springboot2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot2.entities.Users;
@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{

}
