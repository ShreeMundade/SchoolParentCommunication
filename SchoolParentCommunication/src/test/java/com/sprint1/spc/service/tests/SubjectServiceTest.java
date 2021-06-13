package com.sprint1.spc.service.tests;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.repository.ISubjectRepository;
import com.sprint1.spc.services.SubjectServiceImpl;

public class SubjectServiceTest {
@InjectMocks
	
	@Autowired
	private SubjectServiceImpl subjectService;
	
	@Mock
	private ISubjectRepository subjectRepo;
	
	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void addSubjectTest() {
		
		Subject subject = new Subject(1,"Maths");
		
		when(subjectRepo.save(subject)).thenReturn(subject);
		Assertions.assertEquals(subject, subjectService.addSubject(subject));
		
	}
	@Test
	public void retrieveAllSubjectTest() {
		Subject subject = new Subject(1,"Maths");
		Subject subject1 = new Subject(2,"biology");
		
		List<Subject> subjectsList = new ArrayList<Subject>();
		subjectsList.add(subject);
		subjectsList.add(subject1);
		when(subjectRepo.findAll()).thenReturn(subjectsList);
		Assertions.assertEquals(2, subjectService.retrieveAllSubjects().size());
	}
	

}
