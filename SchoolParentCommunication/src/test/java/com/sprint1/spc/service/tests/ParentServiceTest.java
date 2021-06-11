package com.sprint1.spc.service.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint1.spc.entities.Exam;
import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.repository.IParentRepository;
import com.sprint1.spc.services.ParentServiceImpl;

public class ParentServiceTest {

	@InjectMocks
	@Autowired
	private ParentServiceImpl parentServiceImpl;

	@Mock
	private IParentRepository iParentRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void addParentTest() {
		Set<Student> studentSet1 = new HashSet<Student>();
		studentSet1.add(new Student(1L, "Yash", "Yash1234", 1234567890L, "yash@gmail.com", Role.STUDENT));
		studentSet1.add(new Student(2L, "Rohit", "Rohit1234", 1234567890L, "rohit@gmail.com", Role.STUDENT));

		Set<Student> studentSet2 = new HashSet<Student>();
		studentSet2.add(new Student(1L, "Shree", "Shree1234", 1234567890L, "shree@gmail.com", Role.STUDENT));
		studentSet2
				.add(new Student(2L, "Shreyansh", "Shreyansh1234", 1234567890L, "shreyansh@gmail.com", Role.STUDENT));

		Parent parent1 = new Parent(1L, "Yash", "Yash1234", 1234567890L, "yash@gmail.com", Role.PARENT, studentSet1
				);
		Parent parent2 = new Parent(2L, "Mayur", "Mayur1234", 1234567890L, "mayur@gmail.com", Role.PARENT, studentSet2
				);

		Mockito.when(iParentRepository.saveAndFlush(parent1)).thenReturn(parent2);
		assertEquals(parent2, parentServiceImpl.addParent(parent1));
	}

	@Test
	public void retrieveAllParentsTest() {
		Set<Student> studentSet1 = new HashSet<Student>();
		studentSet1.add(new Student(1L, "Yash", "Yash1234", 1234567890L, "yash@gmail.com", Role.STUDENT));
		studentSet1.add(new Student(2L, "Rohit", "Rohit1234", 1234567890L, "rohit@gmail.com", Role.STUDENT));

		Set<Student> studentSet2 = new HashSet<Student>();
		studentSet2.add(new Student(1L, "Shree", "Shree1234", 1234567890L, "shree@gmail.com", Role.STUDENT));
		studentSet2
				.add(new Student(2L, "Shreyansh", "Shreyansh1234", 1234567890L, "shreyansh@gmail.com", Role.STUDENT));

		List<Parent> parent=new ArrayList<Parent>();
		Parent parent1=new Parent(1L, "Yash", "Yash1234", 1234567890L, "yash@gmail.com", Role.PARENT, studentSet1);
		Parent parent2=new Parent(2L, "Mayur", "Mayur1234", 1234567890L, "mayur@gmail.com", Role.PARENT, studentSet2);
		parent.add(parent1);
		parent.add(parent2);
		when(iParentRepository.findAll()).thenReturn(parent);
		List<Parent> parentlist=parentServiceImpl.retrieveAllParents();
		assertNotNull(parentlist);
	}
	
	@Test
	public void retrieveParentByIdTest() {
		Set<Student> studentSet1 = new HashSet<Student>();
		studentSet1.add(new Student(1L, "Yash", "Yash1234", 1234567890L, "yash@gmail.com", Role.STUDENT));
		studentSet1.add(new Student(2L, "Rohit", "Rohit1234", 1234567890L, "rohit@gmail.com", Role.STUDENT));

		Set<Student> studentSet2 = new HashSet<Student>();
		studentSet2.add(new Student(1L, "Shree", "Shree1234", 1234567890L, "shree@gmail.com", Role.STUDENT));
		studentSet2
				.add(new Student(2L, "Shreyansh", "Shreyansh1234", 1234567890L, "shreyansh@gmail.com", Role.STUDENT));

		
		Parent parent1 = new Parent(1L, "Yash", "Yash1234", 1234567890L, "yash@gmail.com", Role.PARENT, studentSet1);
		Parent parent2 = new Parent(2L, "Mayur", "Mayur1234", 1234567890L, "mayur@gmail.com", Role.PARENT, studentSet2);

		Mockito.when(iParentRepository.getById(1L)).thenReturn(parent1);
		assertEquals(parent1, parentServiceImpl.retrieveParentById(1L));

		Mockito.when(iParentRepository.getById(2L)).thenReturn(parent2);
		assertEquals(parent2, parentServiceImpl.retrieveParentById(2L));
	}

	@Test
	public void updateParentTest() {
		Set<Student> studentSet1 = new HashSet<Student>();
		studentSet1.add(new Student(1L, "Yash", "Yash1234", 1234567890L, "yash@gmail.com", Role.STUDENT));
		studentSet1.add(new Student(2L, "Rohit", "Rohit1234", 1234567890L, "rohit@gmail.com", Role.STUDENT));

		
		Parent parent1 = new Parent(1L, "Yash", "Yash1234", 1234567890L, "yash@gmail.com", Role.PARENT, studentSet1);

		Mockito.when(iParentRepository.getById(parent1.getId())).thenReturn(parent1);
		assertEquals(parent1, parentServiceImpl.updateParent(1L, parent1));
	}
}