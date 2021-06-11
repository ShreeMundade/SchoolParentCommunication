package com.sprint1.spc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.FeeInstallment;
import com.sprint1.spc.entities.Student;

@Service
public class FeeInstallmentServiceImpl implements IFeeInstallmentService{

	@Override
	public FeeInstallment makePayment(FeeInstallment feeInstallment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeeInstallment> pendingInstallments(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeeInstallment retrieveFeeInstallmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeeInstallment> retrieveAllFeeInstallmentsByFee(Fee fee) {
		// TODO Auto-generated method stub
		return null;
	}

}
