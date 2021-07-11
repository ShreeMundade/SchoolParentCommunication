package com.sprint1.spc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Attendance;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.repository.ISubjectRepository;
import com.sprint1.spc.repository.ITeacherRepository;

@Service
@Transactional
public class SubjectServiceImpl implements ISubjectService {

	@Autowired
	private ISubjectRepository iSubjectRepository;
	
	@Autowired
	private ITeacherRepository teacherRepo;

	@Override
	public Subject addSubject(Subject subject) {
		return iSubjectRepository.save(subject);
	}

	public List<Subject> retrieveAllSubjects() {
		return iSubjectRepository.findAll();
	}
	
	public Subject getSubjectById(long subjectId) {
		return iSubjectRepository.findById(subjectId).get();
	}
	
	public List<Subject> listAllSubjectsByTeacherId(long teacherId){
		Teacher teacher = teacherRepo.findById(teacherId).get();
        List<Subject> subjectList = new ArrayList<Subject>();
        subjectList.addAll(teacher.getSubjects());
        return subjectList;
	}
	
	
}