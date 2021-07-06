package com.sprint1.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint1.spc.entities.Attendance;
import com.sprint1.spc.entities.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {
//	public Student findById(long id);
//	public Exam findById(Exam exam);
//	public Attendance findById(Attendance attendance);
	@Query("select s from Student s where s.emailId = ?1")
    public Student findByEmailId(String email);

	@Query(value = "select s.attendance from Student s where  s.id = ?1")
	public List<Attendance> findByStudentId(long studentId);
	
	
}