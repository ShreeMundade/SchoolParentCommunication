package com.sprint1.spc.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.spc.entities.Attendance;
import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Exam;
import com.sprint1.spc.entities.ExamAttempt;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.exception.ConcernNotFoundException;
import com.sprint1.spc.exception.StudentIDNotFoundException;
import com.sprint1.spc.services.AttendanceServiceImpl;
import com.sprint1.spc.services.ConcernServiceImpl;
import com.sprint1.spc.services.ExamServiceImpl;
import com.sprint1.spc.services.IStudentClassService;
import com.sprint1.spc.services.ParentServiceImpl;
import com.sprint1.spc.services.StudentServiceImpl;
import com.sprint1.spc.services.SubjectServiceImpl;
import com.sprint1.spc.services.TeacherServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

	@Autowired
	private ExamServiceImpl examServiceImpl;
	
	@Autowired
	private AttendanceServiceImpl attendanceServiceImpl;
	
	@Autowired
	private TeacherServiceImpl teacherServiceImpl;
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@Autowired
	private ConcernServiceImpl concernServiceImpl;
	
	@Autowired
	private ParentServiceImpl parentServiceImpl;
	
	@Autowired
	private SubjectServiceImpl subjectServiceImpl;
	
	@Autowired
	private IStudentClassService classService;

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e) {
//        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(),fieldError.getDefaultMessage())).collect(Collectors.toList());
//        return fieldErrorMessages;
//    }

	@GetMapping("/exams")
	@ApiOperation(value = "Get All Exams Details", notes = "Schedule for the Exam List.")
	public List<Exam> getAllExams() {
		return examServiceImpl.listAllExams();
	}

	@GetMapping("/exam/{examId}")
	@ApiOperation(value = "Get All Exam Detail By Exam Id", notes = "Details of the exam ")
	public Exam getExamById(@Valid @PathVariable long examId) {
		return examServiceImpl.listExamById(examId);
	}

	@GetMapping("/exam/date/{dateOfExam}")
	@ApiOperation(value = "Get All Exam Detail By Date Of Exam", notes = "Details of the exam by date of exam.")
	public List<Exam> getAllExamByDate(@Valid @PathVariable CharSequence dateOfExam) {
		return examServiceImpl.listAllExamsByDate(LocalDate.parse(dateOfExam));
	}

	@GetMapping("/exam/month/{month}")
	@ApiOperation(value = "Get All Exam Detail By month", notes = "Details of the exam by month.")
	public List<Exam> getAllExamByMonth(@Valid @PathVariable long month) {
		return examServiceImpl.listAllExamsByDate(month);
	}

	@PostMapping("/exam")
	@ApiOperation(value = "Add Exam Details", notes = "Adding the exam.")
	public ResponseEntity<Exam> insertExam(@Valid  @RequestBody Exam exam) {
		return new ResponseEntity<Exam>(examServiceImpl.addExam(exam), HttpStatus.CREATED);
	}
	@PutMapping("/exam/examattempt/{examId}")
	@ApiOperation(value = "Add ExamAttempt Details", notes = "Adding the examAttempt.")
	public ResponseEntity<Exam> insertExamAttempt(@Valid @PathVariable long examId,@RequestBody ExamAttempt examAttempt) {
		return new ResponseEntity<Exam>(examServiceImpl.addExamAttempt(examId,examAttempt), HttpStatus.CREATED);
	}
	
	@GetMapping("/attendance")
	@ApiOperation(value = "Get The Attendence Details", notes = "Get the attendence details.")
	public List<Attendance> getAllAttendance() {
		return attendanceServiceImpl.listAttendance();
	}
	
	@GetMapping("/attendance/date/{dateOfAttendance}")
	@ApiOperation(value = "Get The Attendance Details By Date", notes = "Get the attendence details by date.")
	public List<Attendance> getAllAttendanceByDate(@Valid @PathVariable CharSequence dateOfAttendance) {
		return attendanceServiceImpl.listAttendanceByDate(LocalDate.parse(dateOfAttendance));

	}
	
	@GetMapping("/attendance/id/{attendanceId}")
	public Attendance getAttendanceById(@Valid @PathVariable long attendanceId) {
		return attendanceServiceImpl.getAttendanceById(attendanceId);
	}
	
	@GetMapping("/subjects/{teacherId}")
	//@ApiOperation(value = "Get The Subjects by teacher id  ", notes = "Get the attendence details by studentID")
	public List<Subject> getAllSubjectsByTeacherId(@Valid @PathVariable long teacherId) {
		return subjectServiceImpl.listAllSubjectsByTeacherId(teacherId);
	}
	
	@GetMapping("/classes/{teacherId}")
	//@ApiOperation(value = "Get The Classes by teacher id  ", notes = "Get the attendence details by studentID")
	public List<StudentClass> getAllClassesByTeacherId(@Valid @PathVariable long teacherId) {
		return classService.listAllClassesByTeacherId(teacherId);
	}
	
	@GetMapping("/attendance/student/{studentId}")
	//@ApiOperation(value = "Get The Attendance  ", notes = "Get the attendence details by studentID")
	public List<Attendance> getAllAttendanceByStudentId(@Valid @PathVariable Long studentId) {
		return attendanceServiceImpl.listAllAttendanceByStudentId(studentId);
	}
	//Tobe completed get student id get a join 

//	@PostMapping("/attendance/student/{studentId}")
//	@ApiOperation(value = "Add The Attendence By Student Id", notes = "Add the attendence details for student.")
//	public ResponseEntity<Attendance> addAttendance(@Valid  @PathVariable long studentId , @RequestBody Attendance attendance) throws StudentIDNotFoundException {
//		if(studentServiceImpl.retreiveStudentById1(studentId) == 0) {
//            throw new StudentIDNotFoundException("Please Add Valid Student Id.");
//        }
//        else if(attendance.equals(null)) {
//            throw new StudentIDNotFoundException("Please Add Valid Attendance.");
//        }
//        else {
//            Attendance attendance2 = attendanceServiceImpl.addAttendance(attendance);
//            return new ResponseEntity<Attendance>(attendance2,HttpStatus.OK);
//        }
//    }
//	
	@PatchMapping("/attendance/{studentId}")
	@ApiOperation(value = "Add The Attendence By Student Id", notes = "Add the attendence details for student.")
	public ResponseEntity<Attendance> addAttendance(@PathVariable long studentId, @RequestBody Attendance attendance) throws StudentIDNotFoundException {
	// if(teacherServiceImpl.retrieveTeacherById(teacherId) == null && studentServiceImpl.retreiveStudentById1(studentId) == 0) {
	// throw new StudentIDNotFoundException("Please Add Valid Student Id.");
	// }
	// else if(attendance.equals(null)) {
	// throw new StudentIDNotFoundException("Please Add Valid Attendance.");
	// }
	// else {
	Attendance attendance2 = attendanceServiceImpl.addAttendance(studentId, attendance);
	return new ResponseEntity<Attendance>(attendance2,HttpStatus.OK);
	// }
	}





	@PutMapping("/attendance")
	@ApiOperation(value = "Update The Attendence By StudentId", notes = "Update the attendence details for student.")
	public ResponseEntity<Attendance> updateAttendance(@Valid @RequestBody Attendance attendance) {
		return new ResponseEntity<Attendance>(attendanceServiceImpl.updateAttendanceById(attendance), HttpStatus.CREATED);
	}
	
	@PutMapping("/exam")
    @ApiOperation(value = "Update The Exam By ExamId", notes = "Update the exam details for student.")
    public ResponseEntity<Exam> updateExam(@Valid @RequestBody Exam exam) {
        return new ResponseEntity<Exam>(examServiceImpl.updateExamById(exam), HttpStatus.CREATED);
    }

	@GetMapping("/concerns")
	@ApiOperation(value = "Get All The Concerns", notes = "Get all the concern details.")
	public List<Concern> getTeacherConcerns() {
		return teacherServiceImpl.retrieveAllConcerns();
	}

//	@PatchMapping("/exam/subject/{subjectId}")
//	@ApiOperation(value = "Add Subject To Exam", notes = "Add subject to exam.")
//    public ResponseEntity<Exam> patchExam(@PathVariable long subjectId, @RequestBody Exam exam) {
//        return new ResponseEntity<Exam>(examServiceImpl.patchExam(subjectId,exam),HttpStatus.OK);
//    }
	@PatchMapping("/exam/{teacherId}/{subjectId}")
	@ApiOperation(value = "Add teacher To Exam", notes = "Add teacher to exam.")
    public ResponseEntity<Exam> patchExamByTeacherId(@PathVariable long teacherId,@PathVariable long subjectId, @RequestBody Exam exam) {
        return new ResponseEntity<Exam>(examServiceImpl.patchExamByTeacherId(teacherId,subjectId,exam),HttpStatus.OK);
  }

//	@GetMapping("/concern/{concernId}")
//	@ApiOperation(value = "Get All The Concerns", notes = "Get all the concern details.")
//	public List<Concern> getTeacherConcerns1() {
//		return teacherServiceImpl.retrieveAllConcerns();
//	}

//	@PatchMapping("{teacherId}/concern/{concernId}/{resolution}")
//	public ResponseEntity<Concern> patchConcern(@PathVariable long teacherId,
//			@PathVariable long concernId,@PathVariable String resolution) {
//		return new ResponseEntity<Concern>(teacherServiceImpl.patchConcern(teacherId,concernId,resolution), HttpStatus.OK);
//	}

	@PatchMapping("/{teacherId}/concern")
	@ApiOperation(value = "Resolve Concern", notes = "Solve concern details.")
	public ResponseEntity<Concern> resolveConcern(@PathVariable long teacherId,@RequestBody Concern concern) throws ConcernNotFoundException {
//		if(parentServiceImpl.retrieveParentById1(parentId) == 0) {
//			throw new ConcernNotFoundException("Concern Not Found For Parent Id.");
//		}
//		else if(concern.equals(null)) {
//			throw new ConcernNotFoundException("Please Add Valid Concern Details.");
//		}
//		else {
			return new ResponseEntity<Concern>(concernServiceImpl.updateConcern(teacherId,concern),HttpStatus.OK);
//		}
	}
	
	@GetMapping("/get")
	public ResponseEntity<Teacher> getTeacherByEmailId(@RequestParam String emailId) {
		Teacher teacher = teacherServiceImpl.getTeacherByEmailId(emailId);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
	}
	
	@GetMapping("/subject")
	public ResponseEntity<Subject> getSubjectById(@RequestParam long subjectId) {
		Subject subject= subjectServiceImpl.getSubjectById(subjectId);
		return new ResponseEntity<Subject>(subject, HttpStatus.OK);
	
}
}