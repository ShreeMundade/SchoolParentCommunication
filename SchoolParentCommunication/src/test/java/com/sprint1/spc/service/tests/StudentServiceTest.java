package com.sprint1.spc.service.tests;

import static org.mockito.Mockito.when;

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

import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.exception.UserNotFoundException;
import com.sprint1.spc.repository.IStudentRepository;
import com.sprint1.spc.services.StudentServiceImpl;

public class StudentServiceTest {

	@InjectMocks
	@Autowired
	private StudentServiceImpl studentService;
	
	@Mock
	private IStudentRepository studentRepo;
	
//	@Mock
//	private IUserRepository userRepo;

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void createStudentTest() {
		
		Student student = new Student(22,"priyanka","1234",12451L,"priyanka1998@gmail.com",Role.STUDENT);
		when(studentRepo.saveAndFlush(student)).thenReturn(student);
		Assertions.assertEquals(student, studentService.addStudent(student));
		
	}
	@Test
	public void retrieveAllStudentsTest() {
		Student student = new Student(22,"priyanka","1234",12451,"priyanka1998@gmail.com",Role.STUDENT);
		Student student1 = new Student(21,"priyanka","1234",1245l,"priyanka1998@gmail.com",Role.STUDENT);
		List<Student> studentsList = new ArrayList<Student>();
		studentsList.add(student);
		studentsList.add(student1);
		when(studentRepo.findAll()).thenReturn(studentsList);
		Assertions.assertEquals(2, studentService.retrieveAllStudents().size());
	}
	
   @Test
   public void retrieveStudentByIdTest() throws UserNotFoundException
   {
	   Student student = new Student(22L,"priyanka","1234",12451,"priyanka1998@gmail.com",Role.STUDENT);
	   when(studentRepo.findById(22L)).thenReturn(Optional.of(student));
	   Assertions.assertEquals(student,studentService.retrieveStudentById(22L));
   }
   
   @Test
   public void updateStudentTest()
   {
	   Student student = new Student(22,"priyanka","1234",12451,"priyanka1998@gmail.com",Role.STUDENT);
	   when(studentRepo.save(student)).thenReturn(student);
	   Assertions.assertEquals(student,studentService.updateStudent(student));
   }
   
//   @Test
//   public void giveExamTest()
//   {
//	   Teacher teacher = new Teacher("priyanka","1234");
//	   ExamAttempt examattempt = new ExamAttempt(true,60);
//	   Subject subject = new Subject("Maths");
//	   Exam exam = new Exam(12l,LocalDate.now(),100d,teacher,examattempt,subject);
//	   when(studentRepo.findById(exam)).thenReturn(exam);
//	   Assertions.assertEquals(exam, studentService.giveExam(exam));
//	   
//   }

//   @Test
//   public void giveAttendanceTest()
//   {
//	   Attendance attendance = new Attendance(12l,LocalDate.now(),true);
//	   when(studentRepo.findById(attendance)).thenReturn(attendance);
//	   Assertions.assertEquals(attendance,studentService.giveAttendence(attendance));
//   }
   
 }
