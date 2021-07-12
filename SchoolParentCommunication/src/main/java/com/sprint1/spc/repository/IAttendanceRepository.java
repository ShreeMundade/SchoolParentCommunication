package com.sprint1.spc.repository;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint1.spc.entities.Attendance;
import com.sprint1.spc.entities.Student;

public interface IAttendanceRepository extends JpaRepository<Attendance, Long> {

	public List<Attendance> findByDateOfClass(LocalDate dateOfClass);


	
	

	


}