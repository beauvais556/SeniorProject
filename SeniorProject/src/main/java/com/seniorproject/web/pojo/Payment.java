package com.seniorproject.web.pojo;

import java.math.BigDecimal;

public class Payment {

	private Integer id  = null;
	private Integer userId = null;
	private BigDecimal amount = null;
	private String date = null;
	private String type = null;
	
	
	public void setId(Integer id) {
		
		this.id = id;
	}

	public Integer getId() {
		
		return id;
	}

	public void setUserId(Integer userId) {
		
		this.userId = userId;
	}

	public Integer getUserId() {
		
		return userId;
	}

	public void setAmount(BigDecimal amount) {
		
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		
		return amount;
	}

	public void setDate(String date) {
		
		this.date = date;
	}

	public String getDate() {
		
		return date;
	}

	public void setType(String type) {
		
		this.type = type;
	}

	public String getType() {
		
		return type;
	}

}
