package com.sprint1.spc.services;

import java.util.List;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.exception.TeacherNotFoundException;

public interface ITeacherService {
	public Teacher addTeacher(Teacher teacher);
	public Teacher updateTeacher(Teacher teacher) throws TeacherNotFoundException;
//	public Teacher findById(long id);
	public List<Teacher> retrieveAllTeachers();
	public Teacher retrieveTeacherById(long id);
	List<Concern> retrieveAllConcerns();
	Concern patchConcern(long teacherId, long concernId, String resolution);
}