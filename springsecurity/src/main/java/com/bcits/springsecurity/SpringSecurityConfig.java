package com.bcits.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends  WebSecurityConfigurerAdapter{

	@SuppressWarnings("deprecation")
	@Bean
	public InMemoryUserDetailsManager getInMemoryUserDetails() {
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		
		userDetailsManager.createUser(User.withDefaultPasswordEncoder()
				.username("user").password("qwerty").roles("user").build()
				);
		
		userDetailsManager.createUser(User.withDefaultPasswordEncoder()
				.username("admin").password("admin123").roles("admin").build());
	
		return userDetailsManager;
	}//end of getInMemoryUserDetails
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
         http.csrf().disable()
         .authorizeRequests().antMatchers("/index").permitAll()
         .and()
         .authorizeRequests().antMatchers("/adminHome").hasRole("admin")
         .and()
         .authorizeRequests().antMatchers("/userHome").hasRole("user")
         .and()
         .formLogin().loginPage("/login")
         .and()
         .logout().logoutSuccessUrl("/index");
	
	}// end of configure()
	
}
