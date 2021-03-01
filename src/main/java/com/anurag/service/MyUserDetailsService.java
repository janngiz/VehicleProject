
package com.anurag.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anurag.entities.User;
import com.anurag.models.MyUserDetails;
import com.anurag.repository.IUserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		//hardcoded user, Dont need MyUserDetails class
		//return  new User("foo","foo", new ArrayList<>());

		
		
		  Optional<User> user = userRepository.findByUsername(username);
		  
		  
		  user.orElseThrow(() -> new UsernameNotFoundException("Not found: " +
		  username));
		  
		  return user.map(MyUserDetails::new).get();
		 
		
		 
	}

}