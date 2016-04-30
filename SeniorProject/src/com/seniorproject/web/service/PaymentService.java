package com.seniorproject.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seniorproject.web.dao.PaymentDAO;
import com.seniorproject.web.pojo.Payment;

@Service("paymentService")
public class PaymentService extends ParentService {
	
	@Autowired
	private PaymentDAO paymentDAO;

	public List<Payment> listPayments(Integer userId) {

		List<Payment> payments = paymentDAO.listPayments(userId);
		
		return payments;
	}
	
	public int makePayment(Integer userId, Payment payment) {
		
		payment.setUserId(userId);
		paymentDAO.savePayment(payment);
		
		return 0;
	}
}
