package com.seniorproject.web.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Withdrawal {
	
	private Integer id = null;
	private Integer userId = null;
	private BigDecimal amount = null;
	private String date = null;
	private String approvedBy = null;
	private String approvalStatus = null;
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
	
	public void setApprovedBy(String approvedBy) {
		
		this.approvedBy = approvedBy;
	}

	public String getApprovedBy() {
		
		return approvedBy;
	}
	
	public void setApprovalStatus(String approvalStatus) {
		
		this.approvalStatus = approvalStatus;
	}

	public String getApprovalStatus() {
		
		return approvalStatus;
	}

	public void setType(String type) {
		
		this.type = type;
	}

	public String getType() {
		
		return type;
	}
}
