package com.seniorproject.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seniorproject.web.dao.LoanInfoDAO;
import com.seniorproject.web.pojo.LoanInfo;


@Service("loanInfoService")
public class LoanInfoService extends ParentService {
	
	@Autowired
	private LoanInfoDAO loanInfoDAO; 
	
	public LoanInfo getUserLoanInfo(Integer userId) {
		
		return loanInfoDAO.getUserLoanInfo(userId);
	}
	
}
