package com.example.springboot2.ServiceInterface;

import org.springframework.stereotype.Service;

import com.example.springboot2.Entities.ApiLoggerEntity;
@Service
public interface ApiLoggerSerivce {

	public void createApiLog(ApiLoggerEntity apiDetail);
		
		
}
	


