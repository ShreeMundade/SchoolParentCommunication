package com.sprint1.spc.service.tests;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import com.sprint1.spc.services.StudentClassServiceImpl;
import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.repository.IStudentClassRepository;
public class StudentClassServiceTest {
	
	@InjectMocks
	@Autowired
	private StudentClassServiceImpl StudentClassServiceImpl;
	
	@Mock
	private IStudentClassRepository iStudentClassRepository;
	
	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
	public void addStudentClass() {
		StudentClass s1=new StudentClass(1L,"Sixth Class",6,'A');
		when(iStudentClassRepository.save(s1)).thenReturn(s1);
		StudentClass s2=StudentClassServiceImpl.addStudentClass(s1);
		Assertions.assertEquals(s1, s2);
		verify(iStudentClassRepository,times(1)).save(s1);
	}
	
	@Test
	public void deleteStudentClassById() {
		StudentClass s1=new StudentClass(1L,"Sixth Class",6,'A');
		when(iStudentClassRepository.findById(s1.getClassId())).thenReturn(Optional.of(s1));
		Assertions.assertEquals(s1,StudentClassServiceImpl.deleteStudentClassById(s1.getClassId()));
	}
}
