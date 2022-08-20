package com.example.springboot2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.dto.IRoleListDto;
import com.example.springboot2.dto.RolePermissionDto;
import com.example.springboot2.entities.RoleEntity;
@Service
public interface RoleServiceInterface {

	RoleEntity addRole(RoleEntity roleEntity);

	List<RoleEntity> getRoles();

	RoleEntity updateRole(Integer id, RoleEntity roleEntity);

	void deleteRoll(Integer id, RoleEntity roleEntity);

	ResponseEntity<?> getRolesId(Integer id);

	RolePermissionDto getRoleAndPermissionById(Integer roleId);

	Page<IRoleListDto> getAllRoles(String search, String pageNo, String size);

	ArrayList<String> getPermissionByUserId(Integer Id);

}
