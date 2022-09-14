package com.example.springboot2.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.springboot2.Entities.Users;
import com.example.springboot2.Repository.UserRepo;
import com.example.springboot2.ServiceInterface.AuthService;
import com.example.springboot2.ServiceInterface.RolePermissionService;

@Service
@Component
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RolePermissionService rolePermissionInterface;

	@Autowired
	private PasswordEncoder passwordEncoder;

//		Users users;
//
//		if (!cache.isKeyExist(email, email
//				)) {
//			System.out.println("hello4");
//
//			 users = this.userRepo.findByEmail(email);
//			 
//			cache.addInCache(email , email, users);
//			System.out.println("hello5");
//
//		} else {
//
//			 users = (Users) cache.getFromCache(email, email); // redisTemplate.opsForHash().get(email, email);
//			 System.out.println("hello6");
//		}
//		
//		
//		if (users  == null) {
//			System.out.println("hello7");
//
//			throw new UsernameNotFoundException("User not found with Email: " + email);
//
//		}
//		System.out.println("hello8");
//		return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(),
//				getAuthority(users));
//		
//		
//	}

//	private ArrayList<SimpleGrantedAuthority> getAuthority(Users users) {
//
//		ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
//		System.out.println("hello9");
//
//		if ((users.getId() + "permission") != null) {
////		if (!cache.isKeyExist(users.getId() + "permission", users.getId() + "permission")) {
//			System.out.println("hello10");
////
//			ArrayList<SimpleGrantedAuthority> authorities1 = new ArrayList<>();
//			ArrayList<String> permissions = rolePermissionInterface.getPermissionByUserId(users.getId());
//
//			System.out.println("permisssions" + permissions);
//
//			permissions.forEach(permission -> {
//				authorities1.add(new SimpleGrantedAuthority("ROLE_" + permission));
//				System.out.println("hello11");
//			});
//			authorities = authorities1;
//		}
//		System.out.println("authorities >>>>>>>>>>>" + authorities);
//		return authorities;
//	}

	public Boolean comparePassword(String Password, String hashpassword) {

		return passwordEncoder.matches(Password, hashpassword);
	}

	@Override
	public UserDetails loadUserByUsername(String email) {

		Users users;

		users = this.userRepo.findByEmail(email);
		if (users == null) {
			System.out.println();

		}
		return users;
	}
//		return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(),
//				getAuthority(users));
//
//	}
}

//	private ArrayList<SimpleGrantedAuthority> getAuthority(Users users) {
//
//		ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
//		System.out.println("hello9");
//
//		if (!cache.isKeyExist(users.getId() + "permission", users.getId() + "permission")) {
//			System.out.println("hello10");
//
//			ArrayList<SimpleGrantedAuthority> authorities1 = new ArrayList<>();
//			ArrayList<?> permissions = rolePermissionInterface.getPermissionByUserId(users.getId());
//			
//			System.out.println("permisssions"+permissions);
//			
//			permissions.forEach(permission -> {
//
//				authorities1.add(new SimpleGrantedAuthority("ROLE_" + permission));
//				System.out.println("hello11");
//			});
//			authorities=authorities1;
//			cache.addInCache(users.getId()+"permission",users.getId()+"permission",authorities1);
//	}
//		else {
//			authorities = (ArrayList<SimpleGrantedAuthority>) cache.getFromCache(users.getId() + "permission", users.getId() + "permission");
//		}
//		return authorities;
//}
