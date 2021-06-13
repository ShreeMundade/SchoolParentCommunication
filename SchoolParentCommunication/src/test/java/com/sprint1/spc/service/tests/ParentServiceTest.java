package com.sprint1.spc.service.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.exception.ParentServiceException;
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
		Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(new Student(1L, "Yash", "Yash1234", 1234567890, "yash@gmail.com", Role.STUDENT));
		studentSet.add(new Student(2L, "Rohit", "Rohit1234", 1234567890, "rohit@gmail.com", Role.STUDENT));
		Parent parent = new Parent(1L, "Yash", "Yash1234", 1234567890, "yash@gmail.com", Role.PARENT, studentSet);
		assertNotNull(parent);
		
		Mockito.when(iParentRepository.save(parent)).thenReturn(parent);
		assertEquals(parent, parentServiceImpl.addParent(parent));
	}

	@Test
	public void retrieveAllParentsTest() {
		Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(new Student(1L, "Yash", "Yash1234", 1234567890, "yash@gmail.com", Role.STUDENT));
		studentSet.add(new Student(2L, "Rohit", "Rohit1234", 1234567890, "rohit@gmail.com", Role.STUDENT));
		List<Parent> parentList = new ArrayList<Parent>();
		Parent parent = new Parent(1L, "Yash", "Yash1234", 1234567890, "yash@gmail.com", Role.PARENT, studentSet);
		parentList.add(parent);
		assertNotNull(parent);
		
		Mockito.when(iParentRepository.findAll()).thenReturn(parentList);
		List<Parent> parentlist = parentServiceImpl.retrieveAllParents();
		assertNotNull(parentlist);
	}

	@Test
	public void retrieveParentByIdTest() {
		Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(new Student(1L, "Yash", "Yash1234", 1234567890, "yash@gmail.com", Role.STUDENT));
		studentSet.add(new Student(2L, "Rohit", "Rohit1234", 1234567890, "rohit@gmail.com", Role.STUDENT));
		Parent parent = new Parent(1L, "Yash", "Yash1234", 1234567890, "yash@gmail.com", Role.PARENT, studentSet);
		assertNotNull(parent);
		
		Mockito.when(iParentRepository.findById(1L)).thenReturn(Optional.of(parent));
		assertEquals(parent, parentServiceImpl.retrieveParentById(1L));
	}

	@Test
	public void updateParentTest() throws ParentServiceException {
		Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(new Student(1L, "Yash", "Yash1234", 1234567890, "yash@gmail.com", Role.STUDENT));
		studentSet.add(new Student(2L, "Rohit", "Rohit1234", 1234567890, "rohit@gmail.com", Role.STUDENT));
		Parent parent = new Parent(1L, "Yash", "Yash1234", 1234567890, "yash@gmail.com", Role.PARENT, studentSet);
		assertNotNull(parent);
		
		Mockito.when(iParentRepository.getById(1L)).thenReturn(parent);
		assertEquals(parent, parentServiceImpl.updateParent(1L, 1234567890));
	}
	
	@Test
	public void updateStudentToParentTest() throws ParentServiceException {
		Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(new Student(1L, "Yash", "Yash1234", 1234567890, "yash@gmail.com", Role.STUDENT));
		studentSet.add(new Student(2L, "Rohit", "Rohit1234", 1234567890, "rohit@gmail.com", Role.STUDENT));
		Parent parent = new Parent(1L, "Yash", "Yash1234", 1234567890, "yash@gmail.com", Role.PARENT, studentSet);
		assertNotNull(parent);
		
		Mockito.when(iParentRepository.getById(1L)).thenReturn(parent);
		assertEquals(parent, parentServiceImpl.updateStudentToParent(1L, parent));
	}
	
	@Test
	public void retrieveParentById1Test() {
		Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(new Student(1L, "Yash", "Yash1234", 1234567890, "yash@gmail.com", Role.STUDENT));
		studentSet.add(new Student(2L, "Rohit", "Rohit1234", 1234567890, "rohit@gmail.com", Role.STUDENT));
		List<Parent> parentList = new ArrayList<Parent>();
		Parent parent1 = new Parent(1L, "Yash", "Yash1234", 1234567890, "yash@gmail.com", Role.PARENT, studentSet);
		parentList.add(parent1);
		assertNotNull(parentList);
		
		Mockito.when(iParentRepository.findAll()).thenReturn(parentList);
		for(Parent parent : parentList) {
			assertEquals(parent.getId(), parentServiceImpl.retrieveParentById1(1L));
		}
	}
}