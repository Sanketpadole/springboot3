package com.example.springboot2.Service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.dao.RoleEntityRepository;
import com.example.springboot2.dao.UserRepo;
import com.example.springboot2.dao.UserRoleEntityRepository;
import com.example.springboot2.dto.ErrorResponseDto;
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
	public ResponseEntity<?> addUserRoleEntity(UserRoleEntityDto userRoleEntityDto) {
		
		
		try {
	

	RoleEntity roleEntity=new RoleEntity();
		RoleEntity roleEntity1=this.roleEntityRepository.findById(userRoleEntityDto.getRoleid()).orElseThrow(()-> new ResourceNotFoundException("Not Found Id"));
		System.out.println(roleEntity1);
		Users users=new Users();
		Users users1=this.userRepo.findById(userRoleEntityDto.getId()).orElseThrow(()-> new ResourceNotFoundException("not found"));

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
		}
		
		catch(Exception e){
			System.out.println("invalid data");
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new ErrorResponseDto("Success", "Success", userRoleEntityDto),HttpStatus.ACCEPTED);

		
		
			
		
		


		
		    
				
					
}

	@Override
	public List<UserRoleEntity> getuserrolls() {
		
	List<UserRoleEntity> role= userRoleEntityRepository.findAll();
	System.out.println(role);
	return role;
	}


		


	



	@Override
	public void update(UserRoleEntityDto userRoleEntityDto) {
		
			

			 
			RoleEntity roleEntity=this.roleEntityRepository.findById(userRoleEntityDto.getRoleid()).orElseThrow(()-> new ResourceNotFoundException("Not Found Id"));
			 
	 		Users users=this.userRepo.findById(userRoleEntityDto.getId()).orElseThrow(()-> new ResourceNotFoundException("not found"));

			if(users!=null && roleEntity!=null)
			{
				ArrayList<UserRoleEntity> userRoles=new ArrayList<>();
				
				UserRoleEntity ure=new UserRoleEntity();
			
				UserRoleId userRoleId=new UserRoleId();
				userRoleId.setUser(users);
				userRoleId.setRole(roleEntity);
				
				

				ure.setPk(userRoleId);
				userRoles.add(ure);
				userRoleEntityRepository.updateUserRole(users.getId(), roleEntity.getId());
				
			
				
			}
				
				else {
					throw new ResourceNotFoundException("not found");
					
				}
			
			}

	@Override
	public void delete(UserRoleEntityDto userRoleEntityDto) {
			
			 
				RoleEntity roleEntity=this.roleEntityRepository.findById(userRoleEntityDto.getRoleid()).orElseThrow(()-> new ResourceNotFoundException("Not Found Id"));
				 
		 		Users users=this.userRepo.findById(userRoleEntityDto.getId()).orElseThrow(()-> new ResourceNotFoundException("not found"));
//				UserRoleEntity userRoleEntity1=this.userRoleEntityRepository.save(users);
				if(users!=null && roleEntity!=null)
				{
					ArrayList<UserRoleEntity> userRoles=new ArrayList<>();
					
					UserRoleEntity ure=new UserRoleEntity();
				
					UserRoleId userRoleId=new UserRoleId();
					userRoleId.setUser(users);
					userRoleId.setRole(roleEntity);
					
					

					ure.setPk(userRoleId);
					userRoles.add(ure);
					userRoleEntityRepository.updateUserRole(users.getId(), roleEntity.getId());
					
				
					
				}
					
					else {
						throw new ResourceNotFoundException("not found");
						
					}
		
		
	}
	
	}

	

		
		
		
		
		
		
		
		
		
		
		
		
		


		
		
		
		
		

	
	
	
	


	

		



	
