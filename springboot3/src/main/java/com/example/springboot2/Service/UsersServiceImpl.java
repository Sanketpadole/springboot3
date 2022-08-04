package com.example.springboot2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springboot2.dao.UserRepo;


import com.example.springboot2.entities.Users;
@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public UsersServiceImpl() {
 
	}
	@Override
	public Users addUsers(Users users) {		
		// TODO Auto-generated method stub
		
		
		String password=passwordEncoder.encode(users.getPassword());	
	
		users.setPassword(password);
		
		return userRepo.save(users);
		
	}
	@Override
	public List<Users> getCoursess() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}


}


