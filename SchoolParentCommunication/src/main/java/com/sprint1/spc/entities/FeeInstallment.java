package com.sprint1.spc.entities;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Fee_Installment")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FeeInstallment {

	@Id
	@SequenceGenerator(name = "FeesInstallmentGeneration", initialValue = 5001, allocationSize = 1000)
	@GeneratedValue(generator = "FeesInstallmentGeneration")
	@Column(name = "installment_id")
	private long feeInstallmentId;
	private double feeInstallment;
	private LocalDate dueDate;
	private LocalDate feePaymentDate;
	private boolean isPaid;

	public long getFeeInstallmentId() {
		return feeInstallmentId;
	}

	public void setFeeInstallmentId(long feeInstallmentId) {
		this.feeInstallmentId = feeInstallmentId;
	}

	public double getFeeInstallment() {
		return feeInstallment;
	}

	public void setFeeInstallment(double feeInstallment) {
		this.feeInstallment = feeInstallment;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getFeePaymentDate() {
		return feePaymentDate;
	}

	public void setFeePaymentDate(LocalDate feePaymentDate) {
		this.feePaymentDate = feePaymentDate;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public FeeInstallment(long feeInstallmentId, double feeInstallment, LocalDate dueDate, LocalDate feePaymentDate,
			boolean isPaid) {
		super();
		this.feeInstallmentId = feeInstallmentId;
		this.feeInstallment = feeInstallment;
		this.dueDate = dueDate;
		this.feePaymentDate = feePaymentDate;
		this.isPaid = isPaid;
	}

	public FeeInstallment(double feeInstallment, LocalDate dueDate, LocalDate feePaymentDate, boolean isPaid) {
		super();
		this.feeInstallment = feeInstallment;
		this.dueDate = dueDate;
		this.feePaymentDate = feePaymentDate;
		this.isPaid = isPaid;
	}

	public FeeInstallment() {
		super();
	}

	@Override
	public String toString() {
		return "FeeInstallment [feeInstallmentId=" + feeInstallmentId + ", feeInstallment=" + feeInstallment
				+ ", dueDate=" + dueDate + ", feePaymentDate=" + feePaymentDate + ", isPaid=" + isPaid + "]";
	}
}