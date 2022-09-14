package com.example.springboot2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot2.Entities.LoggerEntity;

@Repository
public interface LoggerDtoRepository extends JpaRepository<LoggerEntity, Integer> {

	static void removeByToken(String userToken) {

	}

	LoggerEntity findByToken(String token);

}
