package com.sprint1.spc.services;

import java.util.List;

import com.sprint1.spc.entities.Teacher;

public interface ITeacherService {
	public Teacher addTeacher(Teacher teacher);
	public Teacher updateTeacher(Teacher teacher);
	
	public List<Teacher> retrieveAllTeachers();
	public Teacher retrieveTeacherById(long id);
	
	

}
