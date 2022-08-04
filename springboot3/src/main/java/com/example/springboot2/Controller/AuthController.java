package com.example.springboot2.Controller;




import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Security.CustomUserDetailService;
import com.example.springboot2.Security.JwtAuthResponse;
import com.example.springboot2.Security.JwtTokenHelper;
import com.example.springboot2.Service.LoggerServiceImpl;
import com.example.springboot2.Service.LoggerServiceInterface;
import com.example.springboot2.dao.UserRepo;
import com.example.springboot2.dto.ErrorResponseDto;
import com.example.springboot2.dto.LoggerDto;
import com.example.springboot2.entities.JwtAuthRequest;
import com.example.springboot2.entities.Users;

import com.example.springboot2.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1/auth")	
public class AuthController {
	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private LoggerServiceImpl loggerServiceImpl;
	
	

	
	
	@Transactional
	@RequestMapping(value = "/logout",method = RequestMethod.POST)
	public ResponseEntity<?> logoutUser(@RequestHeader("Authorization") String token, HttpServletRequest request) throws Exception {

		loggerServiceImpl.logoutUser(token);
		
	return new ResponseEntity<>(new ErrorResponseDto("Logout Successfully", "logoutSuccess",request), HttpStatus.OK);

		}
	
	
	@PostMapping("/log")
	public ResponseEntity<?> createAuthenticationToken( @RequestBody JwtAuthRequest authenticationRequest) throws Exception, ResourceNotFoundException {

		try {

			Users users = userRepo.findByEmail(authenticationRequest.getEmail());

			if (this.customUserDetailService.comparePassword(authenticationRequest.getPassword(), users.getPassword())) {

		
			
//			System.out.println("DATa"+users.getEmail());
			
			this.customUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
			
			String token=this.jwtTokenHelper.generateToken(users);	
			LoggerDto dto =new LoggerDto();
			dto.setToken(token);
			Calendar calendar=Calendar.getInstance();
			calendar.add(calendar.MINUTE, 50);
			
			dto.setExpireAt(calendar.getTime());
			
			
			this.loggerServiceImpl.createLogger(dto, users);
			
			JwtAuthResponse response=new JwtAuthResponse();
			
			
			
			response.setToken(token);
			
			
			return  new ResponseEntity<>(response,HttpStatus.OK);
			}
		
		
		
		
		}catch(Exception e) {
		System.out.println("error ____________");	
		}
		return ResponseEntity.ok(HttpStatus.CREATED);
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}
	
	

	
	
	
	
	
	

	
	
	

	
	
	
	private void authenticate(String username,String password) {
		UsernamePasswordAuthenticationToken  authenticationToken =new UsernamePasswordAuthenticationToken(username,password);
		
		this.authenticationManager.authenticate(authenticationToken);

}
}