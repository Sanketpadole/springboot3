package com.example.springboot2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot2.Entities.ApiLoggerEntity;
@Repository
public interface ApiLoggerRepository extends JpaRepository<ApiLoggerEntity,Integer>{

}
