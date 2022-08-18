package com.example.springboot2.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.dto.PermissionRequestDto;

@Service
public interface RolePermissionInterface {

	ResponseEntity<?> addRolepermission(PermissionRequestDto permissionRequestDto);

}
