package com.example.springboot2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springboot2.dao.UserRepository;
import com.example.springboot2.entities.Course;
import com.example.springboot2.entities.Users;
@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public UsersServiceImpl() {

	}
	@Override
	public Users addUsers(Users users) {
		// TODO Auto-generated method stub
		
		String password=passwordEncoder.encode(users.getPassword());
		users.setPassword(password);
		return userRepository.save(users);
		
	}


}


