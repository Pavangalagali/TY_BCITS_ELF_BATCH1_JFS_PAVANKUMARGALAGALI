package com.bcits.springsecuritymvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.bcits.springsecuritymvc.dao.EmployeeDAO;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsImpl userDetails = new UserDetailsImpl();
		userDetails.setEmployeeInfo(dao.getEmployee(Integer.parseInt(username)));
		return userDetails;
	}

}
