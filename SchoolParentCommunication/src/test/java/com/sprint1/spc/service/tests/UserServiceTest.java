package com.sprint1.spc.service.tests;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.UserNotFoundException;
import com.sprint1.spc.repository.IUserRepository;
import com.sprint1.spc.services.UserServiceImpl;

public class UserServiceTest {

	@InjectMocks
	
	@Autowired
	private UserServiceImpl userService;
	
	
	@Mock
	private IUserRepository userRepo;
	

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.openMocks(this);
	}

	
	@Test
	public void createUserTest() throws UserNotFoundException {
		
		User user = new User(1l,"mister","1234","1245","mister@gmail.com",Role.PARENT);

		when(userRepo
				.saveAndFlush(user))
		.thenReturn(user);

//		Assertions.assertEquals(user, userService.addUser(user));
		
	}
	
	@Test
	public void getAllUsersTest() {
		
		User user = new User(1l,"mister","1234","1245","mister@gmail.com",Role.ADMIN);
		User user1 = new User(2l,"miser","1234","1245","miser@gmail.com",Role.PARENT);
		
		List<User> usersList = new ArrayList<User>();
		usersList.add(user);
		usersList.add(user1);
		
		when(userRepo.findAll()).thenReturn(usersList);
		
//		Assertions.assertEquals(2, userService.listAllUsers().size());
	}
	
	
	@Test
	public void UserSignInTest() throws UserNotFoundException {

		User user = new User();
		user.setEmailId("rise@gmail.com");
		user.setPassword("1758");

		when(userRepo.findByEmailIdAndPassword("rise@gmail.com", "1758"))
		.thenReturn(user);
		user = userService.signOut("rise@gmail.com","1758");
//		Assertions.assertEquals(true,user.isLoggedIn());

	}
	
	@Test
	public void UserSignOutTest() {
		
		User user = new User();
		user.setEmailId("rise@gmail.com");
		user.setPassword("1758");
		when(userRepo.findByEmailIdAndPassword("rise@gmail.com", "1758"))
		.thenReturn(user);
		user = userService.signOut("rise@gmail.com","1758");
		Assertions.assertEquals(false,user.isLoggedIn());
	}
	
}
