package com.sprint1.spc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.ExamAttempt;
import com.sprint1.spc.entities.Student;

@Service
public interface IStudentExamAttemptService {
	public ExamAttempt addStudentExamAttempt(ExamAttempt attempt);
	public ExamAttempt updateStudentExamAttempt(ExamAttempt attempt);
	public ExamAttempt deleteStudentExamAttempt(ExamAttempt attempt);
	public List<ExamAttempt> retrieveAllStudentExamAttemptByStudent(Student student);
	public ExamAttempt retrieveStudentExamAttemptById(int id);
	
	
}