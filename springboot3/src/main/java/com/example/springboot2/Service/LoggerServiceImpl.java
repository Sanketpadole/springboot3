package com.example.springboot2.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
	
		@Transactional
		public void logoutUser(String token) {

			final String userToken = token.substring(7);
			
			LoggerDtoRepository.removeByToken(userToken);
		}




	

	
}
