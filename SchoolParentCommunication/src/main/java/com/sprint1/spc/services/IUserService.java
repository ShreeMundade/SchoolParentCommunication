package com.sprint1.spc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.UserNotFoundException;

 

@Service
public interface IUserService {
    
    public User signIn(User user);
    public User signOut(User user);
    public User addUser(User user) throws UserNotFoundException;
    public Optional<User> deleteUser(long id);
    public User deleteUser(User user);
    public User updateUser(User user);
    public List<User> listAllUsers();
    public Optional<User> listUserById(long id);
    public User findUser(User user);
	public List<User> listUserByRole(Role admin);
	public User getByEmailId(String emailId);
	public User signOut(@Valid String emailId, String password);
}

//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.sprint1.spc.entities.Role;
//import com.sprint1.spc.entities.User;
//import com.sprint1.spc.exception.UserNotFoundException;
//
//@Service
//public interface IUserService {
//	public User addNewUser(User user);
//	public User getUserEmail(String emailId);
//	public User signIn(String emailId,String password)  throws UserNotFoundException;
//	public User signOut(String emailId,String password);
//	public List<User> getAllUsers();
//	public List<User> listUserByRole(Role role);
//	public User getUserById(Long id);
//	public User findUser(User user);
//}