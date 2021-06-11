
package com.sprint1.spc.service.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint1.spc.entities.Exam;
import com.sprint1.spc.entities.ExamAttempt;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.repository.IExamRepository;
import com.sprint1.spc.services.ExamServiceImpl;

public class ExamServiceTest {

	@InjectMocks
	
	@Autowired
	private ExamServiceImpl examService;
	
	
	@Mock
	private IExamRepository examRepo;
	

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.openMocks(this);
	}

	
	@Test
	public void createExamTest() {
		Teacher teacher =new Teacher("shree","1234");
		Subject subject=new Subject("maths");
		final ExamAttempt examattempt=new ExamAttempt(true,100);
		Exam exam = new Exam(11l, LocalDate.now(),100.0,teacher,examattempt,subject);
		Exam exam1 = new Exam(12l, LocalDate.now(),100d,teacher,examattempt,subject);
				
		when(examRepo
				.save(exam1))
				.thenReturn(exam);
		
		Assertions.assertEquals(exam, examService.addExam(exam1));
		
	}
	@Test
	   public void ListExamByIdTest()
	   {
		  Teacher teacher =new Teacher("shree","1234");
		  Subject subject=new Subject("maths");
		  final ExamAttempt examattempt=new ExamAttempt(true,100);
		   Exam exam = new Exam(11l, LocalDate.now(),100d,teacher,examattempt,subject);
		   when(examRepo.getById(11l)).thenReturn(exam);
		   Assertions.assertEquals(exam,examService.listExamById(11l));
		   

	   }
	@Test
	  public void updateExamByIdTest() {
		Teacher teacher =new Teacher("shree","1234");
		  Subject subject=new Subject("maths");
		  final ExamAttempt examattempt=new ExamAttempt(true,100);
		   Exam exam = new Exam(11l, LocalDate.now(),100d,teacher,examattempt,subject);
		   when(examRepo.findById(exam.getExamId())).thenReturn(Optional.of(exam));
		   Assertions.assertEquals(exam,examService.updateExam(11l,exam));   
	
	}
	@Test
	public void ListAllExamsByDate(){
		Teacher teacher =new Teacher("shree","1234");
		Subject subject=new Subject("maths");
		final ExamAttempt examattempt=new ExamAttempt(true,100);
		Exam exam1 = new Exam(11l, LocalDate.now(),100.0,teacher,examattempt,subject);
		Exam exam2 = new Exam(12l, LocalDate.now(),100d,teacher,examattempt,subject);
		List<Exam> examList=new ArrayList<Exam>();
		examList.add(exam1);
		examList.add(exam2);
		when(examRepo.findByDateOfExam(LocalDate.now())).thenReturn(examList);
		List<Exam> e1=examService.listAllExamsByDate(LocalDate.now());
		assertEquals(2,e1.size());
		verify(examRepo,times(1)).findByDateOfExam(LocalDate.now());
		
		
	} 
		
		
	}
	
	

	
	
	
