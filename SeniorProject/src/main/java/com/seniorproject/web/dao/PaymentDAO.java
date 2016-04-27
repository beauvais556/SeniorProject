package com.seniorproject.web.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.seniorproject.web.pojo.Payment;


@Repository("PaymentDAO")
public class PaymentDAO extends ParentDAO {
	
	public PaymentDAO() {
		
	}
		
		public List<Payment> listPayments(Integer userId) {
		      Session session = factory.openSession();
		      List<Payment> listOfpayments = new ArrayList<Payment>();
		       
		      try{
		         List<?> payments = session.createQuery("FROM Payment WHERE userId=" + userId).list(); 
		         for (Iterator<?> iterator = payments.iterator(); iterator.hasNext();){
		            Payment payment = (Payment) iterator.next(); 
		            listOfpayments.add(payment);
		         }
		 
		      }catch (HibernateException e) {
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      
		      return  listOfpayments;
		   }
		
		public Integer savePayment(Payment payment) {
		     
			  Integer paymentId = save(payment);  
		    
			  return paymentId;
		   }
		
		public void updatePayment(Integer userId, Payment updatedPayment) {
			
			update(userId, updatedPayment);
		   }
		   
		public void deletePayment(Integer paymentId) {
		      Session session = factory.openSession();
		      Transaction tx = null;
		      try{
		         tx = session.beginTransaction();
		         Payment payment = (Payment)session.get(Payment.class, paymentId); 
		         session.delete(payment); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		   }		
 
}