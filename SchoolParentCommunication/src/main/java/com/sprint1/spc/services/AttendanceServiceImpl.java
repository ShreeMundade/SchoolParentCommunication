package com.sprint1.spc.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Attendance;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.repository.IAttendanceRepository;
import com.sprint1.spc.repository.IStudentRepository;

@Service
@Transactional
public class AttendanceServiceImpl implements IAttendanceService {

	@Autowired
	private IAttendanceRepository attendanceRepo;

	@Autowired
	private IStudentRepository studentRepo;

	@Override
	public Attendance addAttendance(long studentId, Attendance attendance) {
		Student student = studentRepo.findById(studentId).get();
		List<Attendance> attendanceList = new ArrayList<Attendance>();
		attendanceList.add(attendance);
		student.setAttendance(attendanceList);
		return attendanceRepo.save(attendance);
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

	public List<Attendance> listAttendance() {
		List<Attendance> attendence = attendanceRepo.findAll();
		return attendence;

	}

	public Attendance getAttendanceById(long attendanceId) {
		// TODO Auto-generated method stub
		return attendanceRepo.findById(attendanceId).get();
	}

	@Override
    public List<Attendance> listAllAttendanceByStudentId(long studentId) {
		Student student = studentRepo.findById(studentId).get();
        List<Attendance> filteredList = new ArrayList<Attendance>();
        filteredList.addAll(student.getAttendance());
        return filteredList;
    }
}