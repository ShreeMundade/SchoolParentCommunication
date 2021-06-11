package com.sprint1.spc.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.spc.entities.Exam;

public interface IExamRepository extends JpaRepository<Exam, Long> {
	List<Exam> findByDateOfExam(LocalDate dateOfExam);
}