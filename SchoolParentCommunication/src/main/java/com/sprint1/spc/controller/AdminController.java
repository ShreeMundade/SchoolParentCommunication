package com.sprint1.spc.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.spc.entities.Accountant;
import com.sprint1.spc.entities.Admin;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.FieldErrorMessage;
import com.sprint1.spc.exception.StudentIDNotFoundException;
import com.sprint1.spc.exception.TeacherNotFoundException;
import com.sprint1.spc.exception.UserNotFoundException;
import com.sprint1.spc.services.AdminServiceImpl;
import com.sprint1.spc.services.IAccountantService;
import com.sprint1.spc.services.IAdminService;
import com.sprint1.spc.services.IParentService;
import com.sprint1.spc.services.IStudentClassService;
import com.sprint1.spc.services.IStudentService;
import com.sprint1.spc.services.ISubjectService;
import com.sprint1.spc.services.ITeacherService;
import com.sprint1.spc.services.IUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowedHeaders = { "Authorization",
		"Access-Control-Request-Headers", "Content-Type", "Access-Control-Allow-Origin",
		"Access-Control-Allow-Credentials", "Access-Control-Allow-Headers" })
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
	private ISubjectService subjectService;

	@Autowired
	private IStudentClassService studentClassService;
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@GetMapping("/accountants")
	@ApiOperation(value = "Get All Accountants", notes = "List of all accountants given here.")
	public ResponseEntity<List<Accountant>> getAllAccountants() {
		List<Accountant> listOfAccountants = accountantService.retrieveAllAccountants();
		return new ResponseEntity<List<Accountant>>(listOfAccountants, HttpStatus.OK);
	}

	@GetMapping("/students")
	@ApiOperation(value = "Get All Students", notes = "List of all students given here.")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> listOfStudents = studentService.retrieveAllStudents();
		return new ResponseEntity<List<Student>>(listOfStudents, HttpStatus.OK);
	}

	@GetMapping
	@ApiOperation(value = "Get Admin", notes = "Admin is one who controls everything.")
	public ResponseEntity<List<User>> getAdmin() {
		List<User> listOfAdmins = userService.listUserByRole(Role.ADMIN);
		return new ResponseEntity<List<User>>(listOfAdmins, HttpStatus.OK);
	}

	@GetMapping("/teachers")
	@ApiOperation(value = "Get All Teachers", notes = "List of all teachers given here.")
	public ResponseEntity<List<Teacher>> adminGetTeachers() {
		List<Teacher> listOfTeachers = teacherService.retrieveAllTeachers();
		return new ResponseEntity<List<Teacher>>(listOfTeachers, HttpStatus.OK);
	}

	@GetMapping("/parents")
	@ApiOperation(value = "Get All Parents", notes = "List of all parents given here.")
	public ResponseEntity<List<Parent>> adminGetParents() {
		List<Parent> listOfParents = parentService.retrieveAllParents();
		return new ResponseEntity<List<Parent>>(listOfParents, HttpStatus.OK);
	}

	@GetMapping("/users")
	@ApiOperation(value = "Get All Users Of The System", notes = "List of all the users of the system.")
	public ResponseEntity<List<User>> allUsers() {
		List<User> listOfUsers = userService.listAllUsers();
		return new ResponseEntity<List<User>>(listOfUsers, HttpStatus.OK);
	}

	@GetMapping("/student")
	@ApiOperation(value = "Get Student By Id", notes = "Enter student id to get student information. ")
	public ResponseEntity<Student> getStudentById(@RequestParam long studentId) throws UserNotFoundException {
		Student student = studentService.retrieveStudentById(studentId);
//		if (student.equals(null)) {
//			throw new UserNotFoundException("Student Not Found");
//		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);

	}

	@GetMapping("/teacher")
	@ApiOperation(value = "Get Teacher By Id", notes = "Enter teacher id to get teacher information. ")
	public ResponseEntity<Teacher> getTeacherById(@RequestParam long teacherId) throws UserNotFoundException {
		Teacher teacher = teacherService.retrieveTeacherById(teacherId);
//		if (teacher.equals(null)) {
//			throw new UserNotFoundException("Student Not Found");
//		}
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);

	}

	@ApiOperation(value = "Get All Subjects", notes = "List of all subjects given here.")
	@GetMapping("/subjects")
	public ResponseEntity<List<Subject>> getAllSubjects() {
		List<Subject> listOfSubjects = subjectService.retrieveAllSubjects();
		return new ResponseEntity<List<Subject>>(listOfSubjects, HttpStatus.OK);
	}

	@GetMapping("/accountant")

	@ApiOperation(value = "Get Accountant Id", notes = "Enter Accountant id to get accountant information. ")
	public ResponseEntity<Accountant> getAccountantById(@RequestParam long id) throws UserNotFoundException {
		Accountant accountant = accountantService.retrieveAccountantById1(id);

		return new ResponseEntity<Accountant>(accountant, HttpStatus.OK);

	}

	@PostMapping("/student")
	@ApiOperation(value = "Add Student", notes = "Enter the student details to add student.")
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.CREATED);
	}

	@PostMapping("/teacher")
	@ApiOperation(value = "Add Teacher", notes = "Enter the teacher details to add student.")
	public ResponseEntity<Teacher> addTeacher(@Valid @RequestBody Teacher teacher) {
		return new ResponseEntity<Teacher>(teacherService.addTeacher(teacher), HttpStatus.CREATED);
	}

	@PostMapping("/parent/{studentId}")
	@ApiOperation(value = "Add Parent With Student Id", notes = "Enter the parent details with student id.")
	public ResponseEntity<Parent> insertParent(@Valid @PathVariable long studentId, @RequestBody Parent parent)
			throws UserNotFoundException {
		Student student = studentService.retrieveStudentById(studentId);
		if (student.equals(null)) {
			throw new UserNotFoundException("Student Id Not Found");
		} else {
			return new ResponseEntity<Parent>(parentService.addParent(parent), HttpStatus.CREATED);
		}
	}

	@PostMapping("/subject")
	@ApiOperation(value = "Add Subject", notes = "Enter the subject details to add.")
	public ResponseEntity<Subject> addSubject(@Valid @RequestBody Subject subject) {
		return new ResponseEntity<Subject>(subjectService.addSubject(subject), HttpStatus.CREATED);
	}

	@PostMapping("/accountant")
	@ApiOperation(value = "Add Accountant", notes = "Enter the accountant details to add.")
	public ResponseEntity<Accountant> addAccountant(@Valid @RequestBody Accountant accountant) {
		return new ResponseEntity<Accountant>(accountantService.addAccountant(accountant), HttpStatus.CREATED);
	}

	@PostMapping("/studentClass")
	@ApiOperation(value = "Add Student Class", notes = "Enter the class details to add.")
	public ResponseEntity<StudentClass> addStudentClass(@Valid @RequestBody StudentClass studentClass) {
		return new ResponseEntity<StudentClass>(studentClassService.addStudentClass(studentClass), HttpStatus.CREATED);
	}
	@GetMapping("/studentclasses")
	@ApiOperation(value = "Get All Studentsclasses", notes = "List of all students given here.")
	public ResponseEntity<List<StudentClass>> getAllStudentClass() {
		List<StudentClass> listOfStudentClass = studentClassService.retrieveAllStudentClass();
		return new ResponseEntity<List<StudentClass>>(listOfStudentClass, HttpStatus.OK);
	}
	
	@PatchMapping("/studentclassDet")
	@ApiOperation(value = "Update StudentClass Details", notes = "Enter the Studentclass details to update.")
	public ResponseEntity<StudentClass> updateStudentClass(@Valid @RequestBody StudentClass studentclass) {
		return new ResponseEntity<StudentClass>(studentClassService.updateStudentClassById(studentclass), HttpStatus.CREATED);
	}
	

