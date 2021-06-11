
package com.sprint1.spc.service.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint1.spc.entities.Exam;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.repository.ITeacherRepository;
import com.sprint1.spc.services.TeacherServiceImpl;

public class TeacherServiceTest {

	@InjectMocks

	@Autowired
	private TeacherServiceImpl teacherService;

	@Mock
	private ITeacherRepository teacherRepo;

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void addTeacherTest() {
		Teacher teacher = new Teacher("shree", "Shree@123", 7276377795L, "shree@gmail.com", Role.TEACHER);
		when(teacherRepo.saveAndFlush(teacher)).thenReturn(teacher);
		Assertions.assertEquals(teacher, teacherService.addTeacher(teacher));
	}

	@Test
	public void updateTeacher() {
		List<Subject> subjects = new ArrayList<Subject>();
		List<StudentClass> stundentClasses = new ArrayList<StudentClass>();
		List<Exam> exams = new ArrayList<Exam>();
		Teacher teacher = new Teacher(1l, "shree", "Shree@123", 7276377795L, "shree@gmail.com", Role.TEACHER, subjects,
				stundentClasses, exams);

		when(teacherRepo.findById(teacher.getId())).thenReturn(teacher);
		assertEquals(teacher, teacherService.updateTeacher(teacher));
	}

	@Test
	public void retrieveAllTeachers() {

		List<Subject> subjects = new ArrayList<Subject>();
		List<StudentClass> stundentClasses = new ArrayList<StudentClass>();
		List<Exam> exams = new ArrayList<Exam>();
		List<Teacher> teacher = new ArrayList<Teacher>();
		Teacher teacher1 = new Teacher(1l, "shree", "Shree@123", 7276377795L, "shree@gmail.com", Role.TEACHER, subjects,
				stundentClasses, exams);
		teacher.add(teacher1);
		when(teacherRepo.findAll()).thenReturn(teacher);
		List<Teacher> teacherlist=teacherService.retrieveAllTeachers();
		assertNotNull(teacherlist);

	}
	@Test
	public void retrieveTeacherById() {
		List<Subject> subjects = new ArrayList<Subject>();
		List<StudentClass> stundentClasses = new ArrayList<StudentClass>();
		List<Exam> exams = new ArrayList<Exam>();
		Teacher teacher1 = new Teacher(1l, "shree", "Shree@123", 7276377795L, "shree@gmail.com", Role.TEACHER, subjects,
				stundentClasses, exams);
	
		when(teacherRepo.findById(teacher1.getId())).thenReturn(teacher1);
		assertEquals(teacher1, teacherService.retrieveTeacherById(teacher1.getId()));
		
		
	}
}
