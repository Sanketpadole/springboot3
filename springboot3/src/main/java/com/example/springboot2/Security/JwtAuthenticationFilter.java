package com.example.springboot2.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.springboot2.Config.MultiReadHttpServletRequest;
import com.example.springboot2.Service.AuthServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private AuthServiceImpl customUserDetailService;
	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

//		get token
		String requestToken = request.getHeader("Authorization");

//		Bearer 476987njik

		System.out.println("requestToken" + requestToken);
		MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest(request);
		String username = null;
		String token = null;

		if (request != null && requestToken.startsWith("Bearer ")) {
			token = requestToken.substring(7);
			try {
				username = this.jwtTokenHelper.getEmailFromToken(token);
			} catch (IllegalArgumentException e) {
				System.out.println("unable to get token");
			} catch (ExpiredJwtException e) {
				System.out.println("Jwt token has expired");

			} catch (MalformedJwtException e) {
				System.out.println("invalid jwt");
			}
		} else {
			System.out.println("Jwt token does not begin with bearer");
		}

//		once we get the token,now validate

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.customUserDetailService.loadUserByUsername(username);

			if (this.jwtTokenHelper.validateToken(token, userDetails)) {
//				Authentication

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, token, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			} else {
				System.out.println("Invalid jwt token");
			}
		} else {
			System.out.println("username is null or context is not null");
		}

		filterChain.doFilter(multiReadRequest, response);
		filterChain.doFilter(request, response);

	}

}
