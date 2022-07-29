//package com.example.springboot2.Config;
// 
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.example.springboot2.Service.ShopmeUserDetailsService;
// 
//@Configuration
//@EnableWebSecurity
//
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private ShopmeUserDetailsService ShopmeUserDetailsService;
////	@Autowired
////	private jwtAuthenticationFilter jwtFilter;
//
//	
//
//	 @Override
//	 protected void configure(HttpSecurity http) throws Exception{
//		 http        
//		               .csrf()
//		               .disable()
//		               .cors()
//		               .and().authorizeRequests()
//		               .antMatchers("/token").permitAll()
//		               .anyRequest().authenticated()
//		               .and()
//		               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		 http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	 
//	 }
//	 @Override
//	 protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		 auth.userDetailsService(ShopmeUserDetailsService);
//	 
//}
//	 @Bean
//	 public PasswordEncoder passwordEncoder() {
//		 return NoOpPasswordEncoder.getInstance();
//	 }
//	 @Override
//	 @Bean
//	 public AuthenticationManager authenticationManagerBean() throws Exception {
//	     return super.authenticationManagerBean();
//	 }
	 
//	 @Override
//	 @Bean
//	 public jwtAuthenticationFilter authenticationFilter() {
//		 return new authenticationFilter
//	 }
//	 @Configuration 
//	 public class SpringConfig { 
//
//	 @Bean
//	 public TransactionService transactionService() {
//	     return new TransactionServiceImpl();
//	 }
//
//	 }

//}
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new ShopmeUserDetailsService();
//    }
// 
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
// 
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//     
//        http.authorizeRequests().antMatchers("/token").permitAll()
//                .antMatchers("/users/**", "/settings/**").hasAuthority("Admin")
////                .hasAnyAuthority("Admin", "Editor", "Salesperson")
////                .hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")
////                .anyRequest().authenticated()
////                .and().formLogin()
////                .loginPage("/login")
////                    .usernameParameter("email")
////                    .permitAll()
//                .and()
//                .rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
//                .and()
//                .logout().permitAll();
// 
//        http.headers().frameOptions().sameOrigin();
// 
//        return http.build();
//    }
// 
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
//    }
// 
//}
