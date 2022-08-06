package com.example.springboot2.Service;

import com.example.springboot2.dao.UserRoleEntityRepository;
import com.example.springboot2.entities.UserRoleEntity;

public class UserRoleEntityServiceImpl implements UserRoleEntityServiceInterface{
	private UserRoleEntityRepository userRoleEntityRepository;

	@Override
	public UserRoleEntity addUserRoleEntity(UserRoleEntity userRoleEntity) {
		// TODO Auto-generated method stub
		return userRoleEntityRepository.save(userRoleEntity);
	}

}
