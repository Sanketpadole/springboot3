package com.example.springboot2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.springboot2.Service.RolePermissionInterface;

import com.example.springboot2.dto.PermissionRequestDto;


@RestController
public class RolePermissionController {
	@Autowired
	private RolePermissionInterface rolePermissionServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> userRoleEntities(@RequestBody PermissionRequestDto permissionRequestDto) {
		
		return rolePermissionServiceInterface.addRolepermission(permissionRequestDto);

		}

}
