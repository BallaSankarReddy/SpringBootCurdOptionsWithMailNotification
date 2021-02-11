package com.springboot.curd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.curd.entities.Payment;

@Repository
public interface PaymenetRepository extends JpaRepository<Payment, Integer> {
	
	public List<Payment> findPaymentByAccountId(Integer accountId);

}
