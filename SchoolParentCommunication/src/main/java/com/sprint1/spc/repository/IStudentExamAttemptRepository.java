package com.sprint1.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.spc.entities.ExamAttempt;
import com.sprint1.spc.entities.Student;

public interface IStudentExamAttemptRepository extends JpaRepository<ExamAttempt, Long>{

	List<ExamAttempt> findAll(Student student);

}
