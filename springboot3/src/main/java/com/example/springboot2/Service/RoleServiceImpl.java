package com.example.springboot2.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.dao.PermissionRepository;
import com.example.springboot2.dao.RoleEntityRepository;
import com.example.springboot2.dao.RolePermissionRepository;
import com.example.springboot2.dto.EntityPermissionDto;
import com.example.springboot2.dto.ErrorResponseDto;
import com.example.springboot2.dto.IPermissionDto;
import com.example.springboot2.dto.IRoleListDto;
import com.example.springboot2.dto.RolePermissionDto;
import com.example.springboot2.entities.PermissionEntity;
import com.example.springboot2.entities.RoleEntity;
import com.example.springboot2.exception.ResourceNotFoundException;

import antlr.StringUtils;
@Service
public class RoleServiceImpl implements RoleServiceInterface {
	@Autowired
	private RoleEntityRepository roleEntityRepository;
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private RolePermissionRepository rolePermissionRepository;

	@Override
	public RoleEntity addRole(RoleEntity roleEntity) {
		
		return roleEntityRepository.save(roleEntity)  ;
	}

	@Override
	public List<RoleEntity> getRoles() {
		
		return roleEntityRepository.findAll();
	}


	@Override
	public RoleEntity updateRole(Integer Id, RoleEntity roleEntity) {
		
		roleEntity.setId(Id);
		return roleEntityRepository.save(roleEntity);
	}

	@Override
	public void deleteRoll(Integer id, RoleEntity roleEntity) {
		
	roleEntityRepository.deleteById(id);;
	}

