package com.seniorproject.web.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.seniorproject.web.pojo.Activity;


@Repository("activityDAO")
public class ActivityDAO extends ParentDAO {
	public ActivityDAO(){
		
	}
	
	public List<Activity> listActivities(Integer userId) {
		Session session = factory.openSession();
		 List<Activity> listOfActivities = new ArrayList<Activity>();
		try{
	         List<?> Activities = session.createQuery("FROM Activity WHERE userId=" + userId).list(); 
	         for (Iterator<?> iterator = Activities.iterator(); iterator.hasNext();){
	            Activity activity = (Activity) iterator.next(); 
	            listOfActivities.add(activity);
	         }
	 
	      }catch (HibernateException e) {
	         e.printStackTrace(); 
	      }finally {
	         session.close();
	      }
	      
	      return  listOfActivities;
		
	}
	
	public void logAction(Activity activity) {
		
		save(activity);
	}
	

}
