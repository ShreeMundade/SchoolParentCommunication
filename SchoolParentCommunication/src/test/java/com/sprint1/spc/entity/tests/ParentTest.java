package com.sprint1.spc.entity.tests;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Student;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ParentTest {
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void crudOperations()
	{
		final Parent parent = new Parent();
		parent.setName("Yash");
		parent.setPassword("Yash1996");
		parent.setEmailId("yashp@gmail.com");
		parent.setPhoneNumber(1234567890L);
		
		final Student student = new Student();
		student.setName("Abc");
		student.setPassword("Yash1996");
		student.setEmailId("yashp@gmail.com");
		student.setPhoneNumber(1234567890L);
		
		
		Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(student);
		
		parent.setStudents(studentSet);
		
		
		entityManager.persist(student);
		
		entityManager.persist(parent);
		
		final List<Parent> listOfParent = entityManager.createQuery("select p from Parent p", Parent.class).getResultList();
		
		Assertions.assertEquals(1, listOfParent.size());
	}
}