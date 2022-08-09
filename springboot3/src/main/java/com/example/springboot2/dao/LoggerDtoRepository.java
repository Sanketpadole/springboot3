package com.example.springboot2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.springboot2.entities.LoggerEntity;


@Repository
public interface LoggerDtoRepository extends JpaRepository<LoggerEntity,Integer>{

	static void removeByToken(String userToken) {
		// TODO Auto-generated method stub
		
	}

	

}
