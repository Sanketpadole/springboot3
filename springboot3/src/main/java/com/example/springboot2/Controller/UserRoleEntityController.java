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

import com.example.springboot2.Dto.UserRoleEntityDto;
import com.example.springboot2.Entities.UserRoleEntity;

import com.example.springboot2.ServiceInterface.UserRoleEntityService;

@RestController
@RequestMapping("/UserRoleEntity")
public class UserRoleEntityController {
	@Autowired
	private UserRoleEntityService userRoleEntityServiceInterface;

	@PostMapping
	public ResponseEntity<?> userRoleEntities(@RequestBody UserRoleEntityDto userRoleEntityDto) {

		return userRoleEntityServiceInterface.addUserRoleEntity(userRoleEntityDto);

	}

	@GetMapping
	public List<UserRoleEntity> getusersentity() {
		return userRoleEntityServiceInterface.getuserrolls();
	}

	@PutMapping
	public void updateUserRole(@RequestBody UserRoleEntityDto userRoleEntityDto) {
		userRoleEntityServiceInterface.update(userRoleEntityDto);

	}

	@DeleteMapping
	public void Delete(@RequestBody UserRoleEntityDto userRoleEntityDto) {
		userRoleEntityServiceInterface.delete(userRoleEntityDto);
	}

}
