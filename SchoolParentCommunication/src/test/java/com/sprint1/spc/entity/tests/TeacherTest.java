package com.sprint1.spc.entity.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.entities.Teacher;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TeacherTest {

	@Autowired
	private EntityManager entityManager;

	@Test
	public void crudOperations() {

		
		final Subject subject = new Subject();
		subject.setSubjectTitle("Maths");
		final Subject subject1 = new Subject();
		subject1.setSubjectTitle("Physics");
		final Subject subject2= new Subject();
		subject2.setSubjectTitle("Chemistry");
		
		final List<Subject> subjects = new ArrayList<Subject>();
		subjects.add(subject);
		subjects.add(subject1);
		subjects.add(subject2);

		final Teacher teacher = new Teacher();
		teacher.setName("Shree Mundade");
		teacher.setEmailId("shreemundade@gmail.com");
		teacher.setPhoneNumber("7276377795");
		teacher.setPassword("Shree@123");
		teacher.setRole(Role.TEACHER);
		teacher.setSubjects(subjects);
			
		entityManager.persist(subject);
		entityManager.persist(subject1);
		entityManager.persist(subject2);
		entityManager.persist(teacher);
		

		final List<Teacher> listOfTeacher = entityManager.createQuery("select t from Teacher t", Teacher.class)
				.getResultList();
		System.out.println(listOfTeacher);

		assertNotEquals(2, listOfTeacher.size());

		assertEquals(1, listOfTeacher.size());

		assertNotNull(listOfTeacher);

	}

}
