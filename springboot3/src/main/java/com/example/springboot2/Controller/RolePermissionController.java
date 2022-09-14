package com.example.springboot2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.Dto.RolePermissionDto;
import com.example.springboot2.Entities.RolePermissionEntity;

import com.example.springboot2.ServiceInterface.RolePermissionService;

@RestController
@RequestMapping("/RolePermission")
public class RolePermissionController {
	@Autowired
	private RolePermissionService rolePermissionServiceInterface;

	@PostMapping
	public ResponseEntity<?> userRoleEntities(@RequestBody RolePermissionDto rolePermissionDto) {
		try {

			RolePermissionDto permissionDto = rolePermissionServiceInterface.addRolepermission(rolePermissionDto);

			return new ResponseEntity<>(permissionDto, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("error ");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping
	public List<RolePermissionEntity> getRolePermission() {
		return rolePermissionServiceInterface.get();

	}

//	@GetMapping("/{id}")
//	public ResponseEntity<?> getPermissionByUserId(@PathVariable("id") Integer id) {
//
//		ArrayList<String> user = this.rolePermissionServiceInterface.getPermissionByUserId(id);
//
//		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
//
//	}

	@PutMapping

	public void updateUserRole(@RequestBody RolePermissionDto rolePermissionDto) {
		rolePermissionServiceInterface.update(rolePermissionDto);

	}

	@DeleteMapping
	public void DeleteRolePermission(@RequestBody RolePermissionDto rolePermissionDto) {
		rolePermissionServiceInterface.delete(rolePermissionDto);
	}

}
