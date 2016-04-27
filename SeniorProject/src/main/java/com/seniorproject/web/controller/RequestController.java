package com.seniorproject.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seniorproject.web.pojo.User;
import com.seniorproject.web.service.UserService;

@Controller
public class RequestController extends ParentController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public ModelAndView showRequestPage() {

		ModelAndView model = new ModelAndView("request", "command", new User());
		
		model.addObject("urlMap", homePageUrls());
		model.addObject("title", SITE_TITLE);
		
		return model;
	}

	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public String submitUserRequest(@ModelAttribute("request") User user, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			
			return "request";
			
		} else {
			
			userService.submitRequest(user);
			
			return "redirect:login";
		}
	}

}
