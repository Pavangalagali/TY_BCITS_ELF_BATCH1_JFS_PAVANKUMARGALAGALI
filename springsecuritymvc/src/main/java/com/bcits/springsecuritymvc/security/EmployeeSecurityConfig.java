package com.bcits.springsecuritymvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder  getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/index","/register").permitAll()
//		.anyRequest().hasRole("USER").anyRequest().authenticated()
//		.anyRequest().hasRole("ADMIN").anyRequest().authenticated()
		.antMatchers("/userHome").hasRole("USER")
		.antMatchers("/adminHome").hasRole("ADMIN")
		.and()
		.formLogin()
		.and()
		.logout().logoutSuccessUrl("/index");
	}
	
}
