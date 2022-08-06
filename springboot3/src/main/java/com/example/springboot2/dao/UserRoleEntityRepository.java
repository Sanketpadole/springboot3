package com.example.springboot2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot2.entities.UserRoleEntity;

public interface UserRoleEntityRepository extends JpaRepository<UserRoleEntity,Long> {

}
