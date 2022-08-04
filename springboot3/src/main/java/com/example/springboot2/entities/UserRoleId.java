package com.example.springboot2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class UserRoleId {
	@Id
	
	private Users users;
	private RoleEntity role;
	
	

	@Override
	public String toString() {
		return "UserRoleId [users=" + users + ", role=" + role + "]";
	}







	public UserRoleId(Users users, RoleEntity role) {
		super();
		this.users = users;
		this.role = role;
	}







	public Users getUsers() {
		return users;
	}







	public void setUsers(Users users) {
		this.users = users;
	}







	public UserRoleId() {
		super();
		// TODO Auto-generated constructor stub
	}



	

	

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	


}
