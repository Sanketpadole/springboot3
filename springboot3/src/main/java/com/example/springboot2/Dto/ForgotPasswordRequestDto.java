package com.example.springboot2.Dto;

public class ForgotPasswordRequestDto {
	String email;

	public ForgotPasswordRequestDto() {
		super();

	}

	public ForgotPasswordRequestDto(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
