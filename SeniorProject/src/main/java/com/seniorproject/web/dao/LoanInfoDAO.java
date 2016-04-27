package com.seniorproject.web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.seniorproject.web.pojo.LoanInfo;

@Repository("loanInfoDao")
public class LoanInfoDAO extends ParentDAO {
	
	public Integer saveUserLoanInfo(LoanInfo loanInfo) {
	      
		Integer id = save(loanInfo);
		return id;
   }
	
	public LoanInfo getUserLoanInfo(Integer userId) {
			
		return (LoanInfo) findFromTableByField( "LoanInfo","userId", userId).get(0);		
	}

	public void updateUserLoanInfo(LoanInfo updatedLoanInfo) {
		
		Integer userId = null;	
		update(userId, updatedLoanInfo);
   }
   
	public void deleteUserLoanInfo(Integer userId) {
	      Session session = factory.openSession();
	      
	      Transaction tx = null;
	      
	      try{
	      
	    	  tx = session.beginTransaction();
	         
	    	  LoanInfo loanInfo = (LoanInfo)session.get(LoanInfo.class, userId); 
	         
	    	  session.delete(loanInfo); 
	         
	    	  tx.commit();
	      }catch (HibernateException e) {
	       
	    	  if (tx!=null) tx.rollback();
	         
	    	  e.printStackTrace(); 
	      }finally {
	       
	    	  session.close(); 
	      }
	 }
}
