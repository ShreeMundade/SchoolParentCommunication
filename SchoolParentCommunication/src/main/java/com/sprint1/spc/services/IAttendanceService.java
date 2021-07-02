package com.sprint1.spc.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Attendance;

@Service
public interface IAttendanceService {
	
	
	public Attendance addAttendance(Attendance attendance);
	public Attendance updateAttendanceById(Attendance attendance);
    public List<Attendance> listAttendanceByDate(LocalDate dateOfClass);
	public List<Attendance> listAttendance();
	public Attendance giveAttendance(long attendanceId);
	

//	public Attendance updateAttendanceById(Long attendanceId);
}