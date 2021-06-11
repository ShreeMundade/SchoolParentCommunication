package com.sprint1.spc.service.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.FeeInstallment;
import com.sprint1.spc.repository.IFeeRepository;
import com.sprint1.spc.services.FeeServiceImpl;

public class FeeServiceTest {

	@InjectMocks
	@Autowired
	private FeeServiceImpl feeServiceImpl;
	
	@Mock
	private IFeeRepository iFeeRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
	}
	
	// Add fee test
	@Test
	public void addFeeTest() {
		Fee fee1 = new Fee(1L, 200, 100, LocalDate.now(), LocalDate.now());
		Fee fee2 = new Fee(1L, 200, 100, LocalDate.now(), LocalDate.now());
		Mockito.when(iFeeRepository.saveAndFlush(fee1)).thenReturn(fee2);
		assertEquals(fee2, feeServiceImpl.addFee(fee1));
	}
	
	// Get all fees test
	@Test
	public void retrieveAllFeesTest() {
		Mockito.when(iFeeRepository.findAll()).thenReturn(Stream.of(new Fee(1L, 200, 100, LocalDate.now(), LocalDate.now()), new Fee(1L, 200, 100, LocalDate.now(), LocalDate.now())).collect(Collectors.toList()));
		assertEquals(2, feeServiceImpl.retrieveAllFees().size());
	}
	
	// Get fee by id test
	@Test
	public void retrieveFeeByIdTest() {
		List<FeeInstallment> feeInstallments = new ArrayList<FeeInstallment>();
		feeInstallments.add(new FeeInstallment(200, LocalDate.now(), LocalDate.now(), true));
		feeInstallments.add(new FeeInstallment(300, LocalDate.now(), LocalDate.now(), false));
		Fee fee = new Fee(1L, 200, 100, LocalDate.now(), LocalDate.now(), feeInstallments);
		Mockito.when(iFeeRepository.getById(1L)).thenReturn(fee);
		assertEquals(fee, feeServiceImpl.retrieveFeeById(1L));
	}
	
	// Update fee test
	@Test
	public void updateFeeTest() {
		List<FeeInstallment> feeInstallments = new ArrayList<FeeInstallment>();
		feeInstallments.add(new FeeInstallment(200, LocalDate.now(), LocalDate.now(), true));
		feeInstallments.add(new FeeInstallment(300, LocalDate.now(), LocalDate.now(), false));
		Fee fee = new Fee(1L, 200, 100, LocalDate.now(), LocalDate.now(), feeInstallments);
		Mockito.when(iFeeRepository.getById(fee.getFeeId())).thenReturn(fee);
		assertEquals(fee, feeServiceImpl.updateFee(1L, fee));
	}
	
	// Get fees by month test
	@Test
	public void retrieveAllFeesByMonthTest() {
		List<FeeInstallment> feeInstallments = new ArrayList<FeeInstallment>();
		feeInstallments.add(new FeeInstallment(1L, 2000, LocalDate.now(), LocalDate.now(), true));
		feeInstallments.add(new FeeInstallment(3L, 8000, LocalDate.now(), LocalDate.now(), false));
		Fee fee = new Fee(1L, 2000, 3000, LocalDate.now(), LocalDate.now(), feeInstallments);
		Mockito.when(iFeeRepository.getById(1L)).thenReturn(fee);
		for(Fee feeTest: feeServiceImpl.retrieveAllFeesByMonth(6L)) {
			assertEquals(fee.getFeeId(), feeTest.getFeeId());
			assertEquals(fee.getEndMonthYear(), feeTest.getEndMonthYear());
			assertEquals(fee.getStartMonthYear(), feeTest.getStartMonthYear());
			assertEquals(fee.getTotalFeesDue(), feeTest.getTotalFeesDue());
			assertEquals(fee.getTotalFeesReceived(), feeTest.getTotalFeesReceived());
		}
	}
	
	// Get fee by student id test
	@Test
	public void retrieveFeeByStudentIdTest() {
		List<FeeInstallment> feeInstallments = new ArrayList<FeeInstallment>();
		feeInstallments.add(new FeeInstallment(200, LocalDate.now(), LocalDate.now(), true));
		feeInstallments.add(new FeeInstallment(300, LocalDate.now(), LocalDate.now(), false));
		Fee fee1 = new Fee(1L, 200, 100, LocalDate.now(), LocalDate.now(), feeInstallments);
		Fee fee2 = new Fee(1L, 200, 100, LocalDate.now(), LocalDate.now(), feeInstallments);
		List<Fee> feeList = new ArrayList<Fee>();
		feeList.add(fee1);
		feeList.add(fee2);
		Mockito.when(iFeeRepository.retrieveFeeByStudentId(2L)).thenReturn(feeList);
		assertEquals(feeList, feeServiceImpl.retrieveFeeByStudentId(2L));
	}

	// Get fees by student name test
	@Test
	public void retrieveFeeByStudentNameTest() {
		List<FeeInstallment> feeInstallments = new ArrayList<FeeInstallment>();
		feeInstallments.add(new FeeInstallment(200, LocalDate.now(), LocalDate.now(), true));
		feeInstallments.add(new FeeInstallment(300, LocalDate.now(), LocalDate.now(), false));
		Fee fee = new Fee(1L, 2000, 3000, LocalDate.now(), LocalDate.now(), feeInstallments);
		Mockito.when(iFeeRepository.retrieveFeesByStudentName("Student1")).thenReturn(fee);
		assertEquals(fee.getFeeId(), feeServiceImpl.retrieveFeesByStudentName("Student1").getFeeId());
		assertEquals(fee.getEndMonthYear(), feeServiceImpl.retrieveFeesByStudentName("Student1").getEndMonthYear());
		assertEquals(fee.getStartMonthYear(), feeServiceImpl.retrieveFeesByStudentName("Student1").getStartMonthYear());
		assertEquals(fee.getTotalFeesDue(), feeServiceImpl.retrieveFeesByStudentName("Student1").getTotalFeesDue());
		assertEquals(fee.getTotalFeesReceived(), feeServiceImpl.retrieveFeesByStudentName("Student1").getTotalFeesReceived());
	}
}