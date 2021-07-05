package com.sprint1.spc.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.UserNotFoundException;

import com.sprint1.spc.repository.IUserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private IUserRepository iUserRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = iUserRepository.findByEmailId(username);

		User validUser = userServiceImpl.findUser(user);

		if (validUser == null) {
			throw new UsernameNotFoundException("User Not Found " + username);
		}
		return new org.springframework.security.core.userdetails.User(validUser.getEmailId(), validUser.getPassword(),
				new ArrayList<>());
	}

	public User save(User user) {
		User newUser = new User();
		newUser.setName(user.getName());

		newUser.setPhoneNumber(user.getPhoneNumber());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmailId(user.getEmailId());

		newUser.setLoggedIn(user.isLoggedIn());
		newUser.setRole(user.getRole());
		return userServiceImpl.addNewUser(newUser);
	}
}