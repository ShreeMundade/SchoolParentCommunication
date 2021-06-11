package com.sprint1.spc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.EmailAlreadyExistsException;
import com.sprint1.spc.exception.UserNotFoundException;
import com.sprint1.spc.services.IParentService;
import com.sprint1.spc.services.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IParentService parentService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> allUsers(){
		
		List<User> listOfUsers = userService.getAllUsers(); 
		return new ResponseEntity<List<User>>(listOfUsers,HttpStatus.OK);
	}
	
	
	@PostMapping("/register/parent")
	public ResponseEntity<User> registerUser(@RequestBody Parent newUser) throws EmailAlreadyExistsException{

		User user = userService.getUserEmail(newUser.getEmailId());

		if(user != null) {

			throw new EmailAlreadyExistsException("Email already exists ! Try to login or register with a different email id");

		}
		newUser.setLoggedIn(false);
		return new ResponseEntity<User>(parentService.addParent(newUser),
				HttpStatus.CREATED);

	}


	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User user) throws UserNotFoundException{
		
		User userExists = userService.signIn(user);
		
		if(userExists != null && userExists.isLoggedIn() == true) {
			
			return new ResponseEntity<User>(userExists,HttpStatus.OK);
			
		}
		throw new UserNotFoundException("User Not Found ! Try registering first...");

	}


	@PostMapping("/logout")
	public ResponseEntity<User> logoutUser(@RequestBody User user){
		
		User userInSystem = userService.signOut(user);
		
		if(userInSystem != null && userInSystem.isLoggedIn() == false) {
			
			return new ResponseEntity<User>(userInSystem,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}

}
