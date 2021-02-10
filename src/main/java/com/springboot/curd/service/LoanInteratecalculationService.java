package com.springboot.curd.service;

import java.util.List;

import com.springboot.curd.entities.Account;
import com.springboot.curd.entities.Payment;

public interface LoanInteratecalculationService {
	
	public Account createLoanAccount(Account account);	
	public Account getLoanAccount(Integer accounId);
	public Account getLoanAccountByPaymentId(Integer paymentId);
	public List<Payment> getLoanAccountPaymentsByAccountId(Integer accounId);
	


}
