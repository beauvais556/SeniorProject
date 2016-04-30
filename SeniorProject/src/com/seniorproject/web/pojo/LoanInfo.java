package com.seniorproject.web.pojo;

import java.math.BigDecimal;

public class LoanInfo {
	
	private Integer id  = null;
	private Integer userId;
	private BigDecimal creditLimit;
	private BigDecimal availableAmt;
	private double interestRate;
	private int paymentDueDay;
	
	public void setId(Integer id) {
		
		this.id = id;
	}

	public Integer getId() {
		
		return id;
	}
	
	public Integer getUserId() {
		
		return userId;
	}
	
	public void setUserId(Integer userId) {
		
		this.userId = userId;
	}
	
	public BigDecimal getCreditLimit() {
		
		return creditLimit;
	}
	
	public void setCreditLimit(BigDecimal creditLimit) {
		
		this.creditLimit = creditLimit;
	}
	
	public BigDecimal getAvailableAmt() {
		
		return availableAmt;
	}
	
	public void setAvailableAmt(BigDecimal availableAmt) {
		
		this.availableAmt = availableAmt;
	}
	
	public double getInterestRate() {
		
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		
		this.interestRate = interestRate;
	}
	
	public int getPaymentDueDay() {
		
		return paymentDueDay;
	}
	
	public void setPaymentDueDay(int paymentDueDay) {
		
		this.paymentDueDay = paymentDueDay;
	}

}
