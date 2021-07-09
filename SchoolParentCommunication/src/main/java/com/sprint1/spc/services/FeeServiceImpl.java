package com.sprint1.spc.services;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.repository.IFeeInstallmentRepository;
import com.sprint1.spc.repository.IFeeRepository;

@Service
@Transactional
public class FeeServiceImpl implements IFeeService {
	
	@Autowired
	private IFeeRepository iFeeRepository;
	
	@Autowired
	private IFeeInstallmentRepository iFeeInstallmentRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
//	@Autowired
//	private IStudentRepository iStudentRepository;
	
	@Override
	public Fee addFee(Fee fee) {
		if(!fee.equals(null)) {
			return iFeeRepository.save(fee);
		}
		else {
			return null;
		}
	}

	@Override
	public List<Fee> retrieveAllFees() {
		List<Fee> feeList = iFeeRepository.findAll();
		if(!feeList.equals(null)) {
			return feeList;
		}
		else {
			return null;
		}
	}

	@Override
	public Fee updateFee(long feeId, Fee fee) {
		long feeId1 = fee.getFeeId();
		Fee existingFee = iFeeRepository.findById(feeId1).orElse(null);
		if(existingFee == null) {
			return null;
//			BeanUtils.copyProperties(fee, existingFee, "feeId1");
//			iFeeRepository.save(existingFee);
//			return existingFee;
		}
		else {
			BeanUtils.copyProperties(fee, existingFee, "feeId");
			iFeeRepository.save(existingFee);
			return existingFee;
		}
	}

	@Override
	public Fee retrieveFeeById(long id) {
		Fee fee = iFeeRepository.findById(id).get();
		if(!fee.equals(null)) {
			return fee;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Fee> retrieveAllFeesByMonth(long month) {
		List<Fee> feeList = iFeeRepository.findAll();
		List<Fee> feesByMonth = new ArrayList<Fee>();
		for(Fee fee: feeList)
		{
			Month getStartMonth = fee.getStartMonthYear().getMonth();
			Month getEndMonth = fee.getEndMonthYear().getMonth();
			if(month == getStartMonth.getValue() || month == getEndMonth.getValue()) {
				feesByMonth.add(fee);
			}
			else {
				return null;
			}
		}
		return feesByMonth;
	}

	@Override
	public List<Fee> retrieveFeeByStudentId(long id) {
		List<Fee> fee = (List<Fee>)iFeeRepository.retrieveFeeByStudentId(id);
		if(!fee.equals(null)) {
			return fee;
		}
		else {
			return null;
		}
	}
	
	@Override
	public Fee retrieveFeesByStudentName(String name) {
		Fee fee = iFeeRepository.retrieveFeesByStudentName(name);
		if(!fee.equals(null)) {
			return fee;
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteFeeById(long id) {
		iFeeRepository.deleteById(id);
	}
}