package com.developia.endproject.translateApp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

	private final DataSource dataSource;

	@Bean
	public UserDetailsService userDetailsService() {
		JdbcDaoImpl daoImpl = new JdbcDaoImpl();
		daoImpl.setDataSource(dataSource);
		return daoImpl;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeRequests()
				.requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
				.requestMatchers(HttpMethod.GET,"/users/login").permitAll()
				.requestMatchers(HttpMethod.POST,"/users/signup").permitAll()
				.requestMatchers(HttpMethod.POST,"/admin/signup").permitAll()
				.requestMatchers(HttpMethod.POST,"/translate").permitAll()
				.requestMatchers(HttpMethod.POST,"/translate/comment").permitAll()
				.requestMatchers(HttpMethod.GET,"/word/pagination/begin/{begin}/length/{length}").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginProcessingUrl("/authenticate-user").permitAll()
				.and()
				.logout().permitAll()
				.and()
				.httpBasic()
				.and()
				.headers().frameOptions().disable() // Burada frameOptions'ı devre // dışı bırakıyoruz
				.and()
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

}
