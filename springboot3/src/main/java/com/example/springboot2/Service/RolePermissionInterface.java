package com.example.springboot2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.dto.PermissionRequestDto;
import com.example.springboot2.dto.RolePermissionDto;
import com.example.springboot2.dto.UserRoleEntityDto;
import com.example.springboot2.entities.RolePermissionEntity;

@Service
public interface RolePermissionInterface {

	ResponseEntity<?> addRolepermission(PermissionRequestDto permissionRequestDto);

	ResponseEntity<?> addRolepermission(RolePermissionDto rolePermissionDto);

//	void update(UserRoleEntityDto userRoleEntityDto);

	void update(RolePermissionDto rolePermissionDto);

	List<RolePermissionEntity> get();

	void delete(RolePermissionDto rolePermissionDto);

	void DeleteRolePermission(RolePermissionDto rolePermissionDto);

	ArrayList<String> getPermissionByUserId(int id);

	ArrayList<String> getPermissionByUserId(Integer Id);

}
