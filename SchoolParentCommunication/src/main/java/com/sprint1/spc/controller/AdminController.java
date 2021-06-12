package com.sprint1.spc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.spc.entities.Accountant;
import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.FeeServiceException;
import com.sprint1.spc.exception.StudentIDNotFoundException;
import com.sprint1.spc.exception.TeacherNotFoundException;
import com.sprint1.spc.services.IAccountantService;
import com.sprint1.spc.services.IParentService;
import com.sprint1.spc.services.IStudentService;
import com.sprint1.spc.services.ITeacherService;
import com.sprint1.spc.services.IUserService;
import com.sprint1.spc.services.StudentClassServiceImpl;
import com.sprint1.spc.services.StudentServiceImpl;
import com.sprint1.spc.services.SubjectServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IStudentService studentService;

	@Autowired
	private ITeacherService teacherService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IParentService parentService;

	@Autowired
	private IAccountantService accountantService;

	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@Autowired
	private SubjectServiceImpl subjectServiceImpl;
	
	@Autowired
	private StudentClassServiceImpl studentClassServiceImpl;

	@GetMapping("/accountants")
	public ResponseEntity<List<Accountant>> getAllAccountants() {
		List<Accountant> listOfAccountants = accountantService.retrieveAllAccountants();
		return new ResponseEntity<List<Accountant>>(listOfAccountants, HttpStatus.OK);
	}

	@GetMapping("/students")
	public ResponseEntity<List<User>> getAllStudents() {
		List<User> listOfStudents = userService.listUserByRole(Role.STUDENT);
		return new ResponseEntity<List<User>>(listOfStudents, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAdmin() {
		List<User> listOfAdmins = userService.listUserByRole(Role.ADMIN);
		return new ResponseEntity<List<User>>(listOfAdmins, HttpStatus.OK);
	}

	@GetMapping("/teachers")
	public ResponseEntity<List<User>> adminGetTeachers() {
		List<User> listOfTeachers = userService.listUserByRole(Role.TEACHER);
		return new ResponseEntity<List<User>>(listOfTeachers, HttpStatus.OK);
	}

	@GetMapping("/parents")
	public ResponseEntity<List<User>> adminGetParents() {
		List<User> listOfParents = userService.listUserByRole(Role.PARENT);
		return new ResponseEntity<List<User>>(listOfParents, HttpStatus.OK);
	}

	@GetMapping("/student/{studentId}")
	public Student getStudentById(@PathVariable long studentId) throws StudentIDNotFoundException {
		if (studentId != 0)
			return studentServiceImpl.retrieveStudentById(studentId);
		else
			throw new StudentIDNotFoundException("StudentId Not Found");
	}

	@GetMapping("/subjects")
	public ResponseEntity<List<Subject>> getAllSubjects() {
		List<Subject> listOfSubjects = subjectServiceImpl.retrieveAllSubjects();
		return new ResponseEntity<List<Subject>>(listOfSubjects, HttpStatus.OK);
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.CREATED);
	}

	@PostMapping("/teacher")
	public ResponseEntity<Teacher> addTeacher(@Valid @RequestBody Teacher teacher) {
		return new ResponseEntity<Teacher>(teacherService.addTeacher(teacher), HttpStatus.CREATED);
	}

	@PutMapping("/updateteacher")
	public ResponseEntity<Teacher> updateTeacher(@Valid @RequestBody Teacher teacher) throws TeacherNotFoundException {
		return new ResponseEntity<Teacher>(teacherService.updateTeacher(teacher), HttpStatus.CREATED);
	}

	@PostMapping("/parent/{studentId}")
	public ResponseEntity<Parent> insertParent(@Valid @PathVariable long studentId, @RequestBody Parent parent) throws StudentIDNotFoundException {
		if(studentServiceImpl.retreiveStudentById1(studentId) == 0) {
			throw new StudentIDNotFoundException("Student Not Found");
		}
		else {
			return new ResponseEntity<Parent>(parentService.addParent(parent), HttpStatus.CREATED);
		}
	}

	@PatchMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student) {
		Student s1 = studentService.retrieveStudentById(id);
		s1.setStudentClass(student.getStudentClass());
		Student updatedClass = studentService.updateStudent(s1);
		return new ResponseEntity<Student>(updatedClass, HttpStatus.OK);
	}
	
	@PostMapping("/subject")
	public ResponseEntity<Subject> addSubject(@Valid @RequestBody Subject subject) {
		return new ResponseEntity<Subject>(subjectServiceImpl.addSubject(subject), HttpStatus.CREATED);
	}

	@PostMapping("/accountant")
	public ResponseEntity<Accountant> addAccountant(@Valid @RequestBody Accountant accountant) {
		return new ResponseEntity<Accountant>(accountantService.addAccountant(accountant), HttpStatus.CREATED);
	}

	@PutMapping("/accountant")
	public ResponseEntity<Accountant> updateAccountant(@Valid @RequestBody Accountant accountant) {
		return new ResponseEntity<Accountant>(accountantService.updateAccountant(accountant), HttpStatus.CREATED);
	}

	@PatchMapping("/accountant/{accountantId}/{phoneNumber}")
	public ResponseEntity<Accountant> patchAccountant(@Valid @PathVariable long accountantId,
			@PathVariable long phoneNumber) {
		return new ResponseEntity<Accountant>(accountantService.patchAccountant(phoneNumber,accountantId), HttpStatus.CREATED);
	}

	@PostMapping("/studentClass")
	public ResponseEntity<StudentClass> addStudentClass(@Valid @RequestBody StudentClass studentClass) {
		return new ResponseEntity<StudentClass>(studentClassServiceImpl.addStudentClass(studentClass), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/studentClass/{studentClassId}")
	public ResponseEntity<StudentClass> deleteStudentClass(@PathVariable long studentClassId) {
		studentClassServiceImpl.deleteStudentClassById(studentClassId);
		return new ResponseEntity<StudentClass>(HttpStatus.OK);
	}
}