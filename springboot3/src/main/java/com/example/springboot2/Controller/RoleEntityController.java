package com.example.springboot2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Service.RoleServiceInterface;

import com.example.springboot2.entities.RoleEntity;

@RestController
@RequestMapping("/addRole")
public class RoleEntityController {
	
	@Autowired
	private RoleServiceInterface roleServiceInterface;
	
	@PostMapping()
	public RoleEntity role(@RequestBody RoleEntity roleEntity)
	{
		return roleServiceInterface.addRole(roleEntity); 

	}
	
	@GetMapping()
	public List<RoleEntity> roles()
	{
		return this.roleServiceInterface.getRoles();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getRolesById(@PathVariable(value="id") Long Id) {
		return this.roleServiceInterface.getRolesId(Id);
	}
	
	
	@PutMapping("/{id}")
	public RoleEntity roleEnt(@PathVariable(value="id") Long Id,@RequestBody RoleEntity roleEntity)
	{
		return this.roleServiceInterface.updateRole(Id, roleEntity);
	}

	@DeleteMapping("/{id}")
	public void Deletes(@PathVariable(value="id") Long Id,@RequestBody RoleEntity roleEntity)
	{
		this.roleServiceInterface.deleteRoll(Id,roleEntity);
	}



}
