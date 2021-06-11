package com.sprint1.spc.entity.tests;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.entities.Teacher;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentTest {
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void crudOperations()
	{
		final Student student = new Student();
		final StudentClass studentclass = new StudentClass();
		final Teacher teacher = new Teacher();
		
		studentclass.setDivision('A');
		studentclass.setGrade(70);
		studentclass.setClassTeacher(teacher);
		
		student.setPassword("1234");
		student.setPhoneNumber(9611275585L);
		student.setName("priyanka");
		student.setEmailId("priyasn1998@gmail.com");
		student.setRole(Role.STUDENT);
		
		entityManager.persist(teacher);
		entityManager.persist(studentclass);
		entityManager.persist(student);
		
		final List<Student> listOfStudent = entityManager.createQuery("select s from Student s",Student.class).getResultList();
		
		Assertions.assertEquals(1, listOfStudent.size());
		
 
	}
}
