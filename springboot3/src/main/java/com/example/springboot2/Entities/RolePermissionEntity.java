package com.example.springboot2.Entities;

import java.sql.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.EmbeddedId;

@SuppressWarnings("serial")
@Entity
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE role_permission SET is_active=false WHERE role_id=? AND permission_id=?")
@Table(name = "role_permission")
@AssociationOverrides({ @AssociationOverride(name = "pk.role", joinColumns = @JoinColumn(name = "role_id")),
		@AssociationOverride(name = "pk.permission", joinColumns = @JoinColumn(name = "permission_id")) })
public class RolePermissionEntity implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public RolePermissionEntity() {

	}

	public RolePermissionEntity(RolePermissionId pk, Boolean isActive, Date createdAt, Date updatedAt) {

		super();
		this.pk = pk;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;

	}

	private RolePermissionId pk = new RolePermissionId();

	private Boolean isActive = true;

	private Date createdAt;

	private Date updatedAt;

	@EmbeddedId
	public RolePermissionId getPk() {

		return pk;

	}

	public void setPk(RolePermissionId pk) {

		this.pk = pk;

	}

	@Column(name = "is_active")
	public Boolean getIsActive() {

		return isActive;

	}

	public void setIsActive(Boolean isActive) {

		this.isActive = isActive;

	}

	@Column(name = "created_at")
	@CreationTimestamp
	public Date getCreatedAt() {

		return createdAt;

	}

	public void setCreatedAt(Date createdAt) {

		this.createdAt = createdAt;

	}

	@Column(name = "updated_at")
	@UpdateTimestamp
	public Date getUpdatedAt() {

		return updatedAt;

	}

	public void setUpdatedAt(Date updatedAt) {

		this.updatedAt = updatedAt;

	}

}
