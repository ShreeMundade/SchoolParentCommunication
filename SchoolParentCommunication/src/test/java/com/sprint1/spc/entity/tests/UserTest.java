package com.sprint1.spc.entity.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.User;
import com.sprint1.spc.repository.IUserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTest {

	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void verifyUserCanBeSaved() {
		
		final User user = new User();
		user.setName("raymond");
		user.setEmailId("raymond12@gmail.com");
		user.setPhoneNumber(979797l);
		user.setRole(Role.STUDENT);
		user.setPassword("1234");
		
		entityManager.persist(user);
		
		final List<User> listOfUser = entityManager
				.createQuery("SELECT u FROM User u",User.class).getResultList();
		
		Assertions.assertEquals(1, listOfUser.size());
		
	}
	
	@Autowired
	private IUserRepository userRepo;
	
	@Test
	public void UserCrudOperations() {
		
		final User user = new User();
		user.setName("jayz");
		user.setEmailId("jayz@gmail.com");
		user.setPhoneNumber(654654l);
		user.setRole(Role.ADMIN);
		user.setPassword("1452");
		
		final User user1 = new User();
		user.setName("dieg");
		user.setEmailId("dieg@gmail.com");
		user.setPhoneNumber(67554l);
		user.setRole(Role.PARENT);
		user.setPassword("15789");
		
		
		userRepo.save(user);
		userRepo.save(user1);
		
		final List<User> userList = userRepo.findAll();
		assertEquals(2,userList.size());
		
	}
	
}
