package com.seniorproject.web.utils;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ApplicationException() {
		
		super();
	}
	
	public ApplicationException(String message) {
		
		super(message);
	}
	
	public ApplicationException(Throwable T) {
		
		super(T);
		
	}

}
