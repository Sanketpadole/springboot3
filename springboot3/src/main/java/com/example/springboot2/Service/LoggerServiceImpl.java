package com.example.springboot2.Service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot2.Dto.LoggerDto;
import com.example.springboot2.Entities.LoggerEntity;
import com.example.springboot2.Entities.Users;
import com.example.springboot2.Repository.LoggerDtoRepository;

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

	@Override
	public LoggerEntity getLoggerDetail(String token) {
//		LoggerEntity logger;
//
//		if (!cache.isKeyExist(token, token)) {

			LoggerEntity logger = loggerDtoRepository.findByToken(token);
//			cache.addInCache(token, token, logger);
//
//		} else {
//
//			logger = (LoggerEntity) cache.getFromCache(token, token);
//
//		}
//
//		return logger;// loggerRepository.findByToken(token);
//
//	}
			return logger;

}
}
