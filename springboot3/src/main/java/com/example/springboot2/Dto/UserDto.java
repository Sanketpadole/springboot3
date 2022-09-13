package com.example.springboot2.Dto;

public class UserDto {
	private String email;
	private String password;
	private String username;
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
	public UserDto() {
		super();
		
	}
	public UserDto(String email, String password, String username) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
