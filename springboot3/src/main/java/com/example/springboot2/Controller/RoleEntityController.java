package com.example.springboot2.Controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Service.RoleServiceInterface;
import com.example.springboot2.dao.RoleEntityRepository;
import com.example.springboot2.dto.ErrorResponseDto;
import com.example.springboot2.dto.IRoleListDto;
import com.example.springboot2.dto.ListResponseDto;
import com.example.springboot2.dto.RolePermissionDto;
import com.example.springboot2.entities.RoleEntity;
import com.example.springboot2.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/addRole")
public class RoleEntityController {
	@Autowired
	private RoleEntityRepository roleEntityRepository;
	
	@Autowired
	private RoleServiceInterface roleServiceInterface;
	
	
	@Autowired
	private RolePermissionDto rolePermissionDto;
	
	@PostMapping()
	public ResponseEntity<?>addRole(@RequestBody RoleEntity roleEntity,HttpServletRequest request){

		this.roleServiceInterface.addRole(roleEntity);
		
		return new ResponseEntity<>(new ErrorResponseDto("Success","Success",roleEntity),HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/permission/{id}")
	public ResponseEntity<?> getRolePermissionById(@PathVariable(value="id") Integer roleId){
		try {
			RolePermissionDto rolePermissionData=roleServiceInterface.getRoleAndPermissionById(roleId);
			return new ResponseEntity<>(new ErrorResponseDto("success","success",rolePermissionData),HttpStatus.OK);
		}catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),"roleNotFound","notfound"),HttpStatus.OK);
		}
	}
	
	
	
	@PreAuthorize("hasRole('getAllRole')")
	@GetMapping()
	public ResponseEntity<?> getAllRoles(@RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "1") String pageNo, @RequestParam(defaultValue = "25") String size) {

		Page<IRoleListDto> roles = roleServiceInterface.getAllRoles(search, pageNo, size);

		if (roles.getTotalElements() != 0) {

			return new ResponseEntity<>(new ErrorResponseDto("Success", "success", new ListResponseDto()), HttpStatus.OK);

		}

		return new ResponseEntity<>(new ErrorResponseDto("Data Not Found", "dataNotFound","not found"), HttpStatus.NOT_FOUND);

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
