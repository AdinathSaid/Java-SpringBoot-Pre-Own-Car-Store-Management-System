package com.carzoo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.carzoo.repository.EmployeeRepository;


@Component
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public UserDetails loadUserByUsername(String email_id) throws UsernameNotFoundException {
		com.carzoo.model.Employee emp=employeeRepository.findByEmail(email_id);
		if(emp==null) {//if employee email is null
			throw new UsernameNotFoundException("user not found"+email_id);
		}
		else {
			return new CustomUser(emp);
		}
		
	}

}
