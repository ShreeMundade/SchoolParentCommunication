//package com.sprint1.spc.controller;
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sprint1.spc.entities.Attendance;
//import com.sprint1.spc.entities.Exam;
//import com.sprint1.spc.services.AttendanceServiceImpl;
//import com.sprint1.spc.services.ExamServiceImpl;
//
//@RestController
//@RequestMapping("/student")
//public class StudentController {
//	
//	
//	@Autowired
//	private ExamServiceImpl examServiceImpl;
//	@Autowired
//	private AttendanceServiceImpl attendanceServiceImpl;
//	
//	
//	@GetMapping("/exam/{examId}")
//	public Exam getExamById(@PathVariable long examId) {
//		Exam exam = examServiceImpl.giveExam(examId);
//		return exam;
//		
//	}
//	@GetMapping("/attendance/{attendanceId}")
//	public Attendance getAttendanceById(@PathVariable long attendanceId) {
//		Attendance attendance = attendanceServiceImpl.giveAttendance(attendanceId);
//		return attendance;
//		
//	}
//}