package com.sprint1.spc.service.tests;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint1.spc.entities.ExamAttempt;
import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.repository.IStudentExamAttemptRepository;
import com.sprint1.spc.services.StudentExamAttemptServiceImpl;

public class StudentExamAttemptServiceTest {
@InjectMocks
	@Autowired
	private StudentExamAttemptServiceImpl studentExamAttemptService;
			
	@Mock
	private IStudentExamAttemptRepository studentExamAttemptRepo;
	
	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void AddStudentExamAttemptTest() {
		
		ExamAttempt examattempt = new ExamAttempt(true,60);
		ExamAttempt examattempt1= new ExamAttempt(true,70);
		
		when(studentExamAttemptRepo.save(examattempt1)).thenReturn(examattempt);
		Assertions.assertNotEquals(examattempt, studentExamAttemptService.addStudentExamAttempt(examattempt1));
		
	}
	@Test
	public void UpdateStudentExamAttemptTest()
	{
		ExamAttempt examattempt = new ExamAttempt(true,60);
		   
		when(studentExamAttemptRepo.saveAndFlush(examattempt)).thenReturn(examattempt);
		Assertions.assertEquals(examattempt,studentExamAttemptService.updateStudentExamAttempt(examattempt));
	}
	@Test
	public void RetrieveStudentExamAttemptByIdTest()
	{
		ExamAttempt examattempt = new ExamAttempt(true,60);
		when(studentExamAttemptRepo.getById(1l)).thenReturn(examattempt);
		Assertions.assertEquals(examattempt,studentExamAttemptService.retrieveStudentExamAttemptById(1l));

		
	}

}
