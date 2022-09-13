package com.example.springboot2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot2.Entities.ApiLoggerEntity;
import com.example.springboot2.Repository.ApiLoggerRepository;
@Service
public class ApiLoggerServiceImpl implements ApiLoggerSerivceInterface {

	
	@Autowired
	private ApiLoggerRepository apiLoggerRepository;
	
	
	@Override
	public void createApiLog(ApiLoggerEntity api) {
		apiLoggerRepository.save(api);
		
		
	}

}







//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.springboot2.Entities.ApiLoggerEntity;
//import com.example.springboot2.Repository.ApiLoggerRepository;
//
//@Service("apiLoggerServiceImpl")
//	public class ApiLoggerServiceImpl implements ApiLoggerSerivceInterface {
//
//		public ApiLoggerServiceImpl() {
//
//			
//		}
//
//		@Autowired
//		private ApiLoggerRepository apiLoggerRepository;
//
//		public void createApiLog(ApiLoggerEntity api) {
//
//			apiLoggerRepository.save(api);
//
//		}
//
//	}
