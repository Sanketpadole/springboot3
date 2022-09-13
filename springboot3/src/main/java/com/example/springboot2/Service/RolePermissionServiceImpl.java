package com.example.springboot2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.springboot2.Dto.IPermissionIdList;

import com.example.springboot2.Dto.RolePermissionDto;
import com.example.springboot2.Entities.PermissionEntity;
import com.example.springboot2.Entities.RoleEntity;
import com.example.springboot2.Entities.RolePermissionEntity;
import com.example.springboot2.Entities.RolePermissionId;
import com.example.springboot2.Entities.UserRoleEntity;
import com.example.springboot2.Exception.ResourceNotFoundException;
import com.example.springboot2.Repository.PermissionRepository;
import com.example.springboot2.Repository.RoleEntityRepository;
import com.example.springboot2.Repository.RolePermissionRepository;
import com.example.springboot2.Repository.UserRoleEntityRepository;

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
	public RolePermissionDto addRolepermission(RolePermissionDto rolePermissionDto) {

		ArrayList<RolePermissionEntity> rolePermission = new ArrayList<>();

		RoleEntity roleEntity1 = this.roleEntityRepository.findById(rolePermissionDto.getRoleid())
				.orElseThrow(() -> new ResourceNotFoundException("not found"));
		System.out.println("role" + roleEntity1);

		PermissionEntity permissionEntity1 = this.permissionRepository.findById(rolePermissionDto.getPermissionid())
				.orElseThrow(() -> new ResourceNotFoundException("permission not found"));
		System.out.println("role" + permissionEntity1);

		RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();
		RolePermissionId rolePermissionId = new RolePermissionId(roleEntity1, permissionEntity1);
		rolePermissionEntity.setPk(rolePermissionId);
		rolePermission.add(rolePermissionEntity);
		rolePermissionRepository.saveAll(rolePermission);
		return rolePermissionDto;

	}

	@Override
	public void update(RolePermissionDto rolePermissionDto) {

		RoleEntity roleEntity = this.roleEntityRepository.findById(rolePermissionDto.getRoleid())
				.orElseThrow(() -> new ResourceNotFoundException("not found"));

		PermissionEntity permissionEntity = this.permissionRepository.findById(rolePermissionDto.getPermissionid())
				.orElseThrow(() -> new ResourceNotFoundException("permission not found"));

		if (roleEntity != null && permissionEntity != null) {
			ArrayList<RolePermissionEntity> rolePermission = new ArrayList<>();
			RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();
			RolePermissionId rolePermissionId = new RolePermissionId();
			rolePermissionId.setPermission(permissionEntity);
			rolePermissionId.setRole(roleEntity);
			rolePermissionEntity.setPk(rolePermissionId);
			rolePermission.add(rolePermissionEntity);

			rolePermissionRepository.updateRolePermission(roleEntity.getRoleid(), permissionEntity.getId());

		} else {
			throw new ResourceNotFoundException("not found");
		}
	}

	@Override
	public List<RolePermissionEntity> get() {

		return rolePermissionRepository.findAll();
	}

	@Override
	public void delete(RolePermissionDto rolePermissionDto) {
		RoleEntity roleEntity = this.roleEntityRepository.findById(rolePermissionDto.getRoleid())
				.orElseThrow(() -> new ResourceNotFoundException("not found"));

		PermissionEntity permissionEntity = this.permissionRepository.findById(rolePermissionDto.getPermissionid())
				.orElseThrow(() -> new ResourceNotFoundException("permission not found"));

		if (roleEntity != null && permissionEntity != null) {
			ArrayList<RolePermissionEntity> rolePermission = new ArrayList<>();
			RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();
			RolePermissionId rolePermissionId = new RolePermissionId();
			rolePermissionId.setPermission(permissionEntity);
			rolePermissionId.setRole(roleEntity);
			rolePermissionEntity.setPk(rolePermissionId);
			rolePermission.add(rolePermissionEntity);
			rolePermissionRepository.delete(rolePermissionEntity);

		} else {
			throw new ResourceNotFoundException("not found");
		}
	}

	@Override
	public void DeleteRolePermission(RolePermissionDto rolePermissionDto) {

	}

//	@Override
//	public ArrayList<String> getPermissionByUserId(Integer userId) {
//		System.out.println("roleids1");
//
//		System.out.println("roleids");
//		ArrayList<UserRoleEntity> roleEntities = this.userRoleEntityRepository.getRoleOfUser(userId);
//		System.out.println("check user roel____" + roleEntities);
//		ArrayList<Integer> roles = new ArrayList<>();
//
//		for (int i = 0; i < roleEntities.size(); i++) {
//
//			roles.add(roleEntities.get(i).getPk().getRole().getRoleid());
//			System.out.println("roles" + roles);
//		}
//
//		List<IPermissionIdList> rolesPermission = this.rolePermissionRepository.findPkPermissionByPkRoleIdIn(roles,
//				IPermissionIdList.class);
//		System.out.println("rolepermission" + rolesPermission);
//		ArrayList<String> permissions = new ArrayList<>();
//		System.out.println("permission1223" + permissions);
//		for (IPermissionIdList element : rolesPermission) {
//
//			permissions.add(element.getPkPermissionActionName());
//			System.out.println("permission1223" + permissions);
//
//		}
//		System.out.println("permission" + permissions);
//		return permissions;
//
//	}

}
