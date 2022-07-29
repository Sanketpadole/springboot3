package com.example.springboot2.Service;

import org.springframework.stereotype.Service;

import com.example.springboot2.entities.Users;
@Service
public interface UsersService {

	Users addUsers();

	Users addUsers(Users users);

}
