package com.seniorproject.web.controller;

import java.util.HashMap;
import java.util.Map;

import com.seniorproject.web.utils.Constants;

public class ParentController extends Constants {

	protected Map<String, String> homePageUrls() {

		Map<String, String> urlMap = new HashMap<String, String>();
		urlMap.put("Home", "home");
		urlMap.put("Login", "login");
		urlMap.put("Register", "register");
		urlMap.put("Request", "request");

		return urlMap;
	}
	
	protected Map<String, String> mainPageUrls() {
		
		Map<String, String> urlMap = new HashMap<String, String>();
		urlMap.put("About Us","#");
		urlMap.put("Profile","#");
		urlMap.put("Contact Us","#");
		urlMap.put("Help","#");
		urlMap.put("Logout","javascript:logOut()");
		
		return urlMap;
	}
	
	protected Map<String, String> adminPageUrls() {
	
		Map<String, String> urlMap = new HashMap<String, String>();
		urlMap.put("About Us","#");
		urlMap.put("Profile","#");
		urlMap.put("Contact Us","#");
		urlMap.put("Help","#");
		urlMap.put("Logout","javascript:logOut()");
		
		return urlMap;
	}
}
