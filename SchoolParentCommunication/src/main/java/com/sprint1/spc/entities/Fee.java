package com.sprint1.spc.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Fee")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Fee {

	@Id
    @SequenceGenerator(name = "FeesIdGeneration", initialValue = 4001, allocationSize = 995)
    @GeneratedValue(generator = "FeesIdGeneration")
	
	private long feeId;
	@NotNull
	private double totalFeesDue;
	@NotNull
	private double totalFeesReceived;
	@NotNull
	private LocalDate startMonthYear;
	@NotNull
	private LocalDate endMonthYear;


	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JsonBackReference
	private List<FeeInstallment> feeInstallment;

	public Fee(long feeId, double totalFeesDue, double totalFeesReceived, LocalDate startMonthYear,
			LocalDate endMonthYear, List<FeeInstallment> feeInstallment) {
		super();
		this.feeId = feeId;
		this.totalFeesDue = totalFeesDue;
		this.totalFeesReceived = totalFeesReceived;
		this.startMonthYear = startMonthYear;
		this.endMonthYear = endMonthYear;
		this.feeInstallment = feeInstallment;
	}

	public Fee(long feeId, double totalFeesDue, double totalFeesReceived, LocalDate startMonthYear,
			LocalDate endMonthYear) {
		super();
		this.feeId = feeId;
		this.totalFeesDue = totalFeesDue;
		this.totalFeesReceived = totalFeesReceived;
		this.startMonthYear = startMonthYear;
		this.endMonthYear = endMonthYear;
	}

	public Fee(double totalFeesDue, double totalFeesReceived, LocalDate startMonthYear, LocalDate endMonthYear,
			List<FeeInstallment> feeInstallment) {
		super();
		this.totalFeesDue = totalFeesDue;
		this.totalFeesReceived = totalFeesReceived;
		this.startMonthYear = startMonthYear;
		this.endMonthYear = endMonthYear;
		this.feeInstallment = feeInstallment;
	}

	public Fee(double totalFeesDue, double totalFeesReceived, LocalDate startMonthYear, LocalDate endMonthYear) {
		super();
		this.totalFeesDue = totalFeesDue;
		this.totalFeesReceived = totalFeesReceived;
		this.startMonthYear = startMonthYear;
		this.endMonthYear = endMonthYear;
	}

	public Fee() {
		super();
	}

	public long getFeeId() {
		return feeId;
	}

	public void setFeeId(long feeId) {
		this.feeId = feeId;
	}

	public double getTotalFeesDue() {
		return totalFeesDue;
	}

	public void setTotalFeesDue(double totalFeesDue) {
		this.totalFeesDue = totalFeesDue;
	}

	public double getTotalFeesReceived() {
		return totalFeesReceived;
	}

	public void setTotalFeesReceived(double totalFeesReceived) {
		this.totalFeesReceived = totalFeesReceived;
	}

	public LocalDate getStartMonthYear() {
		return startMonthYear;
	}

	public void setStartMonthYear(LocalDate startMonthYear) {
		this.startMonthYear = startMonthYear;
	}

	public LocalDate getEndMonthYear() {
		return endMonthYear;
	}

	public void setEndMonthYear(LocalDate endMonthYear) {
		this.endMonthYear = endMonthYear;
	}

	public List<FeeInstallment> getFeeInstallment() {
		return feeInstallment;
	}

	public void setFeeInstallment(List<FeeInstallment> feeInstallment) {
		this.feeInstallment = feeInstallment;
	}

	@Override
	public String toString() {
		return "Fee [feeId=" + feeId + ", totalFeesDue=" + totalFeesDue + ", totalFeesReceived=" + totalFeesReceived
				+ ", startMonthYear=" + startMonthYear + ", endMonthYear=" + endMonthYear + "]";
	}
}