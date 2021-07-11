package com.sprint1.spc.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Attendance;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.exception.UserNotFoundException;
import com.sprint1.spc.repository.IParentRepository;
import com.sprint1.spc.repository.IStudentClassRepository;
import com.sprint1.spc.repository.IStudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository studentRepo;

	@Autowired
	private IStudentClassRepository classRepo;

	@Autowired
	private IParentRepository iParentRepository;

	@Override
	public Student addStudent(Student student) {
		return studentRepo.saveAndFlush(student);
	}

	@Override
	public Student updateStudent(Student student) throws UserNotFoundException {
		long studentId = student.getId();
		String id = Long.toString(studentId);
		Student studentDb = studentRepo.findById(studentId).get();
		if ((id.equals(null)) || (studentDb.equals(null))) {
			throw new UserNotFoundException("Can't Update Student, Please Try Again!");
		} else {
			BeanUtils.copyProperties(student, studentDb, "studentId");
			studentRepo.save(studentDb);
			return studentDb;
		}
	}

	@Override
	public Student deleteStudent(Student student) {
		return null;
	}

	@Override
	public List<Student> retrieveAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student retrieveStudentById(long id) throws UserNotFoundException {
		Optional<Student> student = studentRepo.findById(id);
		if (!student.isPresent()) {
			throw new UserNotFoundException("Student id not found");
		}
		return student.get();

	}

	public long retreiveStudentById1(long id) {
		List<Student> studentList = studentRepo.findAll();
		long studentId = 0;
		for (Student student : studentList) {
			if (student.getId() == id) {
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
		return null;
	}

	/***** Patch StudentClass To Student *****/
	@Override
	public Student updateStudentClassToStudent(long classId, Student student) {
		Student existingStudent = studentRepo.findById(student.getId()).get();
		StudentClass existingClass = classRepo.findById(classId).get();
		if (!existingStudent.equals(null)) {
			existingStudent.setStudentClass(existingClass);
			studentRepo.save(existingStudent);
			return existingStudent;
		} else {
			return null;
		}
	}

	@Override
	public Student updateStudentById(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentByParentId(long parentId) {
		Parent parent = iParentRepository.findById(parentId).get();
		Set<Student> studentSet = parent.getStudents();
		Student filteredStudent = new Student();
		for (Student student : studentSet) {
			filteredStudent = student;
		}
		return filteredStudent;
	}
	
	
	@Override
	public Student updateStudentClassToStudent1(@Valid long studentId, StudentClass studentclass) {
		Student existingStudent = studentRepo.findById(studentId).get();
		existingStudent.setStudentClass(studentclass);
		studentRepo.save(existingStudent);
		return existingStudent;
		
	}
}