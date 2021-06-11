package com.sprint1.spc.services;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.repository.IFeeRepository;

@Service
public class FeeServiceImpl implements IFeeService {
	
	@Autowired
	private IFeeRepository iFeeRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
//	@Autowired
//	private IStudentRepository iStudentRepository;
	
	@Override
	public Fee addFee(Fee fee) {
		return iFeeRepository.saveAndFlush(fee);
	}

	@Override
	public List<Fee> retrieveAllFees() {
		List<Fee> feeList = iFeeRepository.findAll();
		return feeList;
	}

	@Override
	public Fee updateFee(long id, Fee fee) {
		Fee existingFee = iFeeRepository.getById(id);
		BeanUtils.copyProperties(fee, existingFee, "feeId");
		iFeeRepository.save(existingFee);
		return existingFee;
	}

	@Override
	public Fee retrieveFeeById(long id) {
		Fee fee = iFeeRepository.getById(id);
		return fee;
	}

	@Override
	public List<Fee> retrieveAllFeesByMonth(long month) {
		List<Fee> feeList = iFeeRepository.findAll();
		List<Fee> feesByMonth = new ArrayList<Fee>();
		for(Fee fee: feeList)
		{
			Month getStartMonth = fee.getStartMonthYear().getMonth();
			Month getEndMonth = fee.getEndMonthYear().getMonth();
			if(month == getStartMonth.getValue() || month == getEndMonth.getValue())
			{
				feesByMonth.add(fee);
			}
		}
		return feesByMonth;
	}

	@Override
	public List<Fee> retrieveFeeByStudentId(long id) {
		List<Fee> fee = (List<Fee>)iFeeRepository.retrieveFeeByStudentId(id);
		return fee;
	}
	
	@Override
	public Fee retrieveFeesByStudentName(String name) {
		Fee fee = iFeeRepository.retrieveFeesByStudentName(name);
		return fee;
	}

	@Override
	public void deleteFeeById(long id) {
		iFeeRepository.deleteById(id);
	}
}