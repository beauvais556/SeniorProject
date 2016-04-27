package com.seniorproject.web.pojo;

import java.math.BigDecimal;

public class User {
	
	private Integer userId;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	private String employer;
	private BigDecimal salary;
	private BigDecimal requestedAmt;
	private String dob;
	private String ssn;
	private String password;
	private String role;
	private boolean enabled;
	private Status status;
	
	public enum Status {
		
		APPROVED, REJECTED, PENDING	
		
	};

	public void setUserId(Integer userId) {
		
		this.userId = userId;
	}

	public Integer getUserId() {
		
		return userId;
	}

	public String getFirstName() {
		
		return firstName;
	}

	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}

	public String getLastName() {
		
		return lastName;
	}

	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	}

	public String getAddress() {
		
		return address;
	}

	public void setAddress(String address) {
		
		this.address = address;
	}

	public String getPhone() {
		
		return phone;
	}

	public void setPhone(String phone) {
		
		this.phone = phone;
	}

	public String getEmail() {
		
		return email;
	}

	public void setEmail(String email) {
		
		this.email = email;
	}

	public String getEmployer() {
		
		return employer;
	}

	public void setEmployer(String employer) {
		
		this.employer = employer;
	}

	public BigDecimal getSalary() {
		
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		
		this.salary = salary;
	}

	public BigDecimal getRequestedAmt() {
		
		return requestedAmt;
	}

	public void setRequestedAmt(BigDecimal requestedAmt) {
		
		this.requestedAmt = requestedAmt;
	}

	public String getDob() {
		
		return dob;
	}

	public void setDob(String dob) {
		
		this.dob = dob;
	}

	public String getSsn() {
		
		return ssn;
	}

	public void setSsn(String ssn) {
		
		this.ssn = ssn;
	}

	public void setPassword(String password) {
		
		this.password = password;
	}

	public String getPassword() {
		
		return password;
	}
	
   public void setRole(String role) {
		
		this.role = role;
	}

	public String getRole() {
		
		return role;
	}

	public void setEnabled(boolean enabled) {
		
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		
		return enabled;
	}

	public void setStatus(Status status) {
		
		this.status = status;
	}

	public Status getStatus() {
		
		return status;
	}

}
