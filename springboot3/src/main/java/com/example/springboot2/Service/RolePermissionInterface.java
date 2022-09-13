package com.example.springboot2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot2.Dto.RolePermissionDto;
import com.example.springboot2.Entities.RolePermissionEntity;

@Service
public interface RolePermissionInterface {

	RolePermissionDto addRolepermission(RolePermissionDto rolePermissionDto);

	void update(RolePermissionDto rolePermissionDto);

	List<RolePermissionEntity> get();

	void delete(RolePermissionDto rolePermissionDto);

	void DeleteRolePermission(RolePermissionDto rolePermissionDto);

//	ArrayList<String> getPermissionByUserId(Integer id);



//	ArrayList<String> getPermissionByUserId(Integer userId);

}
