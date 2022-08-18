package com.example.springboot2.Controller;

import java.util.List;

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

import com.example.springboot2.Service.PermissionServiceInterface;
import com.example.springboot2.dto.ErrorResponseDto;
import com.example.springboot2.dto.PermissionRequestDto;
import com.example.springboot2.entities.PermissionEntity;
import com.example.springboot2.exception.ResourceNotFoundException;
@RestController
@RequestMapping("/permission")
public class PermissionController{
	@Autowired
	private PermissionServiceInterface permissionServiceInterface;
	
	@PostMapping()
	public ResponseEntity<?> Permission(@RequestBody PermissionRequestDto permissionBody  ){
		return permissionServiceInterface.addPermission(permissionBody);
		
	}
	
	
	@PutMapping("/{id}")
	public  ResponseEntity<?>editPermission(@PathVariable(value="id")Integer permissionId, @RequestBody PermissionRequestDto permissionBody)throws ResourceNotFoundException{
		try {
			permissionServiceInterface.editPermission(permissionBody,permissionId);
			return new ResponseEntity<>(new ErrorResponseDto("success","success",null),HttpStatus.OK);
		}catch(ResourceNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),"permissionNotFound","not Found"),HttpStatus.NOT_FOUND);
		}
	}
		
		
		
		
	@DeleteMapping("/{id}")
	 public ResponseEntity<?> editEntity(@PathVariable(value="id") Integer permissionId) throws ResourceNotFoundException{
		 try {
			 permissionServiceInterface.deletePermission(permissionId);
			 return new ResponseEntity<>(new ErrorResponseDto("success","success",null),HttpStatus.OK);
		 }catch (ResourceNotFoundException e) {
			 return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),"permissionNotFound","permission not found"),HttpStatus.NOT_FOUND);
		 }
	}
	
	
	
	
	@GetMapping
	public List <PermissionEntity> getpermission(){
		return permissionServiceInterface.getpermissions();
		
	}
	}
		

	
		
	
	
