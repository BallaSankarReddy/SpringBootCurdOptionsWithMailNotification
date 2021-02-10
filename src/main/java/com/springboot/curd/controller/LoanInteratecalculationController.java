package com.springboot.curd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.curd.entities.Account;
import com.springboot.curd.service.LoanInteratecalculationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value ="Loan Interate Calcultion " )
public class LoanInteratecalculationController {

	@Autowired
	private LoanInteratecalculationService interatecalculationService;
	
	@ApiOperation(value ="Save loan account")
	@PostMapping("/save")
	public Account saveAccount(@RequestBody Account account) {
		return interatecalculationService.createLoanAccount(account);
	}
	@ApiOperation(value ="get loan account")
	@PostMapping("/account/{accountId}")
	public Account getAccount(@PathVariable("accountId") Integer accountId) {
		return interatecalculationService.getLoanAccount(accountId);
	}
}
