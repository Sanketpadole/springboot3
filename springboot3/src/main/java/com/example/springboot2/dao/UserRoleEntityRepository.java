package com.example.springboot2.dao;



import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.example.springboot2.Service.RoleIdList;
import com.example.springboot2.dto.RoleIdList;
import com.example.springboot2.dto.UserRoleEntityDto;

import com.example.springboot2.entities.UserRoleEntity;
@Repository
public interface UserRoleEntityRepository extends JpaRepository<UserRoleEntity,Integer> {

	UserRoleEntity save(UserRoleEntityDto userRoleEntityDto);


	
	
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value = "UPDATE user_role u SET role_id=:role_id WHERE u.user_id=:user_id",nativeQuery=true)
	void updateUserRole(@Param("user_id") int user_id,@Param("role_id") int role_id);
	
	
	
	
	
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value = "DELETE user_role u SET role_id=:role_id WHERE u.user_id=:user_id",nativeQuery=true)
	void deleteUserRole(@Param("user_id") int user_id,@Param("role_id") int role_id);





	ArrayList<RoleIdList> findByPkUserId(Integer id, Class<RoleIdList> class1);

}
