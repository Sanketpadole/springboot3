package com.example.springboot2.ServiceInterface;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.Dto.UserRoleEntityDto;
import com.example.springboot2.Entities.UserRoleEntity;

@Service
public interface UserRoleEntityService {

	ResponseEntity<?> addUserRoleEntity(UserRoleEntityDto userRoleEntityDto);

	List<UserRoleEntity> getuserrolls();

	void update(UserRoleEntityDto userRoleEntityDto);

	void delete(UserRoleEntityDto userRoleEntityDto);

}
