package com.sprint1.spc.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Attendance;
import com.sprint1.spc.entities.Exam;
import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;


@Service
public interface IStudentService {
	public Student addStudent(Student student);
	public Student updateStudent(Student student);
	public Student deleteStudent(Student student);
	public List<Student> retrieveAllStudents();
	public Student retrieveStudentById(long id);
//	public Exam giveExam(Exam exam);
//	public Attendance giveAttendence(Attendance attendance);
	public Student listStudentById(long studentId);
	public Student updateStudentClassToStudent(long id, Student student);
	public long retreiveStudentById1(long id);
	
	
	

}
