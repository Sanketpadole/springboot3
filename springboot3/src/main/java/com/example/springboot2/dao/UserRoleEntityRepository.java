package com.example.springboot2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot2.entities.UserRoleEntity;
@Repository
public interface UserRoleEntityRepository extends JpaRepository<UserRoleEntity,Integer> {

}
