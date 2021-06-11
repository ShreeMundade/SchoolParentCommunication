package com.sprint1.spc.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.spc.entities.Attendance;

public interface IAttendanceRepository extends JpaRepository<Attendance, Long> {

	public List<Attendance> findByDateOfClass(LocalDate dateOfClass);

	


}