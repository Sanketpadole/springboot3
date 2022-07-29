//package com.example.springboot2.Service;
//
//import java.util.ArrayList;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.springboot2.exception.ResourceNotFoundException;
//@Service
//public class ShopmeUserDetailsService implements UserDetailsService {

//	@Override
//	public UserDetails loadUserByUsername(Object username,int password) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		if(username.equals("Durgesh"))
//		{
//			return new User("Durgesh","Durgesh",new ArrayList<>());
//		}
//		else {
//			throw new ResourceNotFoundException("user not found");
//	}
	

	

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		if(username.equals("Durgesh"))
//		{
//		return new User("Durgesh","Durgesh",new ArrayList<>());
//	}
//	else {
//		throw new ResourceNotFoundException("user not found");
//	}
//	}


//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public UserDetails loadUserByUsername(String username, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public UserDetails loadUserByUsername(Object username, int password) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