	@Override
	public ResponseEntity<?> getRolesId(Integer id) {
		
		return new ResponseEntity<ErrorResponseDto>(new ErrorResponseDto("success","success",roleEntityRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Roles not found with id:" +id))),HttpStatus.ACCEPTED);
	}

	@Override
	public RolePermissionDto getRoleAndPermissionById(Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<IRoleListDto> getAllRoles(String search, String pageNo, String size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getPermissionByUserId(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	
	
//	@Override
//	public Page<IRoleListDto> getAllRoles(String search, String from, String to) {
//
//		Pageable paging = new PaginationUsingFromTo().getPagination(from, to);
//		Page<IRoleListDto> roles;
//
//		if ((search == "") || (search == null) || (search.length() == 0)) {
//
//			roles = roleEntityRepository.findByIsActiveTrue(paging, IRoleListDto.class);
//
//		} else {
//
//			roles = roleEntityRepository.findByRoleNameContainingIgnoreCaseAndIsActiveTrue(StringUtils.trimLeadingWhitespace(search), paging, IRoleListDto.class);
//
//		}
//
//		return roles;
//
//	}
	
	
	
	
	
	
	

//
//	@Override
//	public RolePermissionDto getRoleAndPermissionById(Integer roleId) throws ResourceNotFoundException {
//		RoleEntity roleEntity=roleEntityRepository.findById(roleId).orElseThrow(()->new ResourceNotFoundException("Role Not Found"));
//		List<PermissionEntity> permissions=permissionRepository.findAll();
//		ArrayList<IPermissionDto> rolesPermission=rolePermissionRepository.findByPkRoleId(pk,IPermissionDto.class);
//		ArrayList<EntityPermissionDto> entitypermission=new ArrayList<>();
//		
//		
//		for(PermissionEntity permission : permissions) {
//			EntityPermissionDto singleEntityPermission=new EntityPermissionDto();
//			singleEntityPermission.setActionName(permission.getDescription());
//			singleEntityPermission.setId(permission.getId());
//			singleEntityPermission.setIsSelected(false);
//		
//			
//			(IPermissionDto element : rolesPermission){
//				if (permission.getId() == element.getPkPermissionId()) {
//					
//					singleEntityPermission.setIsSelected(true);
//					break;
//				}
//			}
//
//			entityPermission.add(singleEntityPermisson);
//
//		}
//
//		ArrayList<EntityDto> entityDto = new ArrayList<>();
//
//		for (EntityEntity element : entities) {
//
//			Boolean isEntityEnabled = false;
//			ArrayList<EntityPermissionDto> entityPermission1 = new ArrayList<>();
//
//			for (int j = 0; j < entityPermission.size(); j++) {
//
//				if (element.getId() == entityPermission.get(j).getEntityId()) {
//
//					if (entityPermission.get(j).getIsSelected()) {
//
//						isEntityEnabled = true;
//
//					}
//
//					entityPermission1.add(entityPermission.get(j));
//
//				}
//
//			}
//
//			EntityDto singleEntityDto = new EntityDto();
//			singleEntityDto.setId(element.getId());
//			singleEntityDto.setEntityName(element.getEntityName());
//			singleEntityDto.setIsSelected(isEntityEnabled);
//			singleEntityDto.setPermissions(entityPermission1);
//			entityDto.add(singleEntityDto);
//
//		}
//
//		RolePermissionDto rolePermissionDto = new RolePermissionDto();
//		rolePermissionDto.setId(roleEntity.getId());
//		rolePermissionDto.setRoleName(roleEntity.getRoleName());
//		rolePermissionDto.setDescription(roleEntity.getDescription());
//		rolePermissionDto.setEntity(entityDto);
//		return rolePermissionDto;
//
//	}
//}
	
//	@Override
//	public RolePermissionDto getRoleAndPermissionById(Integer id) throws ResourceNotFoundException {
//
//		RoleEntity roleEntity = roleEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role Not Found"));
//		
//		List<PermissionEntity> permissions = permissionRepository.findAll();
//		ArrayList<IPermissionDto> rolesPermission = rolePermissionRepository.findByPkRoleId(id, IPermissionDto.class);
//		ArrayList<EntityPermissionDto> entityPermission = new ArrayList<>();
//
//		for (PermissionEntity permission : permissions) {
//
//			EntityPermissionDto singleEntityPermisson = new EntityPermissionDto();
//			singleEntityPermisson.setActionName(permission.getDescription());
//			singleEntityPermisson.setId(permission.getId());
//			
//			singleEntityPermisson.setIsSelected(false);
//
//			for (IPermissionDto element : rolesPermission) {
//
//				if (permission.getId() == element.getPkPermissionId()) {
//
//					singleEntityPermisson.setIsSelected(true);
//					break;
//
//				}
//
//			}
//
//			entityPermission.add(singleEntityPermisson);
//
//		}
//
//		ArrayList<EntityDto> entityDto = new ArrayList<>();
//
//		for (EntityEntity element : entities) {
//
//			Boolean isEntityEnabled = false;
//			ArrayList<EntityPermissionDto> entityPermission1 = new ArrayList<>();
//
//			for (int j = 0; j < entityPermission.size(); j++) {
//
//				if (element.getId() == entityPermission.get(j).getEntityId()) {
//
//					if (entityPermission.get(j).getIsSelected()) {
//
//						isEntityEnabled = true;
//
//					}
//
//					entityPermission1.add(entityPermission.get(j));
//
//				}
//
//			}
//
//			EntityDto singleEntityDto = new EntityDto();
//			singleEntityDto.setId(element.getId());
//			singleEntityDto.setEntityName(element.getEntityName());
//			singleEntityDto.setIsSelected(isEntityEnabled);
//			singleEntityDto.setPermissions(entityPermission1);
//			entityDto.add(singleEntityDto);
//
//		}
//
//		RolePermissionDto rolePermissionDto = new RolePermissionDto();
//		rolePermissionDto.setId(roleEntity.getId());
//		rolePermissionDto.setRoleName(roleEntity.getRoleName());
//		rolePermissionDto.setDescription(roleEntity.getDescription());
//		rolePermissionDto.setEntity(entityDto);
//		return rolePermissionDto;
//
//	}


			
			
			
		
	
		
		
		
		
		
		
		




