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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IParentService parentService;
	
	
	@PostMapping("/register/parent")
	@ApiOperation(value = "Parent Registration", notes = "Parents can register with us from here.")
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
	@ApiOperation(value = "User Login", notes = "Users can sign in from here.")
	public ResponseEntity<User> loginUser(@RequestBody User user) throws UserNotFoundException{
		
		User userExists = userService.signIn(user);
		
		if(userExists != null && userExists.isLoggedIn() == true) {
			
			return new ResponseEntity<User>(userExists,HttpStatus.OK);
			
		}
		throw new UserNotFoundException("User Not Found ! Try registering first...");

	}


	@PostMapping("/logout")
	@ApiOperation(value = "User Logout", notes = "Users can sign out from here.")
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
