package com.example.springboot2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot2.entities.RoleEntity;

public interface RoleEntityRepository extends JpaRepository<RoleEntity,Long> {

}
