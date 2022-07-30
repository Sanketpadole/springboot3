package com.example.springboot2.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springboot2.dao.UserRepo;
import com.example.springboot2.entities.Users;
import com.example.springboot2.exception.ResourceNotFoundException;
@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from database by username
	Users users	=this.userRepo.findByEmail(username);
		System.out.println("yes");
		return users;
	}

}
