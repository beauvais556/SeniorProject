package com.seniorproject.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.seniorproject.web.pojo.User;
import com.seniorproject.web.service.UserService;

@Controller
public class RegisterController extends ParentController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegisterPage() {

		ModelAndView model = new ModelAndView("register", "command", new User());
		
		model.addObject("urlMap", homePageUrls());
		model.addObject("title", SITE_TITLE);

		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST) public String registerUser (
            @RequestParam(value = "userId", required = true) String userId,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password", required = true) String password) throws Exception {

		userService.registerUserById(Integer.valueOf(userId), firstName, email, password);
        
        return "redirect:login";
    }

}
