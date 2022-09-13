package com.example.springboot2.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springboot2.Dto.IPermissionIdList;
import com.example.springboot2.Entities.RolePermissionEntity;

@EnableJpaRepositories
@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE role_permission u SET permission_id=:permission_id WHERE u.role_id=:role_id", nativeQuery = true)
	void updateRolePermission(@Param("role_id") int role_id, @Param("permission_id") int permission_id);

//	List<IPermissionIdList> findPkPermissionByPkRoleIdIn(ArrayList<Integer> roles, Class<IPermissionIdList> class1);

//	List<IPermissionIdList> findPkPermissionByPkRoleIdIn(ArrayList<Integer> roles, Class<IPermissionIdList> class1);



	

}
