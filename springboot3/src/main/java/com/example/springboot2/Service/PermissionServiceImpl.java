package com.example.springboot2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.Dto.ErrorResponseDto;
import com.example.springboot2.Dto.PermissionRequestDto;
import com.example.springboot2.Entities.PermissionEntity;
import com.example.springboot2.Exception.ResourceNotFoundException;
import com.example.springboot2.Repository.PermissionRepository;
import com.example.springboot2.ServiceInterface.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public ResponseEntity<?> addPermission(PermissionRequestDto permissionBody) {
		
		PermissionEntity newPermission = new PermissionEntity();
		newPermission.setActionName(permissionBody.getActionName());
		newPermission.setBaseUrl(permissionBody.getBaseUrl());
		newPermission.setDescription(permissionBody.getDescription());
		newPermission.setMethod(permissionBody.getMethod());
		newPermission.setPath(permissionBody.getPath());
		

		return new ResponseEntity<>(
				new ErrorResponseDto("Success", "success", permissionRepository.save(newPermission)), HttpStatus.OK);

	}

	@Override
	public List<PermissionEntity> getpermissions() {

		return permissionRepository.findAll();
	}

	@Override
	public void editPermission(PermissionRequestDto permissionBody, Integer permissionId)
			throws ResourceNotFoundException {
		PermissionEntity permissionData = permissionRepository.findById(permissionId)
				.orElseThrow(() -> new ResourceNotFoundException("not found with id"));
		permissionData.setActionName(permissionBody.getActionName());
		permissionData.setBaseUrl(permissionBody.getBaseUrl());
		permissionData.setDescription(permissionBody.getDescription());

		permissionData.setMethod(permissionBody.getMethod());
		permissionData.setPath(permissionBody.getPath());
		permissionRepository.save(permissionData);
		return;
	}

	@Override
	public void deletePermission(Integer permissionId) throws ResourceNotFoundException {
		PermissionEntity permissionData = permissionRepository.findById(permissionId)
				.orElseThrow(() -> new ResourceNotFoundException("Permission Not Found"));
		permissionData.setIsActive(false);
		permissionRepository.save(permissionData);
		return;

	}

}
