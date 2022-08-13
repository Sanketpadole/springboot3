package com.example.springboot2.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		}
		
		catch(Exception e){
			System.out.println("invalid data");
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new ErrorResponseDto("Success", "Success", userRoleEntityDto),HttpStatus.ACCEPTED);

		
		
			
		
		
//			UserRoleEntity.setId(userRoleEntityDto.getRoleid());

		
		    
				
					
}

	@Override
	public List<UserRoleEntity> getuserrolls() {
		
	List<UserRoleEntity> role= userRoleEntityRepository.findAll();
	System.out.println(role);
	return role;
	}


		


	

	@Override
	public ResponseEntity<?> adduserroless(UserRoleEntityDto userRoleEntityDto) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public UserRoleEntity adduserrole(Integer Id, UserRoleEntityDto userroleEntityDto) {
		userRoleEntityRepository.save(null)
//		
//		
//
//		
////		UserRoleEntityDto userroleEntityDto1=new UserRoleEntityDto();
//		
//		
//		return userRoleEntityRepository.save(userroleEntityDto1);
		
//		
//		RoleEntity roleEntity=new RoleEntity();
//		Optional<RoleEntity> roleEntity1=this.roleEntityRepository.findById(Id);
//		System.out.println(roleEntity1);
//		Users users=new Users();
//		Optional<Users> users1=this.userRepo.findById(Id);
////		UserRoleEntity userRoleEntity1=this.userRoleEntityRepository.save(users);
//		if(users1!=null && roleEntity1!=null)
//		
//			
//			userroleEntityDto1.setId(Id);
//			return userRoleEntityRepository.save(userroleEntityDto1);
			
			
		
//			ArrayList<UserRoleEntity> userRoles=new ArrayList<>();
//			UserRoleEntity ure=new UserRoleEntity();
//		
//			UserRoleId userRoleId=new UserRoleId();
//			userRoleId.se
//			userRoleId.setRole(roleEntity1);
	
			
			

//			
		
		
		
		
		
		
		
		
		
		
		
		
		
//		userroleEntityDto.setId(Id);
//		return userRoleEntityRepository.save(userroleEntityDto);
	@Override
	public RoleEntity updateRole(RoleDto roleData, Long id, Long updateBy) throws ResourceNotFoundException {

		RoleEntity roleEntity = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role Not Found"));
		roleEntity.setRoleName(roleData.getRoleName());
		roleEntity.setDescription(roleData.getDescription());
		roleEntity.setUpdatedBy(authRepository.getById(updateBy));
		roleRepository.save(roleEntity);
		return roleEntity;
		
		
		
		
		
		
		userroleEntityDto1.setId(Id);
		return userRoleEntityRepository.save(userroleEntityDto1);
	
	

		ArrayList<UserRoleEntity> userRoles=new ArrayList<>();
		UserRoleEntity ure=new UserRoleEntity();
	
		UserRoleId userRoleId=new UserRoleId();
		userRoleId.se
		userRoleId.setRole(roleEntity1);

	}
	
	
	
	
	

	@Override
	public ResponseEntity<?> adduserroless(Integer Id, UserRoleEntity userroleEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> adduserroless(Integer RoleId, UserRoleEntityDto userroleEntityDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRoleEntity adduserroless() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> adduserroless(Integer Id, Optional<UserRoleEntity> userroleEntityDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRoleEntity adduserrole(Integer Id, UserRoleEntityDto userroleEntityDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
		
//		UserRoleId uri=new UserRoleId() {
//			uri
//		}
//		
//	}
//	}
//		try {
			

			

//			RoleEntity roleEntity=new RoleEntity();
//				RoleEntity roleEntity1=this.roleEntityRepository.findById(userroleEntity.getRoleid()).orElseThrow(()-> new ResourceNotFoundException("Not Found Id"));
//				System.out.println(roleEntity1);
//				Users users=new Users();
//				Users users1=this.userRepo.findById(userroleEntityDto.getId()).orElseThrow(()-> new ResourceNotFoundException("not found"));
//				UserRoleEntity userRoleEntity1=this.userRoleEntityRepository.save(users);
//				if(users1!=null && roleEntity1!=null)
//				{
//					ArrayList<UserRoleEntity> userRoles=new ArrayList<>();
//					UserRoleEntity ure=new UserRoleEntity();
//				
//					UserRoleId userRoleId=new UserRoleId();
//					userRoleId.setUser(users1);
//					userRoleId.setRole(roleEntity1);
					
					
				
					
//
//	}
//				else {
//					throw new ResourceNotFoundException("not found");
//					
//				}
//			}
//			
//			catch(Exception e){
//				System.out.println("invalid data");
//				return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
//			}
//			return new ResponseEntity<>(new ErrorResponseDto("Success", "Success", userRoleEntityDto),HttpStatus.ACCEPTED);



	
