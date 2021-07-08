package com.sprint1.spc.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.spc.entities.Accountant;
import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.ParentServiceException;
import com.sprint1.spc.exception.StudentIDNotFoundException;
import com.sprint1.spc.exception.UserNotFoundException;
import com.sprint1.spc.services.ConcernServiceImpl;
import com.sprint1.spc.services.ParentServiceImpl;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping
public class ParentController {

	@Autowired
	private ParentServiceImpl parentServiceImpl;
	@Autowired
	private ConcernServiceImpl concernServiceImpl;

//	@GetMapping("/parents")
//	@ApiOperation(value = "Get All Parents", notes = "Get all parent information.")
//	public ResponseEntity<List<Parent>> getAllParents() throws ParentServiceException {
//		return new ResponseEntity<List<Parent>>(parentServiceImpl.retrieveAllParents(), HttpStatus.OK);
//	}

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e) {
//      
//        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(fieldError-> new FieldErrorMessage(fieldError.getField(),fieldError.getDefaultMessage())).collect(Collectors.toList());
//        return fieldErrorMessages;
//    }
	
	@GetMapping("/parent/{parentId}")
	@ApiOperation(value = "Get Parent By Id", notes = "Get parent details by parentId.")
	public ResponseEntity<Parent> getParentById(@PathVariable long parentId) throws ParentServiceException {
		if(parentServiceImpl.retrieveParentById1(parentId) == 0) {
			throw new ParentServiceException("Parent Not Found.");
		}
		else {
			Parent parent = parentServiceImpl.retrieveParentById(parentId);
			return new ResponseEntity<Parent>(parent, HttpStatus.OK);
		}
	}

	@GetMapping("/parent/{parentId}/concerns")
	@ApiOperation(value = "Get All Concerns", notes = "Get all concern details of parent.")
	public List<Concern> getParentConcerns(@PathVariable long parentId) throws ParentServiceException {
		if(parentServiceImpl.retrieveParentById1(parentId) == 0) {
			throw new ParentServiceException("Parent Not Found.");
		}
		else {
			return parentServiceImpl.retrieveAllConcerns1();
		}
	}

	@GetMapping("/parent/{parentId}/fee")
	@ApiOperation(value = "Get Fee Details", notes = "Get fee details by parent id.")
	public ResponseEntity<Fee> getFeeByParentById(@PathVariable long parentId) throws ParentServiceException {
		if(parentServiceImpl.retrieveParentById1(parentId) == 0) {
			throw new ParentServiceException("Parent Not Found.");
		}
		else {
			Fee fee = parentServiceImpl.getFeeByParentId(parentId);
			return new ResponseEntity<Fee>(fee, HttpStatus.OK);
		}
	}

	@PostMapping("/parent")
	@ApiOperation(value = "Add Parent Details", notes = "Add parent details.")
	public Parent insertParent(@Valid @RequestBody Parent parent) throws ParentServiceException {
		if(parent.equals(null)) {
			throw new ParentServiceException("Please Add Valid Parent Details.");
		}
		else {
			return parentServiceImpl.addParent(parent);
		}
	}

	@PostMapping("/parent/concern")
	@ApiOperation(value = "Add Concern", notes = "Add concern details.")
	public Concern insertParentConcern(@RequestBody Concern concern) throws ParentServiceException {
//		if(parentServiceImpl.retrieveParentById1(parentId) == 0) {
//			throw new ParentServiceException("Parent Not Found.");
//		}
//		else if(concern.equals(null)) {
//			throw new ParentServiceException("Please Add Valid Concern Details.");
//		}
//		else {
			return concernServiceImpl.addConcern(concern);
//		}
	}
//	@PostMapping("/parent/{parentId}/concern")
//	@ApiOperation(value = "Add Concern", notes = "Add concern details.")
//	public Concern insertParentConcern(@PathVariable long parentId, @RequestBody Concern concern) throws ParentServiceException {
//		if(parentServiceImpl.retrieveParentById1(parentId) == 0) {
//			throw new ParentServiceException("Parent Not Found.");
//		}
//		else if(concern.equals(null)) {
//			throw new ParentServiceException("Please Add Valid Concern Details.");
//		}
//		else {
//			return parentServiceImpl.addConcern(concern);
//		}
//	}

	@PatchMapping("/parent/{studentId}")
	@ApiOperation(value = "Update Student Details To Parent", notes = "Update student details to parent.")
	public Parent updateStudentToParent(@PathVariable long studentId, @RequestBody Parent parent) throws ParentServiceException, StudentIDNotFoundException {
//		if(parentServiceImpl.retrieveParentById1(parentId) == 0) {
//			throw new ParentServiceException("Parent Not Found.");
//		}
//		else if(parent.equals(null)) {
//			throw new ParentServiceException("Please Add Valid Parent Details.");
//		}
//		else {
			return parentServiceImpl.updateStudentToParent(studentId, parent);
//		}
	}

	@PatchMapping("/parent")
	@ApiOperation(value = "Update Parent", notes = "Update phone number by parent id.")
	public Parent updateParent(@RequestBody Parent parent) throws ParentServiceException, UserNotFoundException {
		if(parentServiceImpl.retrieveParentById1(parent.getId()) == 0) {
			throw new ParentServiceException("Parent Not Found.");
		}
		else {
			return parentServiceImpl.updateParent(parent);
		}
	}
	
	@GetMapping("/parent/get")
	public ResponseEntity<Parent> getParentByEmailId(@RequestParam String emailId) {
		System.out.println(emailId);
		Parent foundParent = parentServiceImpl.getParentByEmailId(emailId);
		return new ResponseEntity<Parent>(foundParent, HttpStatus.OK);
	}
	
//	@GetMapping("/parent/student/{studentId}")
//	public Parent getParentByStudentId(@PathVariable long studentId) {
//		Parent parent = parentServiceImpl.retrieveParentByStudentId(studentId);
//		return parent;
//	}
}