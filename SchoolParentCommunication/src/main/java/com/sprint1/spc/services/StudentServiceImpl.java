package com.sprint1.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Attendance;
import com.sprint1.spc.entities.Exam;
import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.repository.IStudentRepository;
import com.sprint1.spc.repository.IUserRepository;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentRepository studentRepo;
	@Autowired
	private IUserRepository userRepo;
	
	
	
	@Override
	public Student addStudent(Student student) {
		
		return studentRepo.saveAndFlush(student);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public Student deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> retrieveAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student retrieveStudentById(long id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id);
	}

	public long retreiveStudentById1(long id) {
		List<Student> studentList = studentRepo.findAll();
		long studentId = 0;
		for(Student student : studentList) {
			if(student.getId() == id) {
				studentId = id;
			}
		}
		return studentId;
	}
	
	@Override
	public Exam giveExam(Exam exam) {
		// TODO Auto-generated method stub
		return studentRepo.getById(exam);
		
	}
	
	@Override
	public Attendance giveAttendence(Attendance attendance)
	{
		return studentRepo.getById(attendance);
		
	}

	@Override
	public Student listStudentById(long studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
