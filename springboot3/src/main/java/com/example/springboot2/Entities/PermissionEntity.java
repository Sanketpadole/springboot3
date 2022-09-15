package com.example.springboot2.Entities;

import java.io.Serializable;
import java.sql.Date;
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
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "permissions")
public class PermissionEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "action_name")
	private String actionName;

	@Column(name = "description")
	private String description;

	@Column(name = "method")
	private String method;

	@Column(name = "base_url")
	private String baseUrl;

	@Column(name = "path")
	private String path;

	@Column(name = "is_active")
	private Boolean isActive = true;

	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date updatedAt;
	
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "pk.permission",cascade = CascadeType.ALL)
	private List<RolePermissionEntity> rolePermissionEntity;

	public PermissionEntity(Integer id, String actionName, String description, String method, String baseUrl,
			String path, Boolean isActive, Date createdAt, Date updatedAt,
			List<RolePermissionEntity> rolePermissionEntity) {
		super();
		this.id = id;
		this.actionName = actionName;
		this.description = description;
		this.method = method;
		this.baseUrl = baseUrl;
		this.path = path;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.rolePermissionEntity = rolePermissionEntity;
	}

	public List<RolePermissionEntity> getRolePermissionEntity() {
		return rolePermissionEntity;
	}

	public void setRolePermissionEntity(List<RolePermissionEntity> rolePermissionEntity) {
		this.rolePermissionEntity = rolePermissionEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PermissionEntity(Integer id, String actionName, String description,  String method,
			String baseUrl, String path, Boolean isActive, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.actionName = actionName;
		this.description = description;

		this.method = method;
		this.baseUrl = baseUrl;
		this.path = path;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "PermissionEntity [id=" + id + ", actionName=" + actionName + ", description=" + description
				+ ", method=" + method + ", baseUrl=" + baseUrl + ", path=" + path + ", isActive=" + isActive
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	public PermissionEntity() {
		super();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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