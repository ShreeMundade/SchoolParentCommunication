package com.sprint1.spc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.FeeInstallment;
import com.sprint1.spc.repository.IFeeInstallmentRepository;

@Service
public class FeeInstallmentServiceImpl implements IFeeInstallmentService {
	
	@Autowired
	private IFeeInstallmentRepository iFeeInstallmentRepository;

	@Override
	public FeeInstallment makePayment(FeeInstallment feeInstallment) {
		return iFeeInstallmentRepository.save(feeInstallment);
	}

//	@Override
//	public List<FeeInstallment> pendingInstallments(Student student) {
//		return null;
//	}

	@Override
	public FeeInstallment retrieveFeeInstallmentById(int id) {
		return iFeeInstallmentRepository.getById(null);
	}

//	@Override
//	public List<FeeInstallment> retrieveAllFeeInstallmentsByFee(Fee fee) {
//		return null;
//	}
}