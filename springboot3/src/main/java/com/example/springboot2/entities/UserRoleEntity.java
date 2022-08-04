package com.example.springboot2.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class UserRoleEntity{
	@Id
	private UserRoleId pk;
	public UserRoleId getPk() {
		return pk;
	}
	public void setPk(UserRoleId pk) {
		this.pk = pk;
	}
	private Boolean isActive=true;
	private Date createdAt;
	private Date updatedAt;
	
	
	@Override
	public String toString() {
		return "UserRoleEntity [ isActive=" + isActive + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	public UserRoleEntity( Boolean isActive, Date createdAt, Date updatedAt) {
		super();
		
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}


