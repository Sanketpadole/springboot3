package com.example.springboot2.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RoleEntity{
	@Id
	
	private long id;
	private String roleName;
	private String description;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.role", cascade = CascadeType.ALL)
	private List<UserRoleEntity> userRole;
	
	public RoleEntity(long id, String roleName, String description, List<UserRoleEntity> userRole) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.description = description;
		this.userRole = userRole;
	}
	public List<UserRoleEntity> getUserRole() {
		return userRole;
	}
	public void setUserRole(List<UserRoleEntity> userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", roleName=" + roleName + ", description=" + description + "]";
	}
	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleEntity(long id, String roleName, String description) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}