package com.example.springboot2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springboot2.Dto.UserDto;
import com.example.springboot2.Entities.Users;
import com.example.springboot2.Repository.UserRepo;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UsersServiceImpl() {

	}



	@Override
	public List<Users> getCoursess() {

		return userRepo.findAll();
	}

	@Override
	public Users addusers(UserDto userDto) {
		String password = passwordEncoder.encode(userDto.getPassword());
		Users users=new Users();
		users.setEmail(userDto.getEmail());
		
		users.setUsername(userDto.getUsername());
		users.setPassword(password);
		
		

		return userRepo.save(users);
	}

}
