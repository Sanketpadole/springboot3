package com.example.springboot2.dao;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot2.dto.IRoleListDto;
import com.example.springboot2.entities.RoleEntity;
@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity,Integer> {

	Page<IRoleListDto> findByIsActiveTrue(Pageable paging, Class<IRoleListDto> class1);

	

}
