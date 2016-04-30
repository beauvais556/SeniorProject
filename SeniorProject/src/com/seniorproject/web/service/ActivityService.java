package com.seniorproject.web.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seniorproject.web.dao.ActivityDAO;
import com.seniorproject.web.pojo.Activity;

@Service("activityService")
public class ActivityService extends ParentService {

	@Autowired
	private ActivityDAO activityDAO;

	public List<Activity> listActivity(Integer userId) {
		List<Activity> activities = activityDAO.listActivities(userId);

		return activities;
	}
	
	public void logAction(Integer userId, String action) {
		
		Activity activity= new Activity();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		activity.setActionPerformed(action);
	    activity.setUserId(userId);
	    activity.setDate(dateFormat.format(cal.getTime()).toString());
	    activityDAO.logAction(activity);
	}
}
