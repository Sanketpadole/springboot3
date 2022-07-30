package com.example.springboot2.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Security.JwtAuthResponse;
import com.example.springboot2.Security.JwtTokenHelper;
import com.example.springboot2.dao.UserRepo;
import com.example.springboot2.dao.UserRepository;
import com.example.springboot2.entities.JwtAuthRequest;
import com.example.springboot2.entities.Users;
import com.example.springboot2.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse>createToken(
			@RequestBody JwtAuthRequest request){

//		try {
//			Users users= userRepo.findByEmail(request.getUsername());
//			String pass=passwordEncoder.encode(request.getPassword());
//			System.out.println("done");
//			this.authenticate(request.getPassword(),request.getUsername());
//			
//		
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
	
		this.authenticate(request.getPassword(),request.getUsername());
		UserDetails userDetails=this.userDetailsService.loadUserByUsername(request.getEmail());
		String token=this.jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse response=new JwtAuthResponse();
		response.setToken(token);
		
		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
	}
	

	
	private void authenticate(String username,String password) {
		UsernamePasswordAuthenticationToken  authenticationToken =new UsernamePasswordAuthenticationToken(username,password);
		
		this.authenticationManager.authenticate(authenticationToken);

}
}