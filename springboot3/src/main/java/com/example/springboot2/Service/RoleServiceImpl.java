package com.example.springboot2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springboot2.Dto.ErrorResponseDto;

import com.example.springboot2.Entities.RoleEntity;
import com.example.springboot2.Exception.ResourceNotFoundException;

import com.example.springboot2.Repository.RoleEntityRepository;
import com.example.springboot2.Repository.RolePermissionRepository;
import com.example.springboot2.Repository.UserRoleEntityRepository;
import com.example.springboot2.ServiceInterface.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleEntityRepository roleEntityRepository;

	@Autowired
	private RolePermissionRepository rolePermissionRepository;

	@Autowired
	private UserRoleEntityRepository userRoleEntityRepository;

	@Override
	public RoleEntity addRole(RoleEntity roleEntity) {

		return roleEntityRepository.save(roleEntity);
	}

	@Override
	public List<RoleEntity> getRoles() {

		return roleEntityRepository.findAll();
	}

	@Override
	public ResponseEntity<?> updateRole(@PathVariable(value = "id") Integer Id, RoleEntity roleEntity) {

		roleEntityRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("user not found with id:" + Id));
		roleEntity.setRoleid(Id);

		return new ResponseEntity<>(new ErrorResponseDto("succes", "succes", roleEntityRepository.save(roleEntity)),
				HttpStatus.OK);
	}

	@Override
	public void deleteRoll(Integer id, RoleEntity roleEntity) {

		roleEntityRepository.deleteById(id);
		;
	}

	@Override
	public ResponseEntity<?> getRolesId(Integer id) {

		return new ResponseEntity<ErrorResponseDto>(
				new ErrorResponseDto("success", "success",
						roleEntityRepository.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("Roles not found with id:" + id))),
				HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<?> put(Integer Id, RoleEntity roleEntity) {

		return null;
	}

}
