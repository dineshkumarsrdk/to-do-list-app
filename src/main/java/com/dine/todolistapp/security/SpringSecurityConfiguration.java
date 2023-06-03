package com.dine.todolistapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	// LDAP or Database
	// In Memory

	// InMemoryUserDetailsManager
	// InMemoryUserDetailsManager(UserDetails... users)

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = createNewUser("dine","dk");
		UserDetails userDetails2 = createNewUser("dinesh","srdk");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	public UserDetails createNewUser(String userID, String password) {
		Function<String, String> encoder
		       				= input -> Encoder().encode(input);
		
		UserDetails userDetails = User.builder()
							.username(userID)
							.password(password)					
							.passwordEncoder(encoder)//this method defined in User
							.roles("ADMIN")
							.build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder Encoder() {
		return new BCryptPasswordEncoder();
	}
		
		//All URLs are protected
		//A login form is shown for unauthorized requests
		//CSRF disable
		//Frames disable
		
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			
			http.authorizeHttpRequests(
					auth -> auth.anyRequest().authenticated());
			http.formLogin();
			
			http.csrf().disable();
			http.headers().frameOptions().disable();
			
			return http.build();
		}

}