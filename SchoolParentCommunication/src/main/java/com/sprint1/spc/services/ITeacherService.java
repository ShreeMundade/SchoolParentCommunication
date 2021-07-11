package com.sprint1.spc.services;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.exception.TeacherNotFoundException;
import com.sprint1.spc.exception.UserNotFoundException;
@Service
@Transactional
public interface ITeacherService {
	public Teacher addTeacher(Teacher teacher);
	public Teacher updateTeacher(Teacher teacher) throws UserNotFoundException;
//	public Teacher findById(long id);
	public List<Teacher> retrieveAllTeachers();
	public Teacher retrieveTeacherById(long id);
	List<Concern> retrieveAllConcerns();
//	Concern patchConcern(long teacherId, long concernId, String resolution);
	
	public Teacher patchTeacher(long subjectId,long classId, Teacher teacher) throws SQLException;
	
	public Teacher getTeacherByEmailId(String email);
	
	Teacher patchClass(long classId, Teacher teacher);
}