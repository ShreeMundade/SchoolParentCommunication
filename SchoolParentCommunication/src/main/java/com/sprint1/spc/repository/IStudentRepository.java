package com.sprint1.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.spc.entities.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {
//	public Student findById(long id);
//	public Exam findById(Exam exam);
//	public Attendance findById(Attendance attendance);
}