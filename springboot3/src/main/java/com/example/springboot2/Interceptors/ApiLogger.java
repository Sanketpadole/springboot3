package com.example.springboot2.Interceptors;


	
	
	import java.util.ArrayList;
	import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
	import org.springframework.web.servlet.HandlerInterceptor;

import com.example.springboot2.Dto.ErrorResponseDto;
import com.example.springboot2.Entities.ApiLoggerEntity;
import com.example.springboot2.Entities.LoggerEntity;
import com.example.springboot2.Service.ApiLoggerSerivceInterface;
import com.example.springboot2.Service.LoggerServiceInterface;
import com.google.gson.Gson;



	@Component
	public class ApiLogger implements HandlerInterceptor {

		public ApiLogger() {

			
		}

		@Autowired
		private LoggerServiceInterface loggerServiceInterface;

		@Autowired
		private ApiLoggerSerivceInterface apiLoggerSerivceInterface;

		Gson gson = new Gson();

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//			String arr = request.getRequestURI();
			
			ArrayList<String> skipUrls = new ArrayList<>(Arrays.asList("/api/v1/auth/login", "/api/v1/auth/register"));
			final String arr = request.getRequestURI();
			System.out.println("ii");
//			if (!skipUrls.contains(arr)) {
//				System.out.println("iii");

				final String token = request.getHeader("Authorization");
				if(!skipUrls.contains(arr))
				{
				System.out.println("ii4"+token);
				LoggerEntity logsDetail = loggerServiceInterface.getLoggerDetail(token);
				System.out.println("ii5");
				if (logsDetail == null) {
					System.out.println("ii6");

					ErrorResponseDto error = new ErrorResponseDto("You are not login User", "notLoginUser", new Date());
					System.out.println("ii8");
					String employeeJsonString = this.gson.toJson(error);
					System.out.println("ii9");
					response.setContentType("application/json");
					System.out.println("ii10");
					response.setCharacterEncoding("UTF-8");
					System.out.println("ii11");
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					System.out.println("ii12");
					response.getWriter().write(employeeJsonString);
					System.out.println("ii13");
					return false;

					} else {
					System.out.println("ii14");
					ApiLoggerEntity apiDetail = new ApiLoggerEntity();
					apiDetail.setUserToken(token);
					System.out.println("ii15");
					apiDetail.setIpAddress(request.getRemoteAddr());
					apiDetail.setUrl(request.getRequestURI());
					apiDetail.setMethod(request.getMethod());
					apiDetail.setHost(request.getRemoteHost());
					apiDetail.setUserToken(token);
					apiLoggerSerivceInterface.createApiLog(apiDetail);
					System.out.println("ii16");
					return true;

				}
				

				} else {
				ApiLoggerEntity apiDetail = new ApiLoggerEntity();
				System.out.println("ii13");
				apiDetail.setUserToken("");
				System.out.println("ii14");
				apiDetail.setIpAddress(request.getRemoteAddr());
				System.out.println("ii15");
				apiDetail.setUrl(request.getRequestURI());
				apiDetail.setMethod(request.getMethod());
				apiDetail.setHost(request.getRemoteHost());
				
				System.out.println("ii16");
				apiLoggerSerivceInterface.createApiLog(apiDetail);
				return true;

				

			}
		
	
		

	}
	}

	



