package com.example.springboot2.dao;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.example.springboot2.dto.UserRoleEntityDto;

import com.example.springboot2.entities.UserRoleEntity;
@Repository
public interface UserRoleEntityRepository extends JpaRepository<UserRoleEntity,Integer> {

	UserRoleEntity save(UserRoleEntityDto userRoleEntityDto);

	
//	@Transactional
//	@Modifying(clearAutomatically=true)
//	@Query(value = "UPDATE user_role u SET active =false WHERE u.Role_id=:role_id AND u.Id=:id",nativeQuery=true)
//	void deleteRole(@Param("Role_id") int Role_id,@Param("id") int user_id);
	
	
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value = "UPDATE user_role u SET role_id=:role_id WHERE u.user_id=:user_id",nativeQuery=true)
	void updateUserRole(@Param("role_id") int role_id,@Param("user_id") int user_id);

}
