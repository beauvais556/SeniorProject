package com.seniorproject.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.seniorproject.web.dao.LoanInfoDAO;
import com.seniorproject.web.dao.UserDAO;
import com.seniorproject.web.pojo.LoanInfo;
import com.seniorproject.web.pojo.User;
import com.seniorproject.web.utils.ApplicationException;

@Service("userService")
public class UserService extends ParentService {
   
	@Autowired 
    private LoanInfoDAO loanInfoDAO;
   
	@Autowired
	private UserDAO userDAO;

	public void registerUserById(Integer userId, String name, String email, String password) throws Exception {

		User user = userDAO.findUserById(userId);

		if (user.isEnabled()) {
			
			if (user.getStatus() == REJECTED) {

				throw new ApplicationException(UNABLE_TO_REGISTER);
			}

			if (user.getStatus() == PENDING) {

				throw new ApplicationException(UNABLE_TO_REGISTER);
			}

			if (user.getStatus() == APPROVED) {

				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

				String encodedPassword = passwordEncoder.encode(password);

				user.setPassword(encodedPassword);

				userDAO.updateUser(userId, user);
			}
		}
	}
	
	public void createUser(User user) {

		userDAO.saveUser(user);
	}

	public void submitRequest(User user) throws Exception {

		user.setRole(USER);

		user.setStatus(PENDING);

		userDAO.saveUser(user);
	}

	public User findUserByEmail(String email) throws Exception {

		return userDAO.findUserByEmail(email);
	}
	
	public User findUserById(Integer userId) throws Exception {

		return userDAO.findUserById(userId);
	}

	public void approveUser(Integer userId) throws Exception {
		
		LoanInfo loanInfo = new LoanInfo();
		
		User user = userDAO.findUserById(userId);
		
		user.setEnabled(true);
		
		user.setStatus(APPROVED);
		
		loanInfo.setUserId(userId);
		
		loanInfo.setAvailableAmt(user.getRequestedAmt());
		
		loanInfo.setCreditLimit(user.getRequestedAmt());
		
		loanInfo.setInterestRate(INTEREST_RATE);
		
		loanInfo.setPaymentDueDay(DUE_DAY);
		
		loanInfoDAO.saveUserLoanInfo(loanInfo);
		
		userDAO.updateUser(userId, user);
		
		sendDecisionEmail(user.getEmail(), user.getStatus(), loanInfo.getCreditLimit());
	}
	
	public void rejectUser(Integer userId) throws Exception {
		
		User user =userDAO.findUserById(userId);
		
		user.setStatus(REJECTED);
		
		userDAO.updateUser(userId, user);
		
		sendDecisionEmail(user.getEmail(), user.getStatus());
	}
	
	public void enableUser(Integer userId) throws Exception {
		
		User user =userDAO.findUserById(userId);
		
		user.setEnabled(true);
		
		userDAO.updateUser(userId, user);
	}
	
	public void disableUser(Integer userId) throws Exception {
		
		User user =userDAO.findUserById(userId);
		
		user.setEnabled(false);
		
		userDAO.updateUser(userId, user);
	}
		
	
	public List<User> getPendingUsers() throws Exception {
		
		return userDAO.getPendingUsers();	
	}
	
	public List<User> getActiveUsers() throws Exception {
		
		return userDAO.getActiveUsers();
	}
	
	public List<User> getDisabledUsers() throws Exception {
		
		return userDAO.getDisabledUsers();
	}

	public List<User> getUsers() {
		
		return userDAO.listUsers();
	}
}
