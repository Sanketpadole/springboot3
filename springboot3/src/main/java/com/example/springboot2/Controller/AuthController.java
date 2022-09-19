package com.example.springboot2.Controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Dto.ErrorResponseDto;
import com.example.springboot2.Dto.LoggerDto;
import com.example.springboot2.Dto.UserDto;
import com.example.springboot2.Entities.JwtAuthRequest;
import com.example.springboot2.Entities.Users;
import com.example.springboot2.Exception.ResourceNotFoundException;
import com.example.springboot2.Repository.UserRepo;

import com.example.springboot2.Security.JwtAuthResponse;
import com.example.springboot2.Security.JwtTokenHelper;
import com.example.springboot2.Service.LoggerServiceImpl;
import com.example.springboot2.ServiceInterface.AuthService;
import com.example.springboot2.ServiceInterface.UsersService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthService customUserDetailService;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private LoggerServiceImpl loggerServiceImpl;

	@Autowired
	private UsersService usersService;

	@Autowired
	private AuthService authServiceInterface;

	@Transactional
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<?> logoutUser(@RequestHeader("Authorization") String token, HttpServletRequest request)
			throws Exception {

		loggerServiceImpl.logoutUser(token);

		return new ResponseEntity<>(new ErrorResponseDto("Logout Successfully", "logoutSuccess", request),
				HttpStatus.OK);

	}

	@PostMapping("/register")

	public UserDto addusers(@RequestBody UserDto userDto) {
		return usersService.addusers(userDto);
	}

	@PostMapping("/login")

	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthRequest authenticationRequest)
			throws Exception, ResourceNotFoundException {

		try {

			System.out.println("Email" + authenticationRequest.getEmail());
			Users users = userRepo.findByEmail(authenticationRequest.getEmail());
			System.out.println("user"+users);

			if (this.authServiceInterface.comparePassword(authenticationRequest.getPassword(), users.getPassword())) {
				System.out.println("token1");
				String token = this.jwtTokenHelper.generateToken(users);
				System.out.println("token"+token);

				LoggerDto dto = new LoggerDto();
				dto.setToken(token);
				Calendar calendar = Calendar.getInstance();
				calendar.add(calendar.MINUTE, 50);

				dto.setExpireAt(calendar.getTime());

				this.loggerServiceImpl.createLogger(dto, users);

				JwtAuthResponse response = new JwtAuthResponse();

				response.setToken(token);

				return new ResponseEntity<>(response, HttpStatus.OK);
			}

		} catch (Exception e) {
			System.out.println("Email or Password Does Not match");
		}

		return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);

	}

	private void authenticate(String username, String password) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);

		this.authenticationManager.authenticate(authenticationToken);

	}
}
