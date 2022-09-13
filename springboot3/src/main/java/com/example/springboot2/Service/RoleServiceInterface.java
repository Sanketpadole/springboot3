package com.example.springboot2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.Entities.RoleEntity;

@Service
public interface RoleServiceInterface {

	RoleEntity addRole(RoleEntity roleEntity);

	List<RoleEntity> getRoles();

	ResponseEntity<?> updateRole(Integer id, RoleEntity roleEntity);

	void deleteRoll(Integer id, RoleEntity roleEntity);

	ResponseEntity<?> getRolesId(Integer id);

	ResponseEntity<?> put(Integer Id, RoleEntity roleEntity);



}
