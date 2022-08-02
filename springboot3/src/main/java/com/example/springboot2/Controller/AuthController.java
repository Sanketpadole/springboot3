package com.example.springboot2.Controller;




import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Security.CustomUserDetailService;
import com.example.springboot2.Security.JwtAuthResponse;
import com.example.springboot2.Security.JwtTokenHelper;
import com.example.springboot2.Service.LoggerServiceImpl;
import com.example.springboot2.dao.UserRepo;
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
	
	

	
	
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken( @RequestBody JwtAuthRequest authenticationRequest) throws Exception, ResourceNotFoundException {

		try {

			Users users = userRepo.findByEmail(authenticationRequest.getEmail());

			if (this.customUserDetailService.comparePassword(authenticationRequest.getPassword(), users.getPassword())) {

		
			
			System.out.println("DATa"+users.getEmail());
			
			this.customUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
			
			String token=this.jwtTokenHelper.generateToken(users);	
			LoggerDto dto =new LoggerDto();
			dto.setToken(token);
			dto.setExpireAt(new Date());
			
			
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
	
	
//
//	@PostMapping("/login")
//	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody AuthRequestDto authenticationRequest) throws Exception, ResourceNotFoundException {
//
//		try {
//
//			UserEntity userEntity = userServiceInterface.findByEmail(authenticationRequest.getEmail());
//
//			if (!userDetailsService.comparePassword(authenticationRequest.getPassword(), userEntity.getPassword())) {
//
//				return new ResponseEntity<>(new ErrorResponseDto("Invalid Credential", "invalidCreds"), HttpStatus.UNAUTHORIZED);
//			}
//			
//			System.out.println("DATa"+userEntity.getEmail());
//			final String token = jwtTokenUtil.generateToken(userEntity);
//			 
//			List<IPermissionDto> permissions = userServiceInterface.getUserPermission(userEntity.getId());
//			LoggerDto logger = new LoggerDto();
//			logger.setToken(token);
//			Calendar calender = Calendar.getInstance();
//			calender.add(Calendar.HOUR_OF_DAY, 5);
//			logger.setExpireAt(calender.getTime());
//			loggerServiceInterface.createLogger(logger, userEntity);
//			return new ResponseEntity<>(new SuccessResponseDto("Success", "success", new AuthResponseDto(token, permissions,userEntity.getEmail(),userEntity.getName(),userEntity.getId())), HttpStatus.OK);
//			
//		} catch (ResourceNotFoundException e) {
//
//			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "userNotFound"), HttpStatus.NOT_FOUND);
//
//		}
//	
	
	
	
	
	

	
	
	

	
	
	
	private void authenticate(String username,String password) {
		UsernamePasswordAuthenticationToken  authenticationToken =new UsernamePasswordAuthenticationToken(username,password);
		
		this.authenticationManager.authenticate(authenticationToken);

}
}