package com.example.springboot2.Service;

import org.springframework.stereotype.Service;

import com.example.springboot2.dto.UserRoleEntityDto;
import com.example.springboot2.entities.UserRoleEntity;
@Service
public interface UserRoleEntityServiceInterface {

	


	UserRoleEntityDto addUserRoleEntity(UserRoleEntityDto userRoleEntityDto);

}
