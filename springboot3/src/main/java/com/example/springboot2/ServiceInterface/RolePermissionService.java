package com.example.springboot2.ServiceInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot2.Dto.RolePermissionDto;
import com.example.springboot2.Entities.RolePermissionEntity;

@Service
public interface RolePermissionService {

	RolePermissionDto addRolepermission(RolePermissionDto rolePermissionDto);

	void update(RolePermissionDto rolePermissionDto);

	List<RolePermissionEntity> get();

	void delete(RolePermissionDto rolePermissionDto);

	void DeleteRolePermission(RolePermissionDto rolePermissionDto);

}
