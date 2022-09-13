package com.example.springboot2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Entities.Users;
import com.example.springboot2.Service.UsersService;

@RestController
@RequestMapping("/ghh")
public class UsersController {
	@Autowired
	private UsersService usersService;



	@GetMapping("/users")
	public List<Users> getCoursess() {
		return this.usersService.getCoursess();
	}

}
