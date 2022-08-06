package com.example.springboot2.entities;


	

	import java.util.Collection;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity

	public class JwtAuthRequest  {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String email;
		private String password;
		private String username;
		
		public JwtAuthRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		public JwtAuthRequest(Long id, String email, String password, String username) {
			super();
			this.id = id;
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
		public String getEmail() {
			return email;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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

		
		

	}


