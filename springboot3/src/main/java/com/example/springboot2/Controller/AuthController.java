package com.example.springboot2.Controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Security.JwtAuthResponse;
import com.example.springboot2.Security.JwtTokenHelper;
//import com.example.springboot2.dao.UserRepo;
//import com.example.springboot2.dao.UserRepository;
import com.example.springboot2.entities.JwtAuthRequest;
//import com.example.springboot2.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
//	@Autowired
//	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Autowired
//	private JwtAuthResponse jwtAuthResponse;
//	@PostMapping("/login")
//	public ResponseEntity<JwtAuthResponse>createToken(
//			@RequestBody JwtAuthRequest request){
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
////		@PostMapping("/login")
////		public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody AuthRequestDto authenticationRequest) throws Exception, ResourceNotFoundException {
//
////			try {
////
////				UserEntity userEntity = userServiceInterface.findByEmail(authenticationRequest.getEmail());
////
////				if (!userDetailsService.comparePassword(authenticationRequest.getPassword(), userEntity.getPassword())) {
////
////					return new ResponseEntity<>(new ErrorResponseDto("Invalid Credential", "invalidCreds"), HttpStatus.UNAUTHORIZED);
////				}
////				
////				System.out.println("DATa"+userEntity.getEmail());
////				final String token = jwtTokenUtil.generateToken(userEntity);
////				 
////				List<IPermissionDto> permissions = userServiceInterface.getUserPermission(userEntity.getId());
////				LoggerDto logger = new LoggerDto();
////				logger.setToken(token);
////				Calendar calender = Calendar.getInstance();
////				calender.add(Calendar.HOUR_OF_DAY, 5);
////				logger.setExpireAt(calender.getTime());
////				loggerServiceInterface.createLogger(logger, userEntity);
////				return new ResponseEntity<>(new SuccessResponseDto("Success", "success", new AuthResponseDto(token, permissions,userEntity.getEmail(),userEntity.getName(),userEntity.getId())), HttpStatus.OK);
////				
////			} catch (ResourceNotFoundException e) {
////
////				return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "userNotFound"), HttpStatus.NOT_FOUND);
////
////			}
//
////		try {
////			Users users= userRepo.findByEmail(request.getUsername());
////			String pass=passwordEncoder.encode(request.getPassword());
////			System.out.println("done");
////			this.authenticate(request.getPassword(),request.getUsername());
////			
////		
////		}
////		catch(Exception e)
////		{
////			System.out.println(e);
////		}
//		
////	@PostMapping("/login")
////		public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody AuthRequest authenticationRequest) throws Exception, ResourceNotFoundException {
//			
////			try {
////
////				Users users = this.userRepo.findByEmail(authenticationRequest.getEmail());
////
////				if (!userDetailsService.comparePassword(authenticationRequest.getPassword(), users.getPassword())) {
////
////					return new ResponseEntity<>(new ErrorResponseDto("Invalid Credential", "invalidCreds", users), HttpStatus.UNAUTHORIZED);
////				}
//	
////		this.authenticate(request.getPassword(),request.getUsername());
//		
////		@PostMapping("/login")
////		public ResponseEntity<JwtAuthResponse>createToken(@RequestBody JwtAuthRequest request)throws Exception
//				try {
//		UserDetails userDetails=this.userDetailsService.loadUserByUsername(request.getEmail());
//		
//		if (!userDetailsService.comparePassword(request.getPassword(), users.getPassword())) {
//		
//		String token=this.jwtTokenHelper.generateToken(userDetails);
//		JwtAuthResponse response=new JwtAuthResponse();
//		response.setToken(token);
//		
//		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
//	}
//				} catch (ResourceNotFoundException e) {
//				
//						return new ResponseEntity<JwtAuthResponse>( HttpStatus.NOT_FOUND);
//				
//							}}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse>createToken(
			@RequestBody JwtAuthRequest request){
		this.authenticate(request.getUsername(), request.getPassword());
		
		String password=passwordEncoder.encode(request.getPassword());
//		request.setPassword(password);
		UserDetails userDetails=this.userDetailsService.loadUserByUsername(request.getUsername());
//		UserDetails users=this.userDetailsService.loadUserByUsername(users.getUsername() );
		if(userDetails.equals(request))
		{
			
			String token=this.jwtTokenHelper.generateToken(userDetails);
			JwtAuthResponse response=new JwtAuthResponse();
			response.setToken(token);
			return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
		}else {
			throw new UsernameNotFoundException("User not found");
		}
		
		
		
//		
//		String token=this.jwtTokenHelper.generateToken(userDetails);
//		JwtAuthResponse response=new JwtAuthResponse();
//		response.setToken(token);
//		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
	}
	
	
	
	
	
	

	
	
	

	
	
	
	private void authenticate(String username,String password) {
		UsernamePasswordAuthenticationToken  authenticationToken =new UsernamePasswordAuthenticationToken(username,password);
		
		this.authenticationManager.authenticate(authenticationToken);

}
}