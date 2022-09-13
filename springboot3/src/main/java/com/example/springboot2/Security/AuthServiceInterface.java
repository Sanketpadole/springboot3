package com.example.springboot2.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.springboot2.Dto.UserDto;
import com.example.springboot2.Entities.Users;
@Service
public interface AuthServiceInterface {

	public UserDetails loadUserByUsername(String email);



}
