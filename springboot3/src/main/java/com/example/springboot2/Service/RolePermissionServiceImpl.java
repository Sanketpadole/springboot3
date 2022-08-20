package com.example.springboot2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springboot2.dao.PermissionRepository;
import com.example.springboot2.dao.RoleEntityRepository;
import com.example.springboot2.dao.RolePermissionRepository;
import com.example.springboot2.dao.UserRoleEntityRepository;
import com.example.springboot2.dto.ErrorResponseDto;
import com.example.springboot2.dto.PermissionRequestDto;
import com.example.springboot2.dto.RoleIdList;
import com.example.springboot2.dto.RolePermissionDto;
import com.example.springboot2.dto.UserRoleEntityDto;
import com.example.springboot2.entities.PermissionEntity;
import com.example.springboot2.entities.RoleEntity;
import com.example.springboot2.entities.RolePermissionEntity;
import com.example.springboot2.entities.RolePermissionId;
import com.example.springboot2.entities.UserRoleEntity;
import com.example.springboot2.entities.UserRoleId;
import com.example.springboot2.entities.Users;
import com.example.springboot2.exception.ResourceNotFoundException;

@Service
public class RolePermissionServiceImpl implements RolePermissionInterface {
	@Autowired
	private RoleEntityRepository roleEntityRepository;

	@Autowired
	private PermissionRepository permissionRepository;
	@Autowired
	private RolePermissionRepository rolePermissionRepository;
	@Autowired
	private UserRoleEntityRepository userRoleEntityRepository;
	

	
		
		
		
		
		
		
		
		
		
		
		
		
				

	


	@Override
	public ResponseEntity<?> addRolepermission(RolePermissionDto rolePermissionDto) {
		try {
			RoleEntity roleEntity=new RoleEntity();
			RoleEntity roleEntity1=this.roleEntityRepository.findById(rolePermissionDto.getRoleid()).orElseThrow(()-> new ResourceNotFoundException("not found"));
			PermissionEntity permissionEntity=new PermissionEntity();
			PermissionEntity permissionEntity1=this.permissionRepository.findById(rolePermissionDto.getId()).orElseThrow(()->new ResourceNotFoundException("permission not found"));
			
			if(roleEntity1!=null && permissionEntity1!=null)
			{
				ArrayList<RolePermissionEntity>rolePermission=new ArrayList<>();
				RolePermissionEntity rolePermissionEntity=new RolePermissionEntity();
				RolePermissionId rolePermissionId=new RolePermissionId();
				rolePermissionId.setPermission(permissionEntity1);
				rolePermissionId.setRole(roleEntity1);
				rolePermissionEntity.setPk(rolePermissionId);
				rolePermission.add(rolePermissionEntity);
				rolePermissionRepository.saveAll(rolePermission);
			}
			else {
				throw new ResourceNotFoundException("not found");
			}
			}
		catch(Exception e){
			System.out.println("invalid data");
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new ErrorResponseDto("success","success",rolePermissionDto),HttpStatus.ACCEPTED);
	}
			
		
		
		
	






	@Override
	public ResponseEntity<?> addRolepermission(PermissionRequestDto permissionRequestDto) {
		
		return null;
	}












	
	
	
	
	
	
	@Override
	public void update(RolePermissionDto rolePermissionDto) {
		

			RoleEntity roleEntity=this.roleEntityRepository.findById(rolePermissionDto.getRoleid()).orElseThrow(()-> new ResourceNotFoundException("not found"));
			

			PermissionEntity permissionEntity=this.permissionRepository.findById(rolePermissionDto.getId()).orElseThrow(()->new ResourceNotFoundException("permission not found"));
			
			
			if(roleEntity!=null && permissionEntity!=null)
			{
				ArrayList<RolePermissionEntity>rolePermission=new ArrayList<>();
				RolePermissionEntity rolePermissionEntity=new RolePermissionEntity();
				RolePermissionId rolePermissionId=new RolePermissionId();
				rolePermissionId.setPermission(permissionEntity);
				rolePermissionId.setRole(roleEntity);
				rolePermissionEntity.setPk(rolePermissionId);
				rolePermission.add(rolePermissionEntity);
				

				
				rolePermissionRepository.updateRolePermission(roleEntity.getId(),permissionEntity.getId());
				
			}
			else {
				throw new ResourceNotFoundException("not found");
			}
		}
	
	
	
	
	



	












//	@Override
//	public void update(UserRoleEntityDto userRoleEntityDto) {
//		// TODO Auto-generated method stub
//		
//	}











	@Override
	public List<RolePermissionEntity> get() {
		// TODO Auto-generated method stub
		return rolePermissionRepository.findAll() ;
	}











	@Override
	public void delete( RolePermissionDto rolePermissionDto) {
		RoleEntity roleEntity=this.roleEntityRepository.findById(rolePermissionDto.getRoleid()).orElseThrow(()-> new ResourceNotFoundException("not found"));
		

		PermissionEntity permissionEntity=this.permissionRepository.findById(rolePermissionDto.getId()).orElseThrow(()->new ResourceNotFoundException("permission not found"));
		
		
		if(roleEntity!=null && permissionEntity!=null)
		{
			ArrayList<RolePermissionEntity>rolePermission=new ArrayList<>();
			RolePermissionEntity rolePermissionEntity=new RolePermissionEntity();
			RolePermissionId rolePermissionId=new RolePermissionId();
			rolePermissionId.setPermission(permissionEntity);
			rolePermissionId.setRole(roleEntity);
			rolePermissionEntity.setPk(rolePermissionId);
			rolePermission.add(rolePermissionEntity);
			rolePermissionRepository.delete(rolePermissionEntity);
			

			
		
			
		}
		else {
			throw new ResourceNotFoundException("not found");
		}
	}











	@Override
	public void DeleteRolePermission(RolePermissionDto rolePermissionDto) {
		// TODO Auto-generated method stub
		
	}











	@Override
	public ArrayList<String> getPermissionByUserId(Integer Id) {

		ArrayList<RoleIdList> roleIds = userRoleEntityRepository.findByPkUserId(Id, RoleIdList.class);
		ArrayList<Long> roles = new ArrayList<>();

		for (int i = 0; i < roleIds.size(); i++) {

			roles.add(roleIds.get(i).getPkRoleId());

		}

		List<IPermissionIdList> rolesPermission = rolePermissionRepository.findPkPermissionByPkRoleIdIn(roles, IPermissionIdList.class);
		ArrayList<String> permissions = new ArrayList<>();

		for (IPermissionIdList element : rolesPermission) {

			permissions.add(element.getPkPermissionActionName());

		}

		return permissions;

	}











	@Override
	public ArrayList<String> getPermissionByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}











	











	
	
	
	
	
	

		












		
		
		
		
		
	}
		
		
		
		
		
		
		
		
		
		
		

	