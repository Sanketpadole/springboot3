package com.example.springboot2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springboot2.Service.UserRoleEntityServiceInterface;
import com.example.springboot2.entities.UserRoleEntity;

public class UserRoleEntityController {
	@Autowired
	private UserRoleEntityServiceInterface userRoleEntityServiceInterface;
	
	@PostMapping()
	public UserRoleEntity userRoleEntities(@RequestBody UserRoleEntity userRoleEntity) {
		return userRoleEntityServiceInterface.addUserRoleEntity(userRoleEntity);
	}
	
		
	

}
