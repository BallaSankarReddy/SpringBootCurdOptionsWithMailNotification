package com.springboot.curd.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.curd.entities.Payment;
import com.springboot.curd.repository.PaymenetRepository;
import com.springboot.curd.service.LoanInteratecalculationService;
import com.springboot.curd.service.PaymentService;

@Component
public class PaymentServiceImpl implements PaymentService {

	Logger logger = LogManager.getLogger();

	List<Payment> payments = new ArrayList<>();
	@Autowired 
	private PaymenetRepository  PaymenetRepository;

	@Autowired
	private LoanInteratecalculationService loanInteratecalculationService;

	public Payment savePayment(Payment paymentRequest) {
		return loanAccountCreation(paymentRequest);
	}

	private Payment loanAccountCreation(Payment paymentRequest) {
		if(!Optional.ofNullable(paymentRequest.getPaymentId()).isPresent()) {
			
		Payment payment = loanInteratecalculationService.getLoanAccountPaymentsByAccountId(paymentRequest.getAccountId()).stream().filter(pay -> null!=pay.getPaymentId())
				.max(Comparator.comparingInt(Payment::getPaymentId)).orElse(new Payment());
		Payment paymentDB = PaymenetRepository.save(paymentRequest);
		paymentRequest.setPaymentId(paymentDB.getPaymentId());
		}
		payments.add(paymentRequest);
		return paymentRequest;
	}

	@Override
	public Payment createPayment(Payment paymentRequest) {

		return loanAccountCreation(paymentRequest);
	
	}

	@Override
	public Payment getLoanPayment(Integer paymentId) {
		
		return PaymenetRepository.getOne(paymentId);
	}

	@Override
	public List<Payment> getLoanPaymentByPaymentId(Integer paymentId) {
		return null;
	}

	@Override
	public List<Payment> getLoanPaymentByAccountId(Integer accountId) {
		
		return PaymenetRepository.findPaymentByAccountId(accountId);
	}
	
	
}
