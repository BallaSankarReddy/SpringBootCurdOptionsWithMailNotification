package com.springboot.curd.service;

import java.util.List;

import com.springboot.curd.entities.Payment;

public interface PaymentService {
	public Payment createPayment(Payment payment);
	public Payment getLoanPayment(Integer paymentId);
	public List<Payment> getLoanPaymentByPaymentId(Integer paymentId);
}
