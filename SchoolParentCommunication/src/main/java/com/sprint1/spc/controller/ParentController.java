package com.sprint1.spc.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.exception.ParentServiceException;
import com.sprint1.spc.services.ParentServiceImpl;

@RestController
@RequestMapping
public class ParentController {

	@Autowired
	private ParentServiceImpl parentServiceImpl;

	@GetMapping("/parents")
	public ResponseEntity<List<Parent>> getAllParents() throws ParentServiceException {
		return new ResponseEntity<List<Parent>>(parentServiceImpl.retrieveAllParents(), HttpStatus.OK);
	}

	@GetMapping("/parent/{parentId}")
	public ResponseEntity<Parent> getParentById(@PathVariable long parentId) {
		Parent parent = parentServiceImpl.retrieveParentById(parentId);
		return new ResponseEntity<Parent>(parent, HttpStatus.OK);
	}

	@PostMapping("/parent")
	public Parent insertParent(@RequestBody Parent parent) {
		return parentServiceImpl.addParent(parent);
	}

	@PatchMapping("/parent/student/{parentId}")
	public Parent updateStudentToParent(@PathVariable long parentId, @RequestBody Parent parent) throws ParentServiceException {
		return parentServiceImpl.updateStudentToParent(parentId, parent);
	}

	@GetMapping("/parent/concerns")
	public List<Concern> getParentConcerns() {
		return parentServiceImpl.retrieveAllConcerns1();
	}
	
	@PostMapping("/parent/concern")
	public Concern insertParentConcern(@RequestBody Concern concern) {
		return parentServiceImpl.addConcern1(concern);
	}
	
	@GetMapping("/parent/fee/{parentId}")
	public ResponseEntity<Fee> getFeeByParentById(@PathVariable long parentId) {
		Fee fee = parentServiceImpl.getFeeByParentId(parentId);
		return new ResponseEntity<Fee>(fee, HttpStatus.OK);
	}

	@PatchMapping("/parent/{parentId}/{phoneNumber}")
	public Parent updateParent(@PathVariable long parentId, @PathVariable long phoneNumber) throws ParentServiceException {
		return parentServiceImpl.updateParent(parentId, phoneNumber);
	}

//	@GetMapping("/parent/student/{studentId}")
//	public Parent getParentByStudentId(@PathVariable long studentId) {
//		Parent parent = parentServiceImpl.retrieveParentByStudentId(studentId);
//		return parent;
//	}
}