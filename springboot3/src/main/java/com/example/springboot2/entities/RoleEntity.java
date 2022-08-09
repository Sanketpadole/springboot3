package com.example.springboot2.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE roles SET is_active=false WHERE id=?")

@Where(clause="is_active=true")
@Table(name = "roles")
public class RoleEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public RoleEntity() {

		
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Roleid;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "description")
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.role", cascade = CascadeType.ALL)
	private List<UserRoleEntity> userRole;



	

	@Column(name = "is_active")
	private Boolean isActive = true;



	public RoleEntity(Integer id, String roleName, String description, List<UserRoleEntity> userRole, Boolean isActive,
			Date createdAt, Date updatedAt) {
		super();
		this.Roleid = id;
		this.roleName = roleName;
		this.description = description;
	
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date updatedAt;

	public Integer getId() {

		return Roleid;

	}

	public void setId(Integer id) {

		this.Roleid = id;

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
