package com.seniorproject.web.utils;

import com.seniorproject.web.pojo.User.Status;

public class Constants {

	public static final String SITE_TITLE = "Computerized Cash Advance System";
	public static final String ADMIN_TITLE = "Administrator's Console";
	public static final String ADMIN_SITE_TITLE = "Administrator's Panel";
	public static final String LOGIN_AGAIN_MESSAGE = "Please login again";
	public static final String AUTHENTICATION_ERROR_MESSAGE = "Invalid username and password!";
	public static final String LOGOUT_SUCCESS_MESSAGE = "You've been logged out successfully.";
	public static final String UNABLE_TO_REGISTER = "You are unable to register at this time";
	
	public static final String GMAIL_HOST = "smtp.gmail.com";
	public static final String GMAIL_HOST_PORT = "587";
	public static final String OUTGOING_EMAIL_ADDRESS = "from-beauvais556@gmail.com";
	public static final String OUTGOING_EMAIL_ACCT_USERNAME = "beauvais556@gmail.com";
	public static final String OUTGOING_EMAIL_ACCT_PASSWORD = "c8811491";
	
	public static final String DECISION_EMAIL_SUBJECT = "Regarding your recent loan request";

	public static final String USER = "ROLE_USER";
	public static final String ADMIN = "ROLE_ADMIN";
	
	public static final int SUCCEEDED = 1, ENABLED = 1;
	public static final int FAILED = 0, DISABLED = 0;
	
	public static final Status  REJECTED = Status.REJECTED;
	public static final Status  APPROVED = Status.APPROVED;
	public static final Status  PENDING = Status.PENDING;
	
	public static final double INTEREST_RATE = 2.5;
	public static final int DUE_DAY = 26;

}
