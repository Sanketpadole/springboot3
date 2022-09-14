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

import com.example.springboot2.Dto.ErrorResponseDto;
import com.example.springboot2.Entities.RoleEntity;
import com.example.springboot2.Repository.RoleEntityRepository;

import com.example.springboot2.ServiceInterface.RoleService;

@RestController
@RequestMapping("/Role")
public class RoleEntityController {
	@Autowired
	private RoleEntityRepository roleEntityRepository;

	@Autowired
	private RoleService roleServiceInterface;

	@PostMapping
	public ResponseEntity<?> addRole(@RequestBody RoleEntity roleEntity, HttpServletRequest request) {

		this.roleServiceInterface.addRole(roleEntity);

		return new ResponseEntity<>(new ErrorResponseDto("Success", "Success", roleEntity), HttpStatus.CREATED);

	}

	@GetMapping
	public List<RoleEntity> roles() {
		return this.roleServiceInterface.getRoles();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getRolesById(@PathVariable(value = "id") Integer Id) {
		return this.roleServiceInterface.getRolesId(Id);
	}

	@PutMapping("/{id}")

	public ResponseEntity<?> updateRole(@PathVariable(value = "id") Integer Id, @RequestBody RoleEntity roleEntity) {
		return roleServiceInterface.updateRole(Id, roleEntity);
	}

	@DeleteMapping("/{id}")
	public void Deletes(@PathVariable(value = "id") Integer Id, @RequestBody RoleEntity roleEntity) {
		this.roleServiceInterface.deleteRoll(Id, roleEntity);
	}

}
