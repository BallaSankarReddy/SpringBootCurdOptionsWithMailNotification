package com.springboot.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.curd.entities.Payment;
import com.springboot.curd.service.PaymentService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Loan Payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/payment/save")
	public Payment savePayment(Payment payment) {
		
		return paymentService.createPayment(payment);
	}
	
	@GetMapping("/payment/({paymentId}")
	public Payment getPayment(@PathVariable("paymentId") Integer paymentId) {
		
		return paymentService.getLoanPayment(paymentId);
	}
	
	@GetMapping("/payment/{accountId}")
	public List<Payment> getPaymentsByAccount(@PathVariable("accountId") Integer accountId) {
		
		return paymentService.getLoanPaymentByAccountId(accountId);
	}
}
