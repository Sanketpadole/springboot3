package com.example.springboot2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot2.dao.RoleEntityRepository;
import com.example.springboot2.dto.ErrorResponseDto;
import com.example.springboot2.entities.RoleEntity;
import com.example.springboot2.exception.ResourceNotFoundException;
@Service
public class RoleServiceImpl implements RoleServiceInterface {
	@Autowired
	private RoleEntityRepository roleEntityRepository;

	@Override
	public RoleEntity addRole(RoleEntity roleEntity) {
		
		return roleEntityRepository.save(roleEntity)  ;
	}

	@Override
	public List<RoleEntity> getRoles() {
		// TODO Auto-generated method stub
		return roleEntityRepository.findAll();
	}


	@Override
	public RoleEntity updateRole(Integer Id, RoleEntity roleEntity) {
		// TODO Auto-generated method stub
		roleEntity.setId(Id);
		return roleEntityRepository.save(roleEntity);
	}

	@Override
	public void deleteRoll(Integer id, RoleEntity roleEntity) {
		// TODO Auto-generated method stub
	roleEntityRepository.deleteById(id);;
	}

	@Override
	public ResponseEntity<?> getRolesId(Integer id) {
		// TODO Auto-generated method stub
		return new ResponseEntity<ErrorResponseDto>(new ErrorResponseDto("success","success",roleEntityRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Roles not found with id:" +id))),HttpStatus.ACCEPTED);
	}

	public RoleEntity updateRole1(Integer Id, RoleEntity roleEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
