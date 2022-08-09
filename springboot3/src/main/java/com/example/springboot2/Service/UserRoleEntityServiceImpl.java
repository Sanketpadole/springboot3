package com.example.springboot2.Service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot2.dao.RoleEntityRepository;
import com.example.springboot2.dao.UserRepo;
import com.example.springboot2.dao.UserRoleEntityRepository;
import com.example.springboot2.dto.UserRoleEntityDto;
import com.example.springboot2.entities.RoleEntity;
import com.example.springboot2.entities.UserRoleEntity;
import com.example.springboot2.entities.UserRoleId;
import com.example.springboot2.entities.Users;
import com.example.springboot2.exception.ResourceNotFoundException;
@Service
public class UserRoleEntityServiceImpl implements UserRoleEntityServiceInterface{
	@Autowired
	private UserRoleEntityRepository userRoleEntityRepository;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleEntityRepository roleEntityRepository;

	@Override
	public UserRoleEntityDto addUserRoleEntity(UserRoleEntityDto userRoleEntityDto) {
		
		
		
		

		

		RoleEntity roleEntity=new RoleEntity();
		RoleEntity roleEntity1=this.roleEntityRepository.findById(userRoleEntityDto.getId()).get();
		Users users=new Users();
		Users users1=this.userRepo.findById(userRoleEntityDto.getId()).get();
//		UserRoleEntity userRoleEntity1=this.userRoleEntityRepository.save(users);
		if(users1!=null && roleEntity1!=null)
		{
			ArrayList<UserRoleEntity> userRoles=new ArrayList<>();
			UserRoleEntity ure=new UserRoleEntity();
		
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
		return userRoleEntityDto;

		
		    
				
					
		
		
		
				
				
				 
			
		
		
		
		
		
		
		

		
	
		
		
		
		
		
		
		
	

		


}

	
}