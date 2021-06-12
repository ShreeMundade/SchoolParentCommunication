package com.sprint1.spc.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.spc.entities.Accountant;
import com.sprint1.spc.entities.Attendance;
import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Exam;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.exception.StudentIDNotFoundException;
import com.sprint1.spc.services.AttendanceServiceImpl;
import com.sprint1.spc.services.ExamServiceImpl;
import com.sprint1.spc.services.StudentServiceImpl;
import com.sprint1.spc.services.TeacherServiceImpl;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private ExamServiceImpl examServiceImpl;
	
	@Autowired
	private AttendanceServiceImpl attendanceServiceImpl;
	
	@Autowired
	private TeacherServiceImpl teacherServiceImpl;
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
//	@Autowired
//	private ConcernServiceImpl concernServiceImpl;

	@GetMapping("/exams")
	public List<Exam> getAllExams() {
		return examServiceImpl.listAllExams();

	}

	@GetMapping("/exam/{examId}")
	public Exam getExamById(@PathVariable long examId) {
		return examServiceImpl.listExamById(examId);
	}

	@GetMapping("/exam/date/{dateOfExam}")
	public List<Exam> getAllExamByDate(@PathVariable CharSequence dateOfExam) {
		return examServiceImpl.listAllExamsByDate(LocalDate.parse(dateOfExam));
	}

	@GetMapping("/exam/month/{month}")
	public List<Exam> getAllExamByMonth(@PathVariable long month) {
		return examServiceImpl.listAllExamsByDate(month);
	}

	@PostMapping("/exam")
	public ResponseEntity<Exam> insertExam(@RequestBody Exam exam) {
		return new ResponseEntity<Exam>(examServiceImpl.addExam(exam), HttpStatus.CREATED);
	}
	@GetMapping("/attendance")
	public List<Attendance> getAllAttendance() {
		return attendanceServiceImpl.listAttendance();

	}
	@GetMapping("/attendance/date/{dateOfAttendance}")
	public List<Attendance> getAllAttendanceByDate(@PathVariable CharSequence dateOfAttendance) {
		return attendanceServiceImpl.listAttendanceByDate(LocalDate.parse(dateOfAttendance));

	}
	@PostMapping("{teacherId}/{studentId}/attendance")
	public ResponseEntity<Attendance> addAttendance(@PathVariable long teacherId, @PathVariable long studentId , @RequestBody Attendance attendance) throws StudentIDNotFoundException {
		
		if(teacherServiceImpl.retrieveTeacherById(teacherId) == null && studentServiceImpl.listStudentById(studentId) == null) {
            throw new StudentIDNotFoundException("Please Add Valid Accountant Id");
        }
        else if(attendance.equals(null)) {
            throw new StudentIDNotFoundException("Please Add Valid Fee");
        }
        else {
            Attendance attendance2 = attendanceServiceImpl.addAttendance(attendance);
            return new ResponseEntity<Attendance>(attendance2,HttpStatus.OK);
        }
    }
	
	@PutMapping("/attendance")
	public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance) {
		return new ResponseEntity<Attendance>(attendanceServiceImpl.updateAttendanceById(attendance), HttpStatus.CREATED);
	}

	@GetMapping("/concerns")
	public List<Concern> getTeacherConcerns() {
		return teacherServiceImpl.retrieveAllConcerns();
	}
	
	@PatchMapping("{teacherId}/concern/{concernId}/{resolution}")
	public ResponseEntity<Concern> patchConcern(@PathVariable long teacherId,
			@PathVariable long concernId,@PathVariable String resolution) {
		return new ResponseEntity<Concern>(teacherServiceImpl.patchConcern(teacherId,concernId,resolution), HttpStatus.OK);
	}

	
	
}
