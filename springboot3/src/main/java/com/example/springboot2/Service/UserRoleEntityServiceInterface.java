package com.example.springboot2.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.dto.UserRoleEntityDto;
import com.example.springboot2.entities.RoleEntity;
import com.example.springboot2.entities.UserRoleEntity;
@Service
public interface UserRoleEntityServiceInterface {

	



ResponseEntity<?> addUserRoleEntity(UserRoleEntityDto userRoleEntityDto);

List<UserRoleEntity> getuserrolls();

ResponseEntity<?> adduserroless();

ResponseEntity<?> adduserroless(UserRoleEntityDto userRoleEntityDto);



}
