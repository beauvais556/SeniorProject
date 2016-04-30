package com.seniorproject.web.pojo;


public class Activity {

	private Integer id  = null;
	private Integer userId = null;
	private String actionPerformed = null;
	private String date = null;
	
	
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

	public void setDate(String date) {
		
		this.date = date;
	}

	public String getDate() {
		
		return date;
	}

	public void setActionPerformed(String actionPerformed) {
		
		this.actionPerformed = actionPerformed;
	}

	public String getActionPerformed() {
		
		return actionPerformed;
	}

}