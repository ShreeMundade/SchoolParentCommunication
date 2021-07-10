package com.sprint1.spc.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Attendance;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.exception.UserNotFoundException;

@Service
@Transactional
public interface IStudentService {
	public Student addStudent(Student student);
	public Student updateStudent(Student student) throws UserNotFoundException;
	public Student deleteStudent(Student student);
	public List<Student> retrieveAllStudents();
	public Student retrieveStudentById(long id) throws UserNotFoundException;
	public Student listStudentById(long studentId);
	public Student updateStudentClassToStudent(long studentId, long classId);
	public long retreiveStudentById1(long id);
	public List<Attendance> listAllAttendanceByStudentId(long studentId);
	public Student updateStudentById(Student student);
	public Student getStudentByParentId(long parentId);
}