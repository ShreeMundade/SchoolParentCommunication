package com.sprint1.spc.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Fee;

@Service
public interface IFeeService {
	public Fee addFee(Fee fee);
	public Fee updateFee(long id, Fee fee);
	public Fee retrieveFeeById(long id);
	public List<Fee> retrieveAllFees();
	public List<Fee> retrieveFeeByStudentId(long id);
	public List<Fee> retrieveAllFeesByMonth(long month);
	public Fee retrieveFeesByStudentName(String name);
	public void deleteFeeById(long id);
}