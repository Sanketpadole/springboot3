package com.example.springboot2.Service;

import com.example.springboot2.dto.LoggerDto;
import com.example.springboot2.entities.Users;

public interface LoggerServiceInterface {

	

	void createLogger(LoggerDto loggerDto, Users users);

	void logoutUser(String token);



	

}
