package com.example.springboot2.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.dto.PermissionRequestDto;
import com.example.springboot2.entities.PermissionEntity;
@Service
public interface PermissionServiceInterface {

	ResponseEntity<?> addPermission(PermissionRequestDto permissionBody);

	ResponseEntity<?> updatepermission(PermissionRequestDto permissionBody);

	
	PermissionEntity updatethepermission(PermissionRequestDto permissionBody);

	PermissionEntity updatethepermission();

	void editPermission(PermissionRequestDto permissionBody, Integer permissionId);

	void deletePermission(Integer permissionId);

	List<PermissionEntity> getpermissions();

}
