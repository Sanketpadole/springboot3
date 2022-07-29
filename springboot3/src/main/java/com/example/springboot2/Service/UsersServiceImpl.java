package com.example.springboot2.Service;

import org.springframework.stereotype.Service;

import com.example.springboot2.dao.UserRepos;
import com.example.springboot2.entities.Users;
@Service
public class UsersServiceImpl implements UsersService{

	@Override
	public Users addUsers(Users users) {
		// TODO Auto-generated method stub
		return UserRepos.save(
				users);
	}

	@Override
	public Users addUsers() {
		// TODO Auto-generated method stub
		return null;
	}


}
