package com.example.springboot2.Service;


import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.springboot2.dao.RoleEntityRepository;
import com.example.springboot2.dao.UserRepo;
import com.example.springboot2.dao.UserRoleEntityRepository;
import com.example.springboot2.entities.RoleEntity;
import com.example.springboot2.entities.UserRoleEntity;
import com.example.springboot2.entities.UserRoleId;
import com.example.springboot2.entities.Users;
import com.example.springboot2.exception.ResourceNotFoundException;
@Service
public class UserRoleEntityServiceImpl implements UserRoleEntityServiceInterface{
	private UserRoleEntityRepository userRoleEntityRepository;
	private UserRepo userRepo;
	private RoleEntityRepository roleEntityRepository;

	@Override
	public UserRoleEntity addUserRoleEntity(UserRoleEntity userRoleEntity) {
//		Users users=this.userRepo.findById(id);
		RoleEntity roleEntity=new RoleEntity();
		RoleEntity roleEntity1=this.roleEntityRepository.findById(roleEntity.getId());
		Users users=new Users();
		Users users1=this.userRepo.findById(users.getId());
		if(users1!=null && roleEntity1!=null)
		{
			ArrayList<UserRoleEntity> userRoles=new ArrayList<>();
			UserRoleEntity ure=new UserRoleEntity();
//			Users users=new Users();
//			users.getId();
//			RoleEntity roleEntity=new RoleEntity();
//			roleEntity.getId();
			UserRoleId userRoleId=new UserRoleId();
			userRoleId.setUser(users1);
			userRoleId.setRole(roleEntity1);
			ure.setPk(userRoleId);
			userRoles.add(ure);
			userRoleEntityRepository.saveAll(userRoles);
			
		}
		else {
			throw new ResourceNotFoundException("not found");
			
		}

		
		    
				
				
				
				
				 
			
		
		
		
		
		
		
		
//		ArrayList<UserRoleEntity>userRoles=new ArrayList<>();
//		UserRoleEntity ure=new UserRoleEntity();
//		Users users=new Users();
//		users.getId();
//		RoleEntity roleEntity=new RoleEntity();
//		roleEntity.getId();
//		UserRoleId userRoleId=new UserRoleId();
//		userRoleId.setUser(users);
//		userRoleId.setRole(roleEntity);
//		userRoles.add(ure);
//		userRoleEntityRepository.saveAll(userRoles);
	
		
//		ure.setPk(users.getId());
//		ure.setPk(roleEntity.getId());
		
	
		
		
		
		
		
		
		
	

		
//		return userRoleEntityRepository.save(ure);
//		ArrayList<UserRoleEntity>userRoles=new ArrayList<>();
//		
//		
//		UserRoleEntity ure=new UserRoleEntity();
//		Users users=new Users();
//		users.setId(id);
//		RoleEntity re=new RoleEntity();
//		re.setId(userBody.getRoles()[j]);
//		UserRoleId uri=new UserRoleId(users,re);
//		ure.setPk(uri);
//		userRole.add(ure);
//	}

}
}