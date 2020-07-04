package com.cognizant.authenticationservice.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.models.DefinedUserDetails;
import com.cognizant.authenticationservice.models.User;
import com.cognizant.authenticationservice.repository.UserRepository;

@Service   
// It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
	UserRepository userRepository;
	
	//@Autowired
	//private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findByUserName(userName);
		
		user.<UsernameNotFoundException>orElseThrow(()-> {throw new UsernameNotFoundException("No found "+userName);});
		return user.map(DefinedUserDetails::new).get();

	}	
}