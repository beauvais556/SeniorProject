package com.seniorproject.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seniorproject.web.pojo.User;
import com.seniorproject.web.service.UserService;

@Controller
public class AdminController extends ParentController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage(Principal principal) throws Exception {

		ModelAndView model = new ModelAndView();
		String email = principal.getName();
		User user = userService.findUserByEmail(email);
		String welcome = "Welcome "+user.getFirstName()+" "+user.getLastName()+"!";

		model.addObject("title", ADMIN_TITLE);
		model.addObject(welcome);
		model.addObject("urlMap", adminPageUrls());
		model.addObject("user", user);
		model.setViewName("adminPage");

		return model;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView viewAllUsers(Principal principal) throws Exception {

		ModelAndView model = new ModelAndView();
		Integer adminId;

		try {
			adminId = userService.findUserByEmail(principal.getName())
					.getUserId();
		} catch (Exception e) {
			model.setViewName("login");
			return model;
		}
		List<User> users = userService.getUsers();
		
		model.addObject("title", ADMIN_TITLE);
		model.addObject("urlMap", adminPageUrls());
		model.addObject("users", users);
		model.setViewName("users");
		return model;
	}

	@RequestMapping(value = "/pendingRequests", method = RequestMethod.GET)
	public ModelAndView viewPendingRequets(Principal principal) throws Exception {

		ModelAndView model = new ModelAndView();
		Integer adminId;

		try {
			adminId = userService.findUserByEmail(principal.getName())
					.getUserId();
		} catch (Exception e) {
			model.setViewName("login");
			return model;
		}
		List<User> pendingUsers = userService.getPendingUsers();
		
		model.addObject("title", ADMIN_TITLE);
		model.addObject("urlMap", adminPageUrls());
		model.addObject("pendingUsers", pendingUsers);
		model.setViewName("pendingRequests");
		return model;
	}
	
	@RequestMapping(value = "/activeUsers", method = RequestMethod.GET)
	public ModelAndView viewActiveUsers(Principal principal) throws Exception {

		ModelAndView model = new ModelAndView();
		Integer adminId;

		try {
			adminId = userService.findUserByEmail(principal.getName())
					.getUserId();
		} catch (Exception e) {
			model.setViewName("login");
			return model;
		}
		List<User> activeUsers = userService.getActiveUsers();
		
		model.addObject("title", ADMIN_TITLE);
		model.addObject("urlMap", adminPageUrls());
		model.addObject("activeUsers", activeUsers);
		model.setViewName("activeUsers");
		return model;
	}
	
	@RequestMapping(value = "/disabledUsers", method = RequestMethod.GET)
	public ModelAndView viewDisabledUsers(Principal principal) throws Exception {

		ModelAndView model = new ModelAndView();
		Integer adminId;

		try {
			adminId = userService.findUserByEmail(principal.getName())
					.getUserId();
		} catch (Exception e) {
			model.setViewName("login");
			return model;
		}
		List<User> disabledUsers = userService.getDisabledUsers();
		
		model.addObject("title", ADMIN_TITLE);
		model.addObject("urlMap", adminPageUrls());
		model.addObject("disabledUsers", disabledUsers);
		model.setViewName("disabledUsers");
		return model;
	}

	@RequestMapping("/approve/{userId}")
	public String approveUser(@PathVariable("userId") Integer userId) throws Exception {

		userService.approveUser(userId);
		
		return "redirect:/admin";
	}

	
	@RequestMapping("/reject/{userId}")
	public String rejectUser(@PathVariable("userId") Integer userId) throws Exception {

		userService.rejectUser(userId);
		
		return "redirect:/admin";
	}
	
	@RequestMapping("/enable/{userId}")
	public String enableUser(@PathVariable("userId") Integer userId) throws Exception {

		userService.enableUser(userId);
		
		return "redirect:/admin";
	}
	
	@RequestMapping("/disable/{userId}")
	public String disableUser(@PathVariable("userId") Integer userId) throws Exception {

		userService.disableUser(userId);
		
		return "redirect:/admin";
	}

}
