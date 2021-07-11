package com.sprint1.spc.services;

import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Accountant;
import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.exception.TeacherNotFoundException;
import com.sprint1.spc.exception.UserNotFoundException;
import com.sprint1.spc.repository.IConcernRepository;
import com.sprint1.spc.repository.IStudentClassRepository;
import com.sprint1.spc.repository.ISubjectRepository;
import com.sprint1.spc.repository.ITeacherRepository;

@Service
@Transactional
public class TeacherServiceImpl implements ITeacherService {
	
	/***** Teacher Service Implementation *****/
	
	@Autowired
	private ITeacherRepository iTeacherRepo;
	
	@Autowired
	private IConcernRepository iConcernRepo;
	
	@Autowired
	private ConcernServiceImpl concernServiceImpl;
	
	@Autowired
	private ISubjectRepository subjectRepo;
	
	@Autowired
	private IStudentClassRepository classRepo;

	/***** Add Teacher *****/
	@Override
	public Teacher addTeacher(Teacher teacher) {
		return iTeacherRepo.saveAndFlush(teacher);
	}

	/***** Update Teacher *****/
	@Override
	public Teacher updateTeacher(Teacher teacher) throws UserNotFoundException {
		return iTeacherRepo.save(teacher);
	}

	/***** Retrieve All Teachers *****/
	@Override
	public List<Teacher> retrieveAllTeachers() {
		return iTeacherRepo.findAll();
	}

	/***** Retrieve All Concerns *****/
	@Override
	public List<Concern> retrieveAllConcerns() {
		return iConcernRepo.findAll();
	}

	/***** Patch Concern *****/
//	@Override
//	public Concern patchConcern(long teacherId, long concernId, String resolution) {
//		Concern concern = concernServiceImpl.findById(concernId);
//		return concern;
//	}

	/***** Find Teacher By Id *****/
	@Override
	public Teacher retrieveTeacherById(long id) {
		return iTeacherRepo.getById(id);
	}

	public Concern patchConcern(long teacherId, long concernId, String resolution) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//    public Teacher patchTeacher(Teacher teacher) throws UserNotFoundException {
//        long teacherId = teacher.getId();
//        String id = Long.toString(teacherId);
//        Teacher teacherDb = iTeacherRepo.findById(teacherId).get();
//        if((id.equals(null)) || (teacherDb.equals(null))) {
//            throw new UserNotFoundException("Can't Update Teacher, Please Try Again!");
//        }
//        else {
//        	teacherDb.setPhoneNumber(teacher.getPhoneNumber());
//            BeanUtils.copyProperties(teacher, teacherDb);
//            iTeacherRepo.save(teacherDb);
//            return teacherDb;
//        }
//    }
	
	/***** Patch Subject To Teacher *****/
//	@Override
//	public Teacher patchTeacher(long subjectId, Teacher teacher) {
//		Teacher existingTeacher = iTeacherRepo.findById(teacher.getId()).get();
//		List<Subject> filteredList = new ArrayList<>();
//		List<Subject> subjectList = subjectRepo.findAll();
//		Subject existingSubject = subjectRepo.findById(subjectId).get();
//		subjectList.add(existingSubject);
//		for(Subject subject: subjectList) {
//			if(subject.getSubjectId() == subjectId) {
//				filteredList.add(subject);
//			}
//		}
//		if(!existingTeacher.equals(null)) {
			
//			existingTeacher.setSubjects(filteredList);
//			iTeacherRepo.save(existingTeacher);
//			return existingTeacher;
//		}
//		else {
//			return null;
//		}
		
//		Teacher existingTeacher = iTeacherRepo.findById(teacherId).get();
//		Subject existingSubject = subjectRepo.findById(subjectId).get();
//		List<Subject> subjectList = new ArrayList<>();
//		if(!existingTeacher.equals(null)) {
//			subjectList.add(existingSubject);
//			existingTeacher.setSubjects(subjectList);
//			iTeacherRepo.save(existingTeacher);
//			return existingTeacher;
//		}
//		else {
//			return null;
//		}
//	}

	@Override
	public Teacher getTeacherByEmailId(String email) {
		Teacher teacher = iTeacherRepo.findByEmailId(email);
		return teacher;
	}

	@Override
	public Teacher patchTeacher(long subjectId,long classId, Teacher teacher) throws SQLException {
		Teacher existingTeacher = iTeacherRepo.findById(teacher.getId()).get();
		Subject existingSubject = subjectRepo.findById(subjectId).get();
		StudentClass existingClass = classRepo.findById(classId).get();
		
		List<Subject> subjectList = existingTeacher.getSubjects();
		subjectList.add(existingSubject);
		
		List<StudentClass> classList = existingTeacher.getStudentClasses();
		classList.add(existingClass);
		
		existingTeacher.setSubjects(subjectList);
		existingTeacher.setStudentClasses(classList);
		
		iTeacherRepo.saveAndFlush(existingTeacher);
		return existingTeacher;
	}
	
	
	@Override
	public Teacher patchClass(long classId, Teacher teacher) {
		Teacher existingTeacher = iTeacherRepo.findById(teacher.getId()).get();
		StudentClass existingClass = classRepo.findById(classId).get();
		List<StudentClass> classList = existingTeacher.getStudentClasses();
		classList.add(existingClass);
		existingTeacher.setStudentClasses(classList);
		iTeacherRepo.saveAndFlush(existingTeacher);
		return existingTeacher;
	}
	
	
	
	
	
	
}