package com.sprint1.spc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Attendance;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.exception.UserNotFoundException;
import com.sprint1.spc.repository.IStudentClassRepository;
import com.sprint1.spc.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentRepository studentRepo;
	
	@Autowired
	private IStudentClassRepository classRepo;
		
	
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
	public Student retrieveStudentById(long id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<Student> student = studentRepo.findById(id);
		if(!student.isPresent()) {
			throw new UserNotFoundException("Student id not found");
		}
		return student.get();
		
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
	public List<Attendance> listAllAttendanceByStudentId(long studentId) {
		
		return studentRepo.findByStudentId(studentId);
	}

//	@Override
//	public Exam giveExam(Exam exam) {
//		
//		return studentRepo.findById(exam);
//		
//	}
	
//	@Override
//	public Attendance giveAttendence(Attendance attendance)
//	{
//		return studentRepo.findById(attendance);
//		
//	}

	@Override
	public Student listStudentById(long studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	/***** Patch StudentClass To Student *****/
	@Override
	public Student updateStudentClassToStudent(long studentId, long classId) {
		Student existingStudent = studentRepo.findById(studentId).get();
		StudentClass existingClass = classRepo.findById(classId).get();
		if(!existingStudent.equals(null)) {
			existingStudent.setStudentClass(existingClass);
			studentRepo.save(existingStudent);
			return existingStudent;
		}
		else {
			return null;
		}
	}

	@Override
	public Student updateStudentById(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student) ;
	}
	
	}


	
	


