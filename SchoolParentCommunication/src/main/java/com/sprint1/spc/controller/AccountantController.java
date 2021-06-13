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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.exception.FeeServiceException;
import com.sprint1.spc.services.AccountantServiceImpl;
import com.sprint1.spc.services.FeeServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/accountant")
public class AccountantController {

	@Autowired
	private FeeServiceImpl feeServiceImpl;
	
	@Autowired
	private AccountantServiceImpl accountantServiceImpl;
	
//	@Autowired
//	private StudentServiceImpl studentServiceImpl;

	// Get all fees by month
	@GetMapping("{accountantId}/fee/month/{month}")
	@ApiOperation(value = "Get All Fees By Month", notes = "Enter the month to get the fee details for that month.")
	public ResponseEntity<List<Fee>> getFeeByMonth(@Valid @PathVariable long accountantId, @PathVariable long month) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id.");
		}
		else if(month == 0) {
			throw new FeeServiceException("Please Add Valid Month.");
		}
		else {
			return new ResponseEntity<List<Fee>>(feeServiceImpl.retrieveAllFeesByMonth(month), HttpStatus.OK);
		}
	}

	// Get fee by student id
	@GetMapping("{accountantId}/fee/student/id/{studentId}")
	@ApiOperation(value = "Get Fee By studentId", notes = "Enter the studentId to get the fee details for the student.")
	public ResponseEntity<List<Fee>> getFeeByStudentId(@Valid @PathVariable long accountantId, @PathVariable long studentId) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id.");
		}
		else if(studentId == 0) {
			throw new FeeServiceException("Please Add Valid Student Id.");
		}
		else {
			return new ResponseEntity<List<Fee>>(feeServiceImpl.retrieveFeeByStudentId(studentId), HttpStatus.OK);
		}
	}

	// Get all fees by student name
	@GetMapping("{accountantId}/fee/student/name/{studentName}")
	@ApiOperation(value = "Get Fee By studentName", notes = "Enter the studentName to get the fee details for the student.")
	public ResponseEntity<Fee> getFeeByStudentName(@Valid @PathVariable long accountantId, @PathVariable String studentName) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id.");
		}
		else if(studentName.equals(null) || studentName.equals("")) {
			throw new FeeServiceException("Please Add Valid Student Name.");
		}
		else {
			return new ResponseEntity<Fee>(feeServiceImpl.retrieveFeesByStudentName(studentName), HttpStatus.OK);
		}
	}

	// Get all fees
	@GetMapping("{accountantId}/fees")
	@ApiOperation(value = "Get All Fees", notes = "List of all fee details.")
	public ResponseEntity<List<Fee>> getAllFees(@Valid @PathVariable long accountantId) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id.");
		}
		else {
			return new ResponseEntity<List<Fee>>(feeServiceImpl.retrieveAllFees(), HttpStatus.OK);
		}
	}

	// Get fee by id
	@GetMapping("{accountantId}/fee/{feeId}")
	@ApiOperation(value = "Get Fee By feeId", notes = "Enter the feeId to get the fee details for the student.")
	public ResponseEntity<Fee> getFeeById(@Valid @PathVariable long accountantId, @PathVariable long feeId) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id.");
		}
		else if(feeId == 0)
		{
			throw new FeeServiceException("Please Add Valid Fee Id.");
		}
		else {
			Fee fee = feeServiceImpl.retrieveFeeById(feeId);
			return new ResponseEntity<Fee>(fee, HttpStatus.OK);
		}
	}

	// Update fee
	@PatchMapping("{accountantId}/fee/{feeId}")
	@ApiOperation(value = "Update Fee By feeId", notes = "Enter the feeId to update fee details.")
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

	// Patch fee to student
	@PatchMapping("{accountantId}/student/{studentId}")
	@ApiOperation(value = "Add Fee With studentId", notes = "Enter the studentId to update fee details.")
	public ResponseEntity<Student> patchFeeToStudent(@Valid @PathVariable long accountantId, @PathVariable long studentId, @RequestBody Fee fee) throws FeeServiceException {
		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
			throw new FeeServiceException("Please Add Valid Accountant Id");
		}
		else if(studentId == 0) {
			throw new FeeServiceException("Please Add Valid Student Id");
		}
		else if(fee.equals(null)) {
			throw new FeeServiceException("Please Add Valid Fee");
		}
		else {
			return new ResponseEntity<Student>(accountantServiceImpl.updateFeeToStudent(studentId, fee), HttpStatus.OK);
		}
	}

	// Delete fee by id
	@DeleteMapping("{accountantId}/fee/delete/{feeId}")
	@ApiOperation(value = "Delete Fee By feeId", notes = "Enter the feeId to delete that fee.")
	public ResponseEntity<Fee> deleteFeeById(@Valid @PathVariable long accountantId, @PathVariable long feeId) throws FeeServiceException {
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

//	// Add fee
//	@PostMapping("{accountantId}/{studentId}/fee")
//	public ResponseEntity<Fee> insertFee(@PathVariable long accountantId, @PathVariable long studentId, @RequestBody final Fee fee) throws FeeServiceException {
//		if(accountantServiceImpl.retrieveAccountantById(accountantId) == 0) {
//			throw new FeeServiceException("Please Add Valid Accountant Id And Student Id");
//		}
//		else if(studentServiceImpl.retreiveStudentById1(studentId) == 0) {
//			throw new FeeServiceException("Please Add Valid Student Id");
//		}
//		else if(fee.equals(null)) {
//			throw new FeeServiceException("Please Add Valid Fee");
//		}
//		else {
//			Fee addFee = feeServiceImpl.addFee(fee);
//			return new ResponseEntity<Fee>(addFee, HttpStatus.OK);
//		}
//	}
}