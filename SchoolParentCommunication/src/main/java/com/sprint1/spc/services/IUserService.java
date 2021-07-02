package com.sprint1.spc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.UserNotFoundException;

@Service
public interface IUserService {
	public User addNewUser(User user);
	public User getUserEmail(String emailId);
	public User signIn(String emailId,String password)  throws UserNotFoundException;
	public User signOut(String emailId,String password);
	public List<User> getAllUsers();
	public List<User> listUserByRole(Role role);
	public User getUserById(Long id);
}