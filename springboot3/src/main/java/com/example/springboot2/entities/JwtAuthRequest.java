package com.example.springboot2.entities;


	

	import java.util.Collection;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import org.springframework.security.core.GrantedAuthority;
	import org.springframework.security.core.userdetails.UserDetails;

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
//		public String getEmail() {
//			return email;
//		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
//		@Override
//		public Collection<? extends GrantedAuthority> getAuthorities() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		@Override
//		public String getUsername() {
//			// TODO Auto-generated method stub
//			return this.email;
//		}
//		@Override
//		public boolean isAccountNonExpired() {
//			// TODO Auto-generated method stub
//			return true;
//		}
//		@Override
//		public boolean isAccountNonLocked() {
//			// TODO Auto-generated method stub
//			return true;
//		}
//		@Override
//		public boolean isCredentialsNonExpired() {
//			// TODO Auto-generated method stub
//			return true;
//		}
//		@Override
//		public boolean isEnabled() {
//			// TODO Auto-generated method stub
//			return true;
//		}
//		public String getEmail() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		@Override
//		public Collection<? extends GrantedAuthority> getAuthorities() {
//			// TODO Auto-generated method stub
//			return null;
//		}
		
		

	}


