package com.seniorproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends ParentController {

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("urlMap", homePageUrls());
		model.addObject("title", SITE_TITLE);
		
		model.setViewName("index");
		
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("authenticationError", AUTHENTICATION_ERROR_MESSAGE);
		}

		if (logout != null) {
			model.addObject("message", LOGOUT_SUCCESS_MESSAGE);
		}
	
		model.addObject("urlMap", homePageUrls());
		model.addObject("title", SITE_TITLE);
		model.setViewName("login");

		return model;
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String Admin(){
		
		return "redirect:admin";
	}

}