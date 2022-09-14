package com.example.springboot2.ServiceInterface;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.Dto.PermissionRequestDto;
import com.example.springboot2.Entities.PermissionEntity;

@Service
public interface PermissionService {

	ResponseEntity<?> addPermission(PermissionRequestDto permissionBody);

	void editPermission(PermissionRequestDto permissionBody, Integer permissionId);

	void deletePermission(Integer permissionId);

	List<PermissionEntity> getpermissions();

}
