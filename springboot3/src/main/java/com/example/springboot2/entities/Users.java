package com.example.springboot2.entities;

import java.util.Collection;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Users implements UserDetails   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String email;
	private String password;
	private String username;


	

	

	public Users(Integer id, String email, String password, String username) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;

	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", userRole=" +  "]";
	}



	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(Integer id, String email, String password) {
		super();
		this.id = id;
		this.email = email;	
		this.password = password;	
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getEmail();
	}	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	

}