//	@PatchMapping("/updateTeacher")
//	@ApiOperation(value = "Update Teacher Details", notes = "Enter the teacher details to update.")
//	public ResponseEntity<Teacher> updateTeacher(@Valid @RequestBody Teacher teacher) throws UserNotFoundException {
//
//		Teacher t1 = teacherService.retrieveTeacherById(teacher.getId());
//
//		t1.setPhoneNumber(teacher.getPhoneNumber());
//
//		Teacher updatedTeacher = teacherService.updateTeacher(t1);
//
//		return new ResponseEntity<Teacher>(updatedTeacher, HttpStatus.OK);
//
//	}
	
	
//	@PatchMapping("/updateTeacher/{subjectId}/{teacherId}")
//	@ApiOperation(value = "Update Teacher Details", notes = "Enter the teacher details to update.")
//	public ResponseEntity<Teacher> updateTeacher(@PathVariable long subjectId,@PathVariable long teacherId ) throws UserNotFoundException {
//		
//
//		return new ResponseEntity<Teacher>(teacherService.patchTeacher(subjectId,teacherId), HttpStatus.OK);
//
//	}
	
	@PatchMapping("/updateTeacher/{subjectId}")
	@ApiOperation(value = "Update Teacher Details", notes = "Enter the teacher details to update.")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable long subjectId,@RequestBody Teacher teacher) throws UserNotFoundException {
		

		return new ResponseEntity<Teacher>(teacherService.patchTeacher(subjectId,teacher), HttpStatus.OK);

	}
	
	@PatchMapping("/updateClass/{classId}")
	@ApiOperation(value = "Update Teacher Class", notes = "Enter the teacher details to update.")
	public ResponseEntity<Teacher> updateClass(@PathVariable long classId,@RequestBody Teacher teacher) {
		

		return new ResponseEntity<Teacher>(teacherService.patchClass(classId,teacher), HttpStatus.OK);

	}

	@PatchMapping("/studentDet")
	@ApiOperation(value = "Update Student Details", notes = "Enter the Student details to update.")
	public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudentById(student), HttpStatus.CREATED);
	}

	@PatchMapping("/student")
	@ApiOperation(value = "Add Student Class To Student", notes = "Student will get added to the particular student class.")
	public ResponseEntity<Student> updateStudentClassToStudent(@Valid @RequestParam long studentId,
			@RequestParam long classId) {

		return new ResponseEntity<Student>(studentService.updateStudentClassToStudent(studentId, classId),
				HttpStatus.OK);
	}

	@PatchMapping("/accountant/{accountantId}/{phoneNumber}")
	@ApiOperation(value = "Update Accountant Phone Number", notes = "Phone number details update for accountant.")
	public ResponseEntity<Accountant> patchAccountant(@Valid @PathVariable long accountantId,
			@PathVariable String phoneNumber) {
		return new ResponseEntity<Accountant>(accountantService.patchAccountant(phoneNumber, accountantId),
				HttpStatus.OK);
	}

	@DeleteMapping("/studentClass")
	@ApiOperation(value = "Delete The Student Class By Student Class Id", notes = "Delete studentclass")
	public ResponseEntity<StudentClass> deleteStudentClass(@Valid @RequestParam long studentClassId) {
		studentClassService.deleteStudentClassById(studentClassId);
		return new ResponseEntity<StudentClass>(HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<Admin> getAdminByEmailId(@RequestParam String emailId) {
		Admin admin = adminServiceImpl.getAdminByEmailId(emailId);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	
//	@PutMapping("/accountant")
//	public ResponseEntity<Accountant> updateAccountant(@Valid @RequestBody Accountant accountant) {
//		return new ResponseEntity<Accountant>(accountantService.updateAccountant(accountant), HttpStatus.CREATED);
//	http://localhost:8081/spc/api/v1/admin/get?emailId='yash@gmail.com'
//	}
}