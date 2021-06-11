package com.sprint1.spc.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Exam;


@Service
public interface IExamService {
	
	public List<Exam> listAllExams();
	public Exam listExamById(long id);
	public List<Exam> listAllExamsByDate(LocalDate dateOfExam);
	
	
	public Exam addExam(Exam exam);
	public Exam deleteExam(int id);
	public Exam updateExam(long id,Exam exam);
	

}
