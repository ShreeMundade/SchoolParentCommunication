package com.sprint1.spc.entity.tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.FeeInstallment;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FeeTest {
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void crudOperations()
	{
		final FeeInstallment feeInstallment = new FeeInstallment();
		feeInstallment.setFeeInstallment(2000);
		feeInstallment.setDueDate(LocalDate.parse("2022-06-05"));
		feeInstallment.setFeePaymentDate(LocalDate.now());
		feeInstallment.setPaid(true);
		
		final Fee fee = new Fee();
		fee.setTotalFeesReceived(3000.00d);
		fee.setStartMonthYear(LocalDate.now());
		fee.setEndMonthYear(LocalDate.parse("2022-06-05"));
		fee.setTotalFeesDue(1000.00d);
		
		final List<FeeInstallment> feeInstallmentList = new ArrayList<FeeInstallment>();
		feeInstallmentList.add(feeInstallment);
		
		fee.setFeeInstallment(feeInstallmentList);
		
		entityManager.persist(feeInstallment);
		entityManager.persist(fee);
		
		final List<Fee> listOfFee = entityManager.createQuery("select f from Fee f", Fee.class).getResultList();
		
		Assertions.assertEquals(6, listOfFee.size());
	}
}