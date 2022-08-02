package com.example.springboot2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot2.dao.LoggerDtoRepository;
import com.example.springboot2.dto.LoggerDto;
import com.example.springboot2.entities.LoggerEntity;
import com.example.springboot2.entities.Users;



@Service("LoggerServiceImpl")
public class LoggerServiceImpl implements LoggerServiceInterface {
	@Autowired
	private LoggerDtoRepository loggerDtoRepository;

		@Override
	public void createLogger(LoggerDto loggerDto, Users user) {

		LoggerEntity logger = new LoggerEntity();
		logger.setUserId(user);
		logger.setToken(loggerDto.getToken());
		logger.setExpireAt(loggerDto.getExpireAt());
		loggerDtoRepository.save(logger);

	}

	
}
