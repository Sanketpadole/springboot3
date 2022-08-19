package com.example.springboot2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.springboot2.Service.RolePermissionInterface;


import com.example.springboot2.dto.RolePermissionDto;
import com.example.springboot2.dto.UserRoleEntityDto;
import com.example.springboot2.entities.RolePermissionEntity;


@RestController
@RequestMapping("/{RolePermission}")
public class RolePermissionController {
	@Autowired
	private RolePermissionInterface rolePermissionServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> userRoleEntities(@RequestBody RolePermissionDto rolePermissionDto) {
		
		return rolePermissionServiceInterface.addRolepermission(rolePermissionDto);

		}
	
	
	@PutMapping
	
	public void  updateUserRole(@RequestBody RolePermissionDto rolePermissionDto){
		rolePermissionServiceInterface.update(rolePermissionDto); 

}
	
	
	@GetMapping
	public List<RolePermissionEntity>getRolePermission()
	{
		return rolePermissionServiceInterface.get();
		
	}
	
	
	@DeleteMapping
	public void DeleteRolePermission(@RequestBody RolePermissionDto rolePermissionDto) {
		rolePermissionServiceInterface.delete(rolePermissionDto);
	}
}
