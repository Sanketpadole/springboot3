package com.example.springboot2.ServiceInterface;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

	public UserDetails loadUserByUsername(String email);

	public Boolean comparePassword(String password, String password2);

}
