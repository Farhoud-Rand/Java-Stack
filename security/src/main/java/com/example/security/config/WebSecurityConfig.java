package com.example.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
@Configuration
public class WebSecurityConfig {

	@Autowired HandlerMappingIntrospector introspector;
	private UserDetailsService userDetailsService;

	// Add BCrypt Bean
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.authorizeHttpRequests( auth -> auth
				.requestMatchers(
						new MvcRequestMatcher(introspector, "/admin/**")
						).hasRole("ADMIN")
				.requestMatchers(
						new MvcRequestMatcher(introspector, "/user/**")
						).hasRole("USER")
				.requestMatchers(
						new MvcRequestMatcher(introspector, "/public/**")
						).permitAll()
				.requestMatchers(
						new MvcRequestMatcher(introspector, "/"), new MvcRequestMatcher(introspector, "/home"))
				.authenticated()
				.anyRequest().permitAll()
				)
		//		.formLogin(
		//				form -> form.loginPage("/login")
		//				.defaultSuccessUrl("/home")
		//				.permitAll()
		//				)
		//		.formLogin(form -> form
		//				.loginPage("/login")
		//				.successHandler((request, response, authentication) -> {
		//					// Redirect based on role
		//					if (request.isUserInRole("ADMIN")) {
		//						response.sendRedirect("/admin/home");
		//					} else if (request.isUserInRole("USER")) {
		//						response.sendRedirect("/user/home");
		//					} else {
		//						response.sendRedirect("/home");
		//					}
		//				})
		//		.permitAll()
		//		)
		.formLogin(form -> form
				.loginPage("/login")
				.successHandler(customSuccessHandler())
				.permitAll()
				)
		//		.successHandler(customSuccessHandler())
		//		.permitAll()
		//		)
		.logout(
				logout -> logout.permitAll()
				);

		return http.build();
	}

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	public AuthenticationSuccessHandler customSuccessHandler() {
		return new CustomAuthenticationSuccessHandler();
	}
}