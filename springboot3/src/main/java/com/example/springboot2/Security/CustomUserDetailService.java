package com.example.springboot2.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.example.springboot2.dao.UserRepo;

import com.example.springboot2.entities.Users;

@Service
@Component
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		// loading user from database by username
	Users users	=this.userRepo.findByEmail(username);

		
		return users;	
	}



	
	public Boolean comparePassword(String Password ,String hashpassword) {
		
		return passwordEncoder.matches(Password, hashpassword);
	}
	
	
	
	
	{

}
}
