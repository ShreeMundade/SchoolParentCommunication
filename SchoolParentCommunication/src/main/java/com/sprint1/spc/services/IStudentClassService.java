package com.sprint1.spc.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Exam;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.StudentClass;

@Service
@Transactional
public interface IStudentClassService {
	public StudentClass addStudentClass(StudentClass studentClass);

	public StudentClass deleteStudentClassById(long studentClassId);

	public List<StudentClass> retrieveAllStudentClass();

	public StudentClass updateStudentClassById(@Valid StudentClass studentclass);

	public StudentClass updateTeacherToClass(@Valid long teacherId, StudentClass studentClass);

	public StudentClass listClassById(@Valid long classId);
	
	public List<StudentClass> listAllClassesByTeacherId(long teacherId);

	public List<StudentClass> listAllClassesByStudentId(long studentId);

}