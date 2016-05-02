package com.seniorproject.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.seniorproject.web.utils.Constants;

public class ParentDAO extends Constants {
	
	Configuration configuration = new Configuration().configure();
	
	ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
	
	SessionFactory factory = configuration.buildSessionFactory(builder.buildServiceRegistry());
	
	
	protected Integer save(Object object) {
	      
		Session session = factory.openSession();
		
		Transaction tx = null;
		
		Integer id = null;
	    
		try {
	  	  	
			tx = session.beginTransaction();
	  	  	
			id = (Integer) session.save(object);
	  	  	
			tx.commit();
			
	      }	catch (HibernateException e) {
	      		
	    	if (tx!=null) {
	    		
	    		tx.rollback();
	    	}
	        
	    	e.printStackTrace(); 
	      
	      } finally {
	    	  
	    	  session.close(); 
	      }
	      
	      return id;
	   }

	
	protected void update(Integer id, Object updatedObject) {
		
	      Session session = factory.openSession();
	      
	      Transaction tx = null;
	      
	      try {
	    	  
	         tx = session.beginTransaction();
	         
			 session.update(updatedObject);
			 
	         tx.commit();
	         
	      } catch (HibernateException e) {
	    	  
	         if (tx!=null) {
	        	 
	        	 tx.rollback();
	         }
	         
	         e.printStackTrace(); 
	         
	      } finally {
	         
	    	 session.close(); 
	      }
	}	
	
	
	protected List<?> findFromTableByField(String tableName, String fieldName, Object value) {

	      String query = "FROM "+ tableName +" where "+ fieldName +"=?";
	      
		  Session session = factory.openSession();
	 
	      List<?> rows = new ArrayList<Object>();
	       
	      try {
	        
	         rows = session.createQuery(query).setParameter(0, value).list(); 
	        
	      } catch (HibernateException e) {
	         
	    	  e.printStackTrace();
	         
	      } finally {
	    	  
	         session.close(); 
	      }
	      
		if (rows.size() > 0) {
			
			return rows;
			
		} else {
			
			return null;
		}

	}
	
}
