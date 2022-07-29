//package com.example.springboot2.Config;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.example.springboot2.Service.ShopmeUserDetailsService;
//import com.example.springboot2.helper1.jwtUtil;
//@Component
//public class jwtAuthenticationFilter extends OncePerRequestFilter {
//	
//	
//	@Autowired
//	private ShopmeUserDetailsService shopmeUserDetailsService;
//	
//	@Autowired
//	private jwtUtil JwtUtil;
//	
//
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String requestTokenHeader=request.getHeader("Authorization");
//		String username=null;
//		String jwtToken=null;
//		
//		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer"))
//		{
//			jwtToken=requestTokenHeader.substring(6);
//			try {
//				username=this.JwtUtil.getEmailFromToken(jwtToken);
//			}
//				
//			catch (Exception e)
//			{
//				e.printStackTrace();
//			}
//			UserDetails userDetails=this.shopmeUserDetailsService.loadUserByUsername(username);
//			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
//			{
//				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
//						usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//								SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//			}
//			else
//			{
//				System.out.println("Token is not validated");
//			}
//			
//			filterChain.doFilter(request, response);
//		}
//
//}
//}
