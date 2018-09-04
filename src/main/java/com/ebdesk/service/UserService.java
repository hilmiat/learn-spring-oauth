package com.ebdesk.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ebdesk.model.User;
import com.ebdesk.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostConstruct
	public void tambahUser() {
//		User user = new User();
//		user.setUsername("user1");
//		user.setPassword(bCryptPasswordEncoder.encode("pass1"));
//		user.setIsActive(true);
//		
//		userRepository.save(user);
		
//		user = new User();
//		user.setUsername("user2");
//		user.setPassword(bCryptPasswordEncoder.encode("pass2"));
//		user.setIsActive(true);
//		
//		userRepository.save(user);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username);
		
		if(user == null)
			throw new UsernameNotFoundException("Invalid username or password");
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), 
				user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE ADMIN")));
	}
	
}
