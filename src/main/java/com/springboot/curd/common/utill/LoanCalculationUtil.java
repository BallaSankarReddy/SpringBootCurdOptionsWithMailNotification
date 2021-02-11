package com.springboot.curd.common.utill;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
public class LoanCalculationUtil {
	
	@Value("${loan.noOfmonths.months}")
	private  String months; //12
	@Value("${loan.interestRateAmount}")
	private  String interestRateAmount; //1.5 
	
	
	public  BigDecimal getMonthliyInterestRate(BigDecimal loanAmount, BigDecimal interestRate, Integer noOfmonths) {
		
		BigDecimal divide = loanAmount.divide(new BigDecimal(100));
		BigDecimal monthalyAmount= BigDecimal.ZERO;
		
		if(interestRate.compareTo(BigDecimal.ZERO)==0 || interestRate.compareTo(new BigDecimal(interestRateAmount)) == -1) {
			
			 monthalyAmount = divide.multiply(new BigDecimal(interestRateAmount));
		}else {
			monthalyAmount =divide.multiply(interestRate);
		}
		
		BigDecimal finlAmount = monthalyAmount.multiply(new BigDecimal(noOfmonths));
		return finlAmount;
	}
	
  public BigDecimal getDaliyInterestRate(BigDecimal dueAmount, Integer noOfmonths) {
	  
	  // calculation for daily defect -30
	  
	  Integer days = noOfmonths*30;
	  
		BigDecimal dailyAmount = dueAmount.divide(new BigDecimal(days),RoundingMode.HALF_UP);
		return dailyAmount;
	}
	
	

}
