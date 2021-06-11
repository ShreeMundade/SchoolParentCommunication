package com.sprint1.spc.services;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.FeeInstallment;

@Service
public interface IFeeInstallmentService {
	public FeeInstallment makePayment(FeeInstallment feeInstallment);
//	public List<FeeInstallment> pendingInstallments(Student student);
	public FeeInstallment retrieveFeeInstallmentById(int id);
//	public List<FeeInstallment> retrieveAllFeeInstallmentsByFee(Fee fee);
}