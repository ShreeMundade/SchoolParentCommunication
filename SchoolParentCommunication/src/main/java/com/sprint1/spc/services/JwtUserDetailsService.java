package com.sprint1.spc.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Accountant;
import com.sprint1.spc.entities.Admin;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.UserNotFoundException;
import com.sprint1.spc.repository.IAccountantRepository;
import com.sprint1.spc.repository.IAdminRepository;
import com.sprint1.spc.repository.IParentRepository;
import com.sprint1.spc.repository.IStudentRepository;
import com.sprint1.spc.repository.ITeacherRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private IAccountantRepository iAccountantRepository;

	@Autowired
	private IAdminRepository iAdminRepository;

	@Autowired
	private ITeacherRepository iTeacherRepository;

	@Autowired
	private IParentRepository iParentRepository;
	@Autowired
	private IStudentRepository iStudentRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = new User();

		if (username != null) {
			if (iAccountantRepository.findByEmailId(username) != null) {
				user = iAccountantRepository.findByEmailId(username);
			} else if (iAdminRepository.findByEmailId(username) != null) {
				user = iAdminRepository.findByEmailId(username);
			} else if (iTeacherRepository.findByEmailId(username) != null) {
				user = iTeacherRepository.findByEmailId(username);
			} else if (iParentRepository.findByEmailId(username) != null) {
				user = iParentRepository.findByEmailId(username);
			}else if (iStudentRepository.findByEmailId(username) != null) {
				user = iStudentRepository.findByEmailId(username);
			}
		}

		User validUser = userServiceImpl.findUser(user);

		if (validUser == null) {
			throw new UsernameNotFoundException("User Not Found " + username);
		}
		return new org.springframework.security.core.userdetails.User(validUser.getEmailId(), validUser.getPassword(),
				new ArrayList<>());
	}

	public User save(User user) throws UserNotFoundException {
		if (user.getRole() == Role.ADMIN) {
			Admin admin = iAdminRepository.findByEmailId(user.getEmailId());
			if (admin == null) {
				Admin adm = new Admin();
				adm.setName(user.getName());
				adm.setPhoneNumber(user.getPhoneNumber());
				adm.setPassword(bcryptEncoder.encode(user.getPassword()));
				adm.setEmailId(user.getEmailId());
				adm.setLoggedIn(user.isLoggedIn());
				adm.setRole(user.getRole());
				return userServiceImpl.addUser(adm);
			}
		} else if (user.getRole() == Role.ACCOUNTANT) {
			Accountant accountant = iAccountantRepository.findByEmailId(user.getEmailId());
			if (accountant == null) {
				Accountant acc = new Accountant();
				acc.setName(user.getName());
				acc.setPhoneNumber(user.getPhoneNumber());
				acc.setPassword(bcryptEncoder.encode(user.getPassword()));
				acc.setEmailId(user.getEmailId());
				acc.setLoggedIn(user.isLoggedIn());
				acc.setRole(user.getRole());
				return userServiceImpl.addUser(acc);
			}
		} else if (user.getRole() == Role.PARENT) {
			Parent parent = iParentRepository.findByEmailId(user.getEmailId());
			if (parent == null) {
				Parent par = new Parent();
				par.setName(user.getName());
				par.setPhoneNumber(user.getPhoneNumber());
				par.setPassword(bcryptEncoder.encode(user.getPassword()));
				par.setEmailId(user.getEmailId());
				par.setLoggedIn(user.isLoggedIn());
				par.setRole(user.getRole());
				return userServiceImpl.addUser(par);
			}
		} else if (user.getRole() == Role.TEACHER) {
			Teacher teacher = iTeacherRepository.findByEmailId(user.getEmailId());
			if (teacher == null) {
				Teacher teac = new Teacher();
				teac.setName(user.getName());
				teac.setPhoneNumber(user.getPhoneNumber());
				teac.setPassword(bcryptEncoder.encode(user.getPassword()));
				teac.setEmailId(user.getEmailId());
				teac.setLoggedIn(user.isLoggedIn());
				teac.setRole(user.getRole());
				return userServiceImpl.addUser(teac);
			}
		}
		else if (user.getRole() == Role.STUDENT) {
			Student student = iStudentRepository.findByEmailId(user.getEmailId());
			if (student == null) {
				Student stud = new Student();
				stud.setName(user.getName());
				stud.setPhoneNumber(user.getPhoneNumber());
				stud.setPassword(bcryptEncoder.encode(user.getPassword()));
				stud.setEmailId(user.getEmailId());
				stud.setLoggedIn(user.isLoggedIn());
				stud.setRole(user.getRole());
				return userServiceImpl.addUser(stud);
			}
		}
		return null;
	}
}

//import java.util.ArrayList;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.sprint1.spc.entities.User;
//import com.sprint1.spc.exception.UserNotFoundException;
//
//import com.sprint1.spc.repository.IUserRepository;
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private UserServiceImpl userServiceImpl;
//
//	@Autowired
//	private IUserRepository iUserRepository;
//
//	@Autowired
//	private PasswordEncoder bcryptEncoder;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		User user = iUserRepository.findByEmailIdId(username);
//
//		User validUser = userServiceImpl.findUser(user);
//
//		if (validUser == null) {
//			throw new UsernameNotFoundException("User Not Found " + username);
//		}
//		return new org.springframework.security.core.userdetails.User(validUser.getEmailId(), validUser.getPassword(),
//				new ArrayList<>());
//	}
//
//	public User save(User user) {
//		User newUser = new User();
//		newUser.setName(user.getName());
//
//		newUser.setPhoneNumber(user.getPhoneNumber());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		newUser.setEmailId(user.getEmailId());
//
//		newUser.setLoggedIn(user.isLoggedIn());
//		newUser.setRole(user.getRole());
//		return userServiceImpl.addNewUser(newUser);
//	}
//}