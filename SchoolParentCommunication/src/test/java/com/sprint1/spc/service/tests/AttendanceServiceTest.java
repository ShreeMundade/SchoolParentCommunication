package com.sprint1.spc.service.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.verify;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint1.spc.entities.Attendance;

import com.sprint1.spc.repository.IAttendanceRepository;

import com.sprint1.spc.services.AttendanceServiceImpl;

public class AttendanceServiceTest {

	@InjectMocks
	@Autowired
	private AttendanceServiceImpl attendanceServiceImpl;
	
	@Mock
	private IAttendanceRepository iAttendanceRepository;
	

	
	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.openMocks(this);
	}
	

	
	@Test
	public void addAttendanceTest() {
		Attendance attendance1=new Attendance(1L,LocalDate.now(),true);
		when(iAttendanceRepository.save(attendance1)).thenReturn(attendance1);
//		Assertions.assertEquals(attendance1, attendanceServiceImpl.addAttendance(1, attendance1));
	}
	
	@Test
	public void updateAttendanceById() {
		Attendance attendance1=new Attendance(1L,LocalDate.now(),false);
		Attendance attendance2=new Attendance(1L,LocalDate.now(),true);
		when(iAttendanceRepository.save(attendance1)).thenReturn(attendance2);
		Attendance updated=attendanceServiceImpl.updateAttendanceById(attendance1);
		
		assertEquals(attendance2.getAttendanceId(),updated.getAttendanceId());
		
	}
	
	@Test
	public void ListAttendance() {
		List<Attendance> attendanceList = new ArrayList<Attendance>();
		Attendance attendance1=new Attendance(1L,LocalDate.now(),true);
		Attendance attendance2=new Attendance(2L,LocalDate.now(),false);
		Attendance attendance3=new Attendance(3L,LocalDate.now(),true);
		attendanceList.add(attendance1);
		attendanceList.add(attendance2);
		attendanceList.add(attendance3);
		when(iAttendanceRepository.findAll()).thenReturn(attendanceList);
		List<Attendance> a1=attendanceServiceImpl.listAttendance();
		assertEquals(3,a1.size());
		verify(iAttendanceRepository,times(1)).findAll();
		
		
	}
	
	@Test
	public void ListAttendanceByDate() {
		Attendance attendance1=new Attendance(1L,LocalDate.now(),true);
		Attendance attendance2=new Attendance(2L,LocalDate.now(),true);
		List<Attendance> attendanceList = new ArrayList<Attendance>();
		attendanceList.add(attendance1);
		attendanceList.add(attendance2);
	  when(iAttendanceRepository.findByDateOfClass(LocalDate.now())).thenReturn(attendanceList);
	  List<Attendance> a1=attendanceServiceImpl.listAttendanceByDate(LocalDate.now());
	  assertEquals(2,a1.size());
	  verify(iAttendanceRepository,times(1)).findByDateOfClass(LocalDate.now());
	}
	
	
	
	
	
	

	
	
	

	
	
}
	
	
