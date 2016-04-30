package com.seniorproject.web.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.seniorproject.web.pojo.User;
import com.seniorproject.web.pojo.Withdrawal;

@Repository("WithdrawalDAO")
public class WithdrawalDAO extends ParentDAO{
	
		public WithdrawalDAO() {
			
		}

		public List<Withdrawal> listWithdrawals(Integer userId){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      List<Withdrawal> listOfWithdrawals = new ArrayList<Withdrawal>();
		       
		      try{
		         tx = session.beginTransaction();
		         List<?> withdrawals = session.createQuery("FROM Withdrawal WHERE userId="+ userId).list(); 
		         for (Iterator<?> iterator = withdrawals.iterator(); iterator.hasNext();){
		            Withdrawal withdrawal = (Withdrawal) iterator.next(); 
		            listOfWithdrawals.add(withdrawal);
		         }
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      
		      return  listOfWithdrawals;
		   }
		
		public Integer saveWithdrawal(Withdrawal withdrawal) {
		      
			Integer id = save(withdrawal);
			return id;
	   }
	
		public void updateWithdrawal(Integer userId, Withdrawal updatedWithdrawal) {

			update(userId, updatedWithdrawal);
	   }

}
