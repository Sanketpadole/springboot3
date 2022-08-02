package com.example.springboot2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot2.dto.LoggerDto;
import com.example.springboot2.entities.LoggerEntity;

//import com.example.springboot2.entities.LoggerDto;
@Repository
public interface LoggerDtoRepository extends JpaRepository<LoggerEntity,Integer>{

	

}
