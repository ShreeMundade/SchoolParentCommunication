package com.sprint1.spc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.FeeInstallment;
import com.sprint1.spc.entities.Student;

@Service
public interface IFeeInstallmentService {
	public FeeInstallment makePayment(FeeInstallment feeInstallment);
	public List<FeeInstallment> pendingInstallments(Student student);
	public FeeInstallment retrieveFeeInstallmentById(int id);
	public List<FeeInstallment> retrieveAllFeeInstallmentsByFee(Fee fee);
	
}
