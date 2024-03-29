package com.example.SpringSecurityDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests(registry->{
			registry.requestMatchers("/public/**").permitAll();
			registry.requestMatchers("/user/**").hasRole("USER");
			registry.requestMatchers("/admin/**").hasRole("ADMIN");
			registry.anyRequest().authenticated();
		}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
		.build();
	}
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.builder().username("user1")
				.password(passwordEncoder().encode("123"))
				.roles("USER")
				.build();
		UserDetails admin1 = User.builder().username("admin1")
				.password(passwordEncoder().encode("456"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user1, admin1);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
