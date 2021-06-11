package com.sprint1.spc.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Attendance;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.repository.IAttendanceRepository;
import com.sprint1.spc.repository.IStudentRepository;

@Service
public class AttendanceServiceImpl implements IAttendanceService{

	@Autowired
	private  IAttendanceRepository attendanceRepo;
	
	
	
	@Override
	public Attendance addAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceRepo.saveAndFlush(attendance);
	}

	
	@Override
	public Attendance updateAttendanceById(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceRepo.save(attendance);

	}

	@Override
	public List<Attendance> listAttendanceByDate(LocalDate dateOfClass) {
		// TODO Auto-generated method stub
		return attendanceRepo.findByDateOfClass(dateOfClass);
	}
	
	
	@Override
	public List<Attendance> listAttendance() {
		// TODO Auto-generated method stub
		return attendanceRepo.findAll();
	}


	public Attendance giveAttendance(long attendanceId) {
		// TODO Auto-generated method stub
		return attendanceRepo.findById(attendanceId).get();
	}


	



}
