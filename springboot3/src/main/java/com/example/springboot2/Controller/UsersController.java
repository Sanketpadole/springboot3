package com.example.springboot2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Service.UsersService;
import com.example.springboot2.Service.UsersServiceImpl;
import com.example.springboot2.entities.Users;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@PostMapping
	public Users getUsers(@RequestBody Users users)
	{
		return usersService.addUsers(users);
		
	}

}
