package com.example.springboot2.Controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.springboot2.dao.RoleEntityRepository;
import com.example.springboot2.dto.ErrorResponseDto;
import com.example.springboot2.entities.RoleEntity;
import com.example.springboot2.entities.Users;

@RestController
@RequestMapping("/addRole")
public class RoleEntityController {
	@Autowired
	private RoleEntityRepository roleEntityRepository;
	
	@Autowired
	private RoleServiceInterface roleServiceInterface;
	
	@PostMapping()
	public ResponseEntity<?>addRole(@RequestBody RoleEntity roleEntity,HttpServletRequest request){
//		String name=roleEntity.getRoleName();
//		Users users=new Users();
//		users.getId();
//		roleEntity.setId(users.getId());
//		return new ResponseEntity<>(HttpStatus.OK);
		this.roleServiceInterface.addRole(roleEntity);
		
		return new ResponseEntity<>(new ErrorResponseDto("Success","Success",roleEntity),HttpStatus.CREATED);
		
	}
			
	@GetMapping()
	public List<RoleEntity> roles()
	{
		return this.roleServiceInterface.getRoles();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getRolesById(@PathVariable(value="id") Integer Id) {
		return this.roleServiceInterface.getRolesId(Id);
	}
	
	
	@PutMapping("/{id}")
	public RoleEntity roleEnt(@PathVariable(value="id") Integer Id,@RequestBody RoleEntity roleEntity)
	{
		return this.roleServiceInterface.updateRole(Id, roleEntity);
	}

	@DeleteMapping("/{id}")
	public void Deletes(@PathVariable(value="id") Integer Id,@RequestBody RoleEntity roleEntity)
	{
		this.roleServiceInterface.deleteRoll(Id,roleEntity);
	}



}
