package com.sprint1.spc.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.FeeInstallment;

@Service
@Transactional
public interface IFeeInstallmentService {
	public FeeInstallment makePayment(FeeInstallment feeInstallment);
//	public List<FeeInstallment> pendingInstallments(Student student);
	public FeeInstallment retrieveFeeInstallmentById(int id);
//	public List<FeeInstallment> retrieveAllFeeInstallmentsByFee(Fee fee);
}