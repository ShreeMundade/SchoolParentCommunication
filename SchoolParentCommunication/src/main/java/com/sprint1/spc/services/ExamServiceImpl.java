package com.sprint1.spc.services;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Exam;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.repository.IExamRepository;
import com.sprint1.spc.repository.ISubjectRepository;

@Service
public class ExamServiceImpl implements IExamService{
	@Autowired
	private IExamRepository examRepo;
	@Autowired
	private ISubjectRepository subjectRepo;
	
	
	@Override
	public List<Exam> listAllExams() {
		List<Exam> examList= examRepo.findAll();
		return examList;
	}

	@Override
	public Exam listExamById(long id) {
		Exam exam=examRepo.findById(id).get();
		return exam;
	}
	@Override
	public List<Exam> listAllExamsByDate(LocalDate dateOfExam) {
		return examRepo.findByDateOfExam(dateOfExam);
	}
	
	
	public List<Exam> listAllExamsByDate(long month) {
		List<Exam> ExamList = examRepo.findAll();
		List<Exam> ExamsByMonth = new ArrayList<Exam>();
		for(Exam exam: ExamList)
		{
			Month getStartMonth = exam.getDateOfExam().getMonth();
			
			if(month == getStartMonth.getValue())
			{
				ExamsByMonth.add(exam);
			}
		}
		return ExamsByMonth;
	}
	

	@Override
	public Exam addExam(Exam exam) {
		return examRepo.save(exam);
	}

	@Override
	public Exam deleteExam(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exam updateExam(long id,Exam exam) {
		// TODO Auto-generated method stub
		
		Exam exam1=examRepo.findById(id).get();
		BeanUtils.copyProperties(exam,exam1,"examId");
		return exam1;
	}

	public Exam giveExam(long examId) {
		// TODO Auto-generated method stub
		return examRepo.getById(examId);
	}


	@Override
    public Exam patchExam(long subjectId,long examId) {
        Exam exam=examRepo.findById(examId).get();
        Subject subject=subjectRepo.findById(subjectId).get();
        exam.setSubject(subject);
        examRepo.save(exam);
        return exam;
    }
	@Override
    public Exam updateExamById(Exam exam) {
        // TODO Auto-generated method stub
        return examRepo.save(exam);

 

    }
	
	
	
}
