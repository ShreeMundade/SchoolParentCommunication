package com.sprint1.spc.services;


import java.util.ArrayList;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Exam;
import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.repository.IStudentClassRepository;
import com.sprint1.spc.repository.ITeacherRepository;

@Service
@Transactional
public class StudentClassServiceImpl implements IStudentClassService {
	
	@Autowired
	private IStudentClassRepository iStudentClassRepository;
	@Autowired
	private ITeacherRepository iTeacherRepository;

	@Override
	public StudentClass addStudentClass(StudentClass studentClass) {
		return iStudentClassRepository.save(studentClass);
	}
	
	
	@Override
	public StudentClass deleteStudentClassById(long studentClassId) {
		StudentClass s=iStudentClassRepository.findById(studentClassId).get();
		iStudentClassRepository.deleteById(studentClassId);
		return s;
		
	}


	@Override
	public List<StudentClass> retrieveAllStudentClass() {
		// TODO Auto-generated method stub
		return iStudentClassRepository.findAll();
	}


	@Override
	public StudentClass updateStudentClassById(@Valid StudentClass studentclass) {
		// TODO Auto-generated method stub
		return  iStudentClassRepository.save(studentclass) ;
	}
	/***** Patch Fee To Student *****/
//	@Override
//	public Student updateFeeToStudent(long id, Fee fee) {
//		Student existingStudent = iStudentRepository.findById(id).get();
//		existingStudent.setFee(fee);
//		iStudentRepository.save(existingStudent);
//		return existingStudent;
//	}

	@Override
	public StudentClass updateTeacherToClass(@Valid long teacherId, StudentClass studentClass) {
		Teacher existingTeacher=iTeacherRepository.findById(teacherId).get();
		
		studentClass.setClassTeacher(existingTeacher);
//		return studentClass;
		return iStudentClassRepository.save(studentClass);

	}


	@Override
	public StudentClass listClassById(@Valid long classId) {
		StudentClass studentclass =iStudentClassRepository.findById(classId).get();
		return studentclass;
	}
	
	public List<StudentClass> listAllClassesByTeacherId(long teacherId){
		Teacher teacher = iTeacherRepository.findById(teacherId).get();
        List<StudentClass> classList = new ArrayList<StudentClass>();
        classList.addAll(teacher.getStudentClasses());
        return classList;
	}
	
}