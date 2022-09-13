package com.example.springboot2.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot2.Dto.UserDto;
import com.example.springboot2.Entities.Users;

@Service
public interface UsersService {



	public List<Users> getCoursess();

	public Users addusers(UserDto userDto);

}
