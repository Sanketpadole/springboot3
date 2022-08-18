package com.example.springboot2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.dto.UserRoleEntityDto;
import com.example.springboot2.entities.RoleEntity;
import com.example.springboot2.entities.UserRoleEntity;
@Service
public interface UserRoleEntityServiceInterface {

	



ResponseEntity<?> addUserRoleEntity(UserRoleEntityDto userRoleEntityDto);

List<UserRoleEntity> getuserrolls();


void update(UserRoleEntityDto userRoleEntityDto);

void delete(UserRoleEntityDto userRoleEntityDto);






}
