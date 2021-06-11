package com.sprint1.spc.entity.tests;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sprint1.spc.entities.Exam;
import com.sprint1.spc.entities.ExamAttempt;
import com.sprint1.spc.entities.Subject;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ExamTest {
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void crudOperations()
	{
		final Exam exam = new Exam();
		final Subject subject=new Subject();
		subject.setSubjectTitle("maths");
		final ExamAttempt examattempt=new ExamAttempt();
		examattempt.setAttempted(true);
		examattempt.setMarksObtained(50);
		exam.setSubject(subject);
		exam.setDateOfExam(LocalDate.parse("2022-06-07"));
		exam.setMaximumMarks(100.00d);
		exam.setExamAttempt(examattempt);
		
		entityManager.persist(subject);
		entityManager.persist(exam);
		
		final List<Exam> listOfExams = entityManager.createQuery("select e from Exam e", Exam.class).getResultList();
		
		Assertions.assertEquals(1, listOfExams.size());
	}
}