package com.example.springboot2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.springboot2.Service.UserRoleEntityServiceInterface;
import com.example.springboot2.dto.UserRoleEntityDto;
import com.example.springboot2.entities.RoleEntity;
import com.example.springboot2.entities.UserRoleEntity;

@RestController
@RequestMapping("/URE")
public class UserRoleEntityController {
	@Autowired
	private UserRoleEntityServiceInterface userRoleEntityServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> userRoleEntities(@RequestBody UserRoleEntityDto userRoleEntityDto) {
		
		return userRoleEntityServiceInterface.addUserRoleEntity(userRoleEntityDto);

		}
	
	
	
	@GetMapping
	public List<UserRoleEntity> getusersentity() {
		return userRoleEntityServiceInterface.getuserrolls();
	}
	
	
	
	@PutMapping()
	public ResponseEntity<?> adduserrole(@RequestBody UserRoleEntityDto userRoleEntityDto){
		return userRoleEntityServiceInterface.adduserroless();
		
	}
	}
	
	
	
	
		
	


