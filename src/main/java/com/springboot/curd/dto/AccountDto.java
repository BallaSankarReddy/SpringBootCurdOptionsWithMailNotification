package com.springboot.curd.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.curd.entities.Payment;

/**
 * @author cruvz
 *
 */
public class AccountDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3164563765358913799L;
	
	private Integer accountId;
	
	private String loanNumber;
	private String accountStatus;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate nextPaymentDate;
	private LocalDate previusPaymentDate;
	private BigDecimal loanAmount;
	private Integer loanNoOfMonths;
	private BigDecimal interestRate;
	private BigDecimal dailyInterRate;
	private Integer paymentid;
	private BigDecimal payingAmount;
	
	private Payment payment;
	private List<Payment> payments;
	
	
	
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public BigDecimal getPayingAmount() {
		return payingAmount;
	}
	public void setPayingAmount(BigDecimal payingAmount) {
		this.payingAmount = payingAmount;
	}
	public Integer getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(Integer paymentid) {
		this.paymentid = paymentid;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getLoanNumber() {
		return loanNumber;
	}
	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public LocalDate getNextPaymentDate() {
		return nextPaymentDate;
	}
	public void setNextPaymentDate(LocalDate nextPaymentDate) {
		this.nextPaymentDate = nextPaymentDate;
	}
	public LocalDate getPreviusPaymentDate() {
		return previusPaymentDate;
	}
	public void setPreviusPaymentDate(LocalDate previusPaymentDate) {
		this.previusPaymentDate = previusPaymentDate;
	}
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Integer getLoanNoOfMonths() {
		return loanNoOfMonths;
	}
	public void setLoanNoOfMonths(Integer loanNoOfMonths) {
		this.loanNoOfMonths = loanNoOfMonths;
	}
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	public BigDecimal getDailyInterRate() {
		return dailyInterRate;
	}
	public void setDailyInterRate(BigDecimal dailyInterRate) {
		this.dailyInterRate = dailyInterRate;
	}
	

}
