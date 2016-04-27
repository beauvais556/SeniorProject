package com.seniorproject.web.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.seniorproject.web.pojo.User;

@Repository("userDAO")
public class UserDAO extends ParentDAO {
	
	
	public UserDAO() {
		
	}

	public List<User> listUsers() {
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<User> listOfUsers = new ArrayList<User>();
	       
	      try{
	         tx = session.beginTransaction();
	         List<?> users = session.createQuery("FROM User").list(); 
	         for (Iterator<?> iterator = users.iterator(); iterator.hasNext();){
	            User user = (User) iterator.next(); 
	            listOfUsers.add(user);
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      
	      return listOfUsers;
	   }
	
	public Integer saveUser(User user) {
	      
		Integer id = save(user);
		
		return id;
	   }
	
	public void updateUser(Integer userId, User updatedUser) {
		
		update(userId, updatedUser);
	   }
	   
	public void deleteUser(Integer userId) {
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         User user = (User)session.get(User.class, userId); 
	         session.delete(user); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	
	public User findUserByEmail(String email) { 
		
		User user = (User) findFromTableByField("User", "email", email).get(0) ;
		
		return user;
	}
	
	public User findUserById(Integer userId) {
		
		User userid = (User) findFromTableByField("User", "userId", userId).get(0);
		
		return userid;
	}
	
	public List<User> getPendingUsers() {
		
		return (List<User>) findFromTableByField("User", "status", PENDING);
		
	}

	public List<User> getActiveUsers() {
		
		return (List<User>) findFromTableByField("User", "enabled", true);
	}

	public List<User> getDisabledUsers() {
		
		return (List<User>) findFromTableByField("User", "enabled", false);
	}
}
