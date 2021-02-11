package com.springboot.curd.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.curd.common.utill.LoanCalculationUtil;
import com.springboot.curd.entities.Account;
import com.springboot.curd.entities.Payment;
import com.springboot.curd.repository.LoanInteratecalculationRepository;
import com.springboot.curd.service.LoanInteratecalculationService;
import com.springboot.curd.service.PaymentService;

@Component
public class LoanInteratecalculationServiceImpl implements LoanInteratecalculationService{

	Logger logger = LogManager.getLogger();
	
	List<Account> accounts= new ArrayList<>();
	List<Payment> payments= new ArrayList<>();
	
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private LoanInteratecalculationRepository loanInteratecalculationRepository;
	
	@Autowired
	private LoanCalculationUtil loanCalculationUtil;

	@Transactional
	@Override
	public Account createLoanAccount(Account accountRequest) {
		logger.info("Calling... LoanInteratecalculationServiceImpl::saveLoanAccounDetails");
	Payment payment= new Payment();
		if(Optional.ofNullable(accountRequest).isPresent()) {
			logger.info("Creating loan account object");
			BigDecimal monthliyInterestRate = loanCalculationUtil.getMonthliyInterestRate(accountRequest.getLoanAmount(), accountRequest.getInterestRate(), accountRequest.getLoanNoOfMonths());
			accountRequest.setMonthilyAmount(monthliyInterestRate);
			accountRequest.setDailyInterRate(loanCalculationUtil.getDaliyInterestRate(monthliyInterestRate, accountRequest.getLoanNoOfMonths()));
			accountRequest.setNextPaymentDate(LocalDate.now().plusMonths(1));
			accountRequest.setPreviusPaymentDate(LocalDate.now().minusMonths(1));
			Account account = loanInteratecalculationRepository.save(accountRequest);
			accountRequest.setAccountId(account.getAccountId());
			//accounts.add(accountRequest);
		}
		
		if(Optional.ofNullable(accountRequest).isPresent()) {
			payment.setAccountId(accountRequest.getAccountId());
			payment.setPaymentAmount(accountRequest.getPayingAmount());
			payment.setPaymentDate(LocalDate.now());
			payment.setPaymentType("CASH");
			logger.info("Creating loan payment object");
			Payment createPayment = paymentService.createPayment(payment);
			accountRequest.setPaymentid(createPayment.getPaymentId());
			payments.add(payment);
		}
		logger.info("Calling Ending... LoanInteratecalculationServiceImpl::saveLoanAccounDetails");
		return accountRequest;
	}
	
	
	@Override
	public Account getLoanAccount(Integer accountId) {
		logger.info("Calling ... LoanInteratecalculationServiceImpl::getLoanAccount");
		Account accountFromDB=loanInteratecalculationRepository.getOne(accountId);
		List<Payment> loanPayments = paymentService.getLoanPaymentByAccountId(accountFromDB.getAccountId());
		accountFromDB.setPayment(loanPayments.stream().filter(pay -> null!=pay.getPaymentId()).findFirst().get());
		logger.info("Calling Ending... LoanInteratecalculationServiceImpl::getLoanAccount");
		return accountFromDB;
		
		
	}




	@Override
	public Account getLoanAccountByPaymentId(Integer paymentId) {
		return null;
	}


	@Override
	public List<Payment> getLoanAccountPaymentsByAccountId(Integer accounId) {
		
		List<Payment> payments = paymentService.getLoanPaymentByAccountId(accounId);
		
		return payments;
	}

}
