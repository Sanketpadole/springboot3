package com.example.springboot2.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.springboot2.entities.RoleEntity;
@Service
public interface RoleServiceInterface {

	RoleEntity addRole(RoleEntity roleEntity);

	List<RoleEntity> getRoles();

	RoleEntity updateRole(Integer id, RoleEntity roleEntity);

	void deleteRoll(Integer id, RoleEntity roleEntity);

	ResponseEntity<?> getRolesId(Integer id);

}
