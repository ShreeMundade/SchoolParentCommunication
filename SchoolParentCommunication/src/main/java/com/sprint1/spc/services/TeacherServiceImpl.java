package com.sprint1.spc.services;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Accountant;
import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.exception.TeacherNotFoundException;
import com.sprint1.spc.exception.UserNotFoundException;
import com.sprint1.spc.repository.IConcernRepository;
import com.sprint1.spc.repository.ITeacherRepository;

@Service
public class TeacherServiceImpl implements ITeacherService {
	
	/***** Teacher Service Implementation *****/
	
	@Autowired
	private ITeacherRepository iTeacherRepo;
	
	@Autowired
	private IConcernRepository iConcernRepo;
	
	@Autowired
	private ConcernServiceImpl concernServiceImpl;

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

	@Override
    public Teacher patchTeacher(Teacher teacher) throws UserNotFoundException {
        long teacherId = teacher.getId();
        String id = Long.toString(teacherId);
        Teacher teacherDb = iTeacherRepo.findById(teacherId).get();
        if((id.equals(null)) || (teacherDb.equals(null))) {
            throw new UserNotFoundException("Can't Update Teacher, Please Try Again!");
        }
        else {
        	teacherDb.setPhoneNumber(teacher.getPhoneNumber());
            BeanUtils.copyProperties(teacher, teacherDb);
            iTeacherRepo.save(teacherDb);
            return teacherDb;
        }
    }

	@Override
	public Teacher getTeacherByEmailId(String email) {
		Teacher teacher = iTeacherRepo.findByEmailId(email);
		return teacher;
	}
}