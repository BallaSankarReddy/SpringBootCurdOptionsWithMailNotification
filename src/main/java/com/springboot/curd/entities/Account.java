package com.springboot.curd.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author cruvz
 *
 */
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3164563765358913799L;
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	
	@Column
	private String loanNumber;
	@Column
	private String accountStatus;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate nextPaymentDate;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate previusPaymentDate;
	@Column
	private BigDecimal loanAmount;
	@Column
	private Integer loanNoOfMonths;
	@Column
	private BigDecimal interestRate;
	@Column
	private BigDecimal dailyInterRate;
	@Column
	private Integer paymentid;
	@Column
	private BigDecimal payingAmount;
	private Payment payment;
	
	@Column
	private BigDecimal monthilyAmount;
	
	
	public Account() {
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
