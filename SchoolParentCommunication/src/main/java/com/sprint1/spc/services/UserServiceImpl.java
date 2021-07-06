package com.sprint1.spc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.sprint1.spc.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private AccountantServiceImpl accountantServiceImpl;

	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@Autowired
	private TeacherServiceImpl teacherServiceImpl;

	@Autowired
	private ParentServiceImpl parentServiceImpl;

	@Autowired
	private StudentServiceImpl studentServiceImpl;

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
	private IUserRepository iUserRepository;

	@Override
	public User signIn(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listUserByRole(Role role) {
		List<User> userList = iUserRepository.findByRole(role);
		return userList;
	}

	@Override
	public User addUser(User user) throws UserNotFoundException {
		if (user.getRole() == Role.ADMIN) {
			adminServiceImpl.addAdmin((Admin) user);
			return user;
		} else if (user.getRole() == Role.ACCOUNTANT) {
			accountantServiceImpl.addAccountant((Accountant) user);
			return user;
		} else if (user.getRole() == Role.PARENT) {
			parentServiceImpl.addParent((Parent) user);
			return user;
		} else if (user.getRole() == Role.TEACHER) {
			teacherServiceImpl.addTeacher((Teacher) user);
			return user;
		} else if (user.getRole() == Role.STUDENT) {
			studentServiceImpl.addStudent((Student) user);
			return user;
		}
		return null;
	}

	@Override
	public User findUser(User user) {
		if (iAdminRepository.findByEmailId(user.getEmailId()) != null) {
			Admin admin = iAdminRepository.findByEmailId(user.getEmailId());
			return admin;
		} else if (iAccountantRepository.findByEmailId(user.getEmailId()) != null) {
			Accountant accountant = iAccountantRepository.findByEmailId(user.getEmailId());
			return accountant;
		} else if (iParentRepository.findByEmailId(user.getEmailId()) != null) {
			Parent parent = iParentRepository.findByEmailId(user.getEmailId());
			return parent;
		} else if (iTeacherRepository.findByEmailId(user.getEmailId()) != null) {
			Teacher teacher = iTeacherRepository.findByEmailId(user.getEmailId());
			return teacher;
		} else if (iStudentRepository.findByEmailId(user.getEmailId()) != null) {
			Student student = iStudentRepository.findByEmailId(user.getEmailId());
			return student;
		}

		return null;
	}

	@Override
	public Optional<User> deleteUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> listUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signOut(String emailId, String password) {
		User user = iUserRepository.findByEmailIdAndPassword(emailId, password);
		user.setLoggedIn(false);
		iUserRepository.saveAndFlush(user);
		return user;

	}

	@Override
	public User getByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

}

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sprint1.spc.spc.entities.Role;
//import com.sprint1.spc.spc.entities.User;
//import com.sprint1.spc.spc.exception.UserNotFoundException;
//import com.sprint1.spc.spc.repository.IUserRepository;
//
//@Service
//public class UserServiceImpl implements IUserService{
//
//	@Autowired
//	private IUserRepository userRepo;
//	
//	@Override
//	public List<User> getAllUsers() {
//		return userRepo.findAll();
//	}
//
//	@Override
//	public User addNewUser(User user) {
//		return userRepo.saveAndFlush(user);
//	}
//
//	@Override
//	public User signIn(String emailId,String password) throws UserNotFoundException {
//		User user = userRepo.findByEmailIdIdAndPassword(emailId, password);
//		if(user != null) {
//			user.setLoggedIn(true);
//			userRepo.saveAndFlush(user);
//			return user;
//		}
//		else
//			throw new UserNotFoundException("User Not Found ! Try registering first...");
//	}
//
//	@Override
//	public User signOut(String emailId,String password) {
//		User user = userRepo
//				.findByEmailIdIdAndPassword(emailId, password);
//		user.setLoggedIn(false);
//		userRepo.saveAndFlush(user);
//		return user;
//		
//	}
//
//	@Override
//	public User getUserEmail(String emailId) {
//		return userRepo.findByEmailIdId(emailId);
//	}
//
//	@Override
//	public User getUserById(Long id) {
//		return userRepo.findById(id).get();
//	}
//
//	
//	@Override
//	public List<User> listUserByRole(Role role) {
//		List<User> userList = userRepo.findByRole(role);
//		return userList;
//	}
//
//	public void loginUser(String userName) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//    public User findUser(User user) {
//        return userRepo.findByEmailIdId(user.getEmailId());
//    }
//
//	
//}