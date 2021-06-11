package com.sprint1.spc.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.exception.FeeServiceException;
import com.sprint1.spc.services.AccountantServiceImpl;
import com.sprint1.spc.services.FeeServiceImpl;

@RestController
@RequestMapping("/accountant")
public class AccountantController {

	@Autowired
	private FeeServiceImpl feeServiceImpl;
	
	@Autowired
	private AccountantServiceImpl accountantServiceImpl;

	// Get all fees
	@GetMapping("{accountantId}/fees")
	public ResponseEntity<List<Fee>> getAllFees(@Valid @PathVariable long accountantId) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id");
		}
		else {
			return new ResponseEntity<List<Fee>>(feeServiceImpl.retrieveAllFees(), HttpStatus.OK);
		}
	}

	// Get fee by id
	@GetMapping("{accountantId}/fee/{feeId}")
	public ResponseEntity<Fee> getFeeById(@Valid @PathVariable long accountantId, @PathVariable long feeId) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id");
		}
		else if(feeId == 0)
		{
			throw new FeeServiceException("Please Add Valid Fee Id");
		}
		else {
			Fee fee = feeServiceImpl.retrieveFeeById(feeId);
			return new ResponseEntity<Fee>(fee, HttpStatus.OK);
		}
	}

	// Add fee
	@PostMapping("{accountantId}/fee")
	public ResponseEntity<Fee> insertFee(@PathVariable long accountantId, @RequestBody final Fee fee) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id");
		}
		else if(fee.equals(null)) {
			throw new FeeServiceException("Please Add Valid Fee");
		}
		else {
			Fee addFee = feeServiceImpl.addFee(fee);
			return new ResponseEntity<Fee>(addFee, HttpStatus.OK);
		}
	}

	// Update fee
	@PatchMapping("{accountantId}/fee/{feeId}")
	public ResponseEntity<Fee> updateFee(@Valid @PathVariable long accountantId, @PathVariable long feeId, @RequestBody Fee fee) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id");
		}
		else if(feeId == 0) {
			throw new FeeServiceException("Please Add Valid Fee Id");
		}
		else if(fee.equals(null)) {
			throw new FeeServiceException("Please Add Valid Fee");
		}
		else {
			return new ResponseEntity<Fee>(feeServiceImpl.updateFee(feeId, fee), HttpStatus.OK);
		}
	}

	// Get all fees by month
	@GetMapping("{accountantId}/fee/month/{month}")
	public ResponseEntity<List<Fee>> getFeeByMonth(@PathVariable long accountantId, @PathVariable long month) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id");
		}
		else if(month == 0) {
			throw new FeeServiceException("Please Add Valid Month");
		}
		else {
			return new ResponseEntity<List<Fee>>(feeServiceImpl.retrieveAllFeesByMonth(month), HttpStatus.OK);
		}
	}

	// Get fee by student id
	@GetMapping("{accountantId}/fee/student/id/{studentId}")
	public ResponseEntity<List<Fee>> getFeeByStudentId(@PathVariable long accountantId, @PathVariable long studentId) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id");
		}
		else if(studentId == 0) {
			throw new FeeServiceException("Please Add Valid Student Id");
		}
		else {
			return new ResponseEntity<List<Fee>>(feeServiceImpl.retrieveFeeByStudentId(studentId), HttpStatus.OK);
		}
	}

	// Get all fees by student name
	@GetMapping("{accountantId}/fee/student/name/{studentName}")
	public ResponseEntity<Fee> getFeeByStudentName(@PathVariable long accountantId, @PathVariable String studentName) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id");
		}
		else if(studentName == null) {
			throw new FeeServiceException("Please Add Valid Student Name");
		}
		else {
			return new ResponseEntity<Fee>(feeServiceImpl.retrieveFeesByStudentName(studentName), HttpStatus.OK);
		}
	}

	// Delete fee by id
	@DeleteMapping("{accountantId}/fee/delete/{feeId}")
	public ResponseEntity<Fee> deleteFeeById1(@PathVariable long accountantId, @PathVariable long feeId) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id");
		}
		else if(feeId == 0) {
			throw new FeeServiceException("Please Add Valid Fee Id");
		}
		else {
			feeServiceImpl.deleteFeeById(feeId);
			return new ResponseEntity<Fee>(HttpStatus.OK);
		}
	}
}