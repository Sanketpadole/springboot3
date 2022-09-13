package com.example.springboot2.Service;

import org.springframework.stereotype.Service;

import com.example.springboot2.Dto.LoggerDto;
import com.example.springboot2.Entities.LoggerEntity;
import com.example.springboot2.Entities.Users;

@Service
public interface LoggerServiceInterface {

	void createLogger(LoggerDto loggerDto, Users users);

	void logoutUser(String token);

	LoggerEntity getLoggerDetail(String requestTokenHeader);

}
