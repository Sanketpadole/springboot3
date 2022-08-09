package com.example.springboot2.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "logger")
public class LoggerEntity implements Serializable {

	

	public LoggerEntity() {

		// TODO Auto-generated constructor stub
	}

	

	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users userId;

	@Column(name = "token", length = 512)
	private String token;

	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "expire_at")
	private Date expireAt;

	
	boolean is_Active =true;
	



	public LoggerEntity(Long id, Users userId, String token, Date createdAt, Date expireAt, boolean is_Active) {
		super();
		this.id = id;
		this.userId = userId;
		this.token = token;
		this.createdAt = createdAt;
		this.expireAt = expireAt;
		this.is_Active = is_Active;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public boolean isIs_Active() {
		return is_Active;
	}

	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	

	



	


	public String getToken() {

		return token;

	}

	public void setToken(String token) {

		this.token = token;

	}

	public Date getCreatedAt() {

		return createdAt;

	}

	public void setCreatedAt(Date createdAt) {

		this.createdAt = createdAt;

	}

	public Date getExpireAt() {

		return expireAt;

	}

	public void setExpireAt(Date expireAt) {

		this.expireAt = expireAt;

	}

}
