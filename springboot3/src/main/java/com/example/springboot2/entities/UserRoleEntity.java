package com.example.springboot2.entities;



import java.sql.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@SuppressWarnings("serial")
@Entity
@SQLDelete(sql = "UPDATE user_role SET is_active=false WHERE user_id=? AND role_id=?")
@Where(clause="is_active=true")
@Table(name = "user_role")
@AssociationOverrides({ @AssociationOverride(name = "pk.user", joinColumns = @JoinColumn(name = "user_id")), @AssociationOverride(name = "pk.role", joinColumns = @JoinColumn(name = "role_id")) })
public class UserRoleEntity implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private UserRoleId pk = new UserRoleId();

	private Boolean isActive = true;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	@EmbeddedId
	public UserRoleId getPk() {

		return pk;

	}

	public void setPk(UserRoleId pk) {

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
