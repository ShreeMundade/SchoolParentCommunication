package com.sprint1.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.spc.entities.FeeInstallment;

public interface IFeeInstallmentRepository extends JpaRepository<FeeInstallment, Integer> {
}