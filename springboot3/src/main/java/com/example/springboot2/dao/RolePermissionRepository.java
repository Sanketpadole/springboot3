package com.example.springboot2.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springboot2.entities.RolePermissionEntity;
@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity ,Integer> {
//	@Transactional
//	@Modifying(clearAutomatically=true)
//	@Query(value = "UPDATE user_role u SET role_id=:role_id WHERE u.user_id=:user_id",nativeQuery=true)
//	void updateUserRole(@Param("user_id") int user_id,@Param("role_id") int role_id);
	
	
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE role_permission u SET permission_id=:permission_id WHERE u.role_id=:role_id",nativeQuery=true)
	void updateRolePermission(@Param("permission_id") int permission_id,@Param("role_id") int role_id);
	

}
