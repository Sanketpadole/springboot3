package com.example.springboot2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot2.Entities.ApiLoggerEntity;
import com.example.springboot2.Repository.ApiLoggerRepository;
import com.example.springboot2.ServiceInterface.ApiLoggerSerivce;

@Service
public class ApiLoggerServiceImpl implements ApiLoggerSerivce {

	@Autowired
	private ApiLoggerRepository apiLoggerRepository;

	@Override
	public void createApiLog(ApiLoggerEntity apiDetail) {

		apiLoggerRepository.save(apiDetail);

	}

}
