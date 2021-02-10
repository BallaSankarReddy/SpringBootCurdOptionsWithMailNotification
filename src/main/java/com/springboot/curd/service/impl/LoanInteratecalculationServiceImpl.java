package com.springboot.curd.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.curd.entities.Account;
import com.springboot.curd.entities.Payment;
import com.springboot.curd.repository.LoanInteratecalculationRepository;
import com.springboot.curd.service.LoanInteratecalculationService;
import com.springboot.curd.service.PaymentService;

@Component
public class LoanInteratecalculationServiceImpl implements LoanInteratecalculationService{

	Logger LOGGER = LogManager.getLogger();
	Random ran = new Random();
	
	List<Account> accounts= new ArrayList<>();
	List<Payment> payments= new ArrayList<>();
	
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private LoanInteratecalculationRepository loanInteratecalculationRepository;

	@Transactional
	@Override
	public Account createLoanAccount(Account accountRequest) {
		LOGGER.info("Calling... LoanInteratecalculationServiceImpl::saveLoanAccounDetails");
	Payment payment= new Payment();
		if(Optional.ofNullable(accountRequest).isPresent()) {
			LOGGER.info("Creating loan account object");
			accountRequest.setPaymentid(ran.nextInt(100));
			accountRequest.setNextPaymentDate(LocalDate.now().plusMonths(1));
			accountRequest.setPreviusPaymentDate(LocalDate.now().minusMonths(1));
			Account account = loanInteratecalculationRepository.save(accountRequest);
			accountRequest.setAccountId(ran.nextInt(100));
			accounts.add(accountRequest);
		}
		
		if(Optional.ofNullable(accountRequest).isPresent()) {
			payment.setPaymentId(accountRequest.getPaymentid());
			payment.setPaymentAmount(accountRequest.getPayingAmount());
			payment.setPaymentDate(LocalDate.now());
			payment.setPaymentType("CASH");
			LOGGER.info("Creating loan payment object");
			paymentService.createPayment(payment);
			payments.add(payment);
		}
		LOGGER.info("Calling Ending... LoanInteratecalculationServiceImpl::saveLoanAccounDetails");
		return accountRequest;
	}
	
	
	@Override
	public Account getLoanAccount(Integer accountId) {
		LOGGER.info("Calling ... LoanInteratecalculationServiceImpl::getLoanAccount");
		Account accountFromDB = accounts.stream().filter(account -> account.getAccountId().compareTo(accountId)==0).findFirst().orElse(new Account());
		LOGGER.info("Calling Ending... LoanInteratecalculationServiceImpl::getLoanAccount");
		return accountFromDB;
		
		
	}




	@Override
	public Account getLoanAccountByPaymentId(Integer paymentId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Payment> getLoanAccountPaymentsByAccountId(Integer accounId) {
		List<Payment> payments = new ArrayList<>();
		 accounts.stream().filter(payment -> null!=payment.getAccountId()).forEach(pay ->{
			 Payment p = new  Payment();
			 
			 p.setAccountId(pay.getAccountId());
			 p.setPaymentAmount(pay.getPayingAmount());
			 p.setPaymentDate(null);
			 p.setPaymentId(pay.getPaymentid());
			 payments.add(p); 
		 });
		return payments;
	}

}
