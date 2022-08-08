package com.example.springboot2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Service.UserRoleEntityServiceInterface;
import com.example.springboot2.entities.UserRoleEntity;
import com.example.springboot2.entities.Users;
@RestController
@RequestMapping("/URE")
public class UserRoleEntityController {
	@Autowired
	private UserRoleEntityServiceInterface userRoleEntityServiceInterface;
	
	@PostMapping()
	public void userRoleEntities(@RequestBody UserRoleEntity userRoleEntity) {
		 userRoleEntityServiceInterface.addUserRoleEntity(userRoleEntity);

		
				
	}
	
		
	

}
