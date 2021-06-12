package com.sprint1.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.UserNotFoundException;
import com.sprint1.spc.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userRepo;
	
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User addNewUser(User user) {
		return userRepo.saveAndFlush(user);
	}

	@Override
	public User signIn(User user) throws UserNotFoundException {
		User user1 = userRepo
				.findByEmailIdAndPassword(user.getEmailId(), user.getPassword());
		if(user1 != null) {
			user1.setLoggedIn(true);
			userRepo.saveAndFlush(user1);
			return user1;
		}
		else
			throw new UserNotFoundException("User Not Found ! Try registering first...");
	}

	@Override
	public User signOut(User user) {
		user = userRepo
				.findByEmailIdAndPassword(user.getEmailId(), user.getPassword());
		user.setLoggedIn(false);
		userRepo.saveAndFlush(user);
		return user;
		
	}

	@Override
	public User getUserEmail(String emailId) {
		return userRepo.findByEmailId(emailId);
	}

	@Override
	public User getUserById(Long id) {
		return userRepo.findById(id).get();
	}

	
	@Override
	public List<User> listUserByRole(Role role) {
		List<User> userList = userRepo.findByRole(role);
		return userList;
	}
}