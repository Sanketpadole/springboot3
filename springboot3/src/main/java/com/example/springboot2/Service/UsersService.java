package com.example.springboot2.Service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.springboot2.entities.Users;
@Service
public interface UsersService {



	public Users addUsers(Users users);

	public List<Users> getCoursess();

}
