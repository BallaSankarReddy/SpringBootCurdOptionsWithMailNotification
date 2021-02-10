package com.springboot.curd.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pay_1")
public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2261923924360820726L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	@Column
	private String paymentType;
	@Column
	private BigDecimal paymentAmount;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate paymentDate;
	@Column
	private Integer accountId;
	
	
	public Integer getAccountId() {
		return accountId;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

}
