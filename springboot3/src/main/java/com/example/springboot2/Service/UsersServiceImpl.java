package com.example.springboot2.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springboot2.Dto.UserDto;
import com.example.springboot2.Entities.Users;
import com.example.springboot2.Repository.UserRepo;
import com.example.springboot2.ServiceInterface.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper modelMapper;

	public UsersServiceImpl() {

	}

	@Override
	public List<Users> getCoursess() {

		return userRepo.findAll();
	}

	private Users dtoToUser(UserDto userDto) {
		// convert dto to user --1 add source class?,class object add
		Users user = this.modelMapper.map(userDto, Users.class);
		return user;
	}

	private UserDto userToDto(Users user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public UserDto addusers(UserDto userDto) {
		Users users = this.dtoToUser(userDto);
		String password = passwordEncoder.encode(userDto.getPassword());

		users.setEmail(userDto.getEmail());

		users.setUsername(userDto.getUsername());
		users.setPassword(password);

		Users user = userRepo.save(users);
		return userToDto(user);
	}

}
