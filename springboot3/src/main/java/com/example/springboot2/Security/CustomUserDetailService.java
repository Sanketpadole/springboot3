package com.example.springboot2.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.example.springboot2.dao.UserRepo;

import com.example.springboot2.entities.Users;
import com.example.springboot2.exception.ResourceNotFoundException;
@Service
@Component
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from database by username
	Users users	=this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("not found"));
//	Users pass	=this.userRepo.findByPassword(password).orElseThrow(()->new ResourceNotFoundException("not found"));
//	if(username.equals(users))
//	{
		
		return users;		
//	}else {
//		throw new UsernameNotFoundException("User not found");
//	}
//	 @Override
//		 public Users save(@RequestBody JwtAuthRequest request) {
//		 Users newUser = new Users();
//		 newUser.setEmail(request.getEmail());
//		 newUser.setPassword(bcryptEncoder.encode(request.getPassword()));
		 
//		 return authRepository.save(newUser);
		 }


//	public Boolean comparePassword(String Password ,String hashpassword) {
//		return bcryptEncoder.matches(Password,hashpassword);
//	}
	
	
	
	
	{

}
}
