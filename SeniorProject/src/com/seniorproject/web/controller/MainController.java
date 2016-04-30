package com.seniorproject.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seniorproject.web.pojo.Activity;
import com.seniorproject.web.pojo.LoanInfo;
import com.seniorproject.web.pojo.Payment;
import com.seniorproject.web.pojo.User;
import com.seniorproject.web.pojo.Withdrawal;
import com.seniorproject.web.service.ActivityService;
import com.seniorproject.web.service.LoanInfoService;
import com.seniorproject.web.service.PaymentService;
import com.seniorproject.web.service.UserService;
import com.seniorproject.web.service.WithdrawalService;

@Controller
public class MainController extends ParentController {

	@Autowired
	private UserService userService;

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private WithdrawalService withdrawalService;
	
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private LoanInfoService loanInfoService;
	
	@RequestMapping(value = "/authenticated", method = RequestMethod.GET)
	public ModelAndView showMainPageAfterAuthentication(Principal principal) throws Exception {
		
		ModelAndView model = new ModelAndView();
		User user = userService.findUserByEmail(principal.getName());
	    activityService.logAction(user.getUserId(), "Logged In");
	    String welcome = "Welcome "+user.getFirstName()+" "+user.getLastName()+"!";
		
		model.addObject("title", SITE_TITLE);
		model.addObject("welcome", welcome);
		model.addObject("urlMap", mainPageUrls());
		model.addObject("user", user);
		model.setViewName("mainpage");
		
		return model;
	}

	@RequestMapping(value = "/loanInfo")
	public ModelAndView viewLoanInfo(Principal principal) {
		
		ModelAndView model = new ModelAndView();
		Integer userId;
		try {
			userId = userService.findUserByEmail(principal.getName()).getUserId();
		} catch (Exception e) {
			model.setViewName("login");
			model.addObject("message", LOGIN_AGAIN_MESSAGE);	
			return model;
		}
		LoanInfo loanInfo = loanInfoService.getUserLoanInfo(userId);
		model.addObject("loanInfo", loanInfo);
		model.addObject("urlMap", mainPageUrls());
		model.setViewName("loaninfo");
	
		return model;
	}

	@RequestMapping(value = "/viewPayments")
	public ModelAndView viewPayments(Principal principal) {
		
		ModelAndView model = new ModelAndView();
		Integer userId;
		
		try {
			userId = userService.findUserByEmail(principal.getName()).getUserId();
		} catch (Exception e) {
			model.setViewName("login");
		
			return model;
		}
		List<Payment> payments = paymentService.listPayments(userId);	
		model.addObject("payments", payments);
		model.addObject("urlMap", mainPageUrls());
		model.setViewName("viewpayments");
		
		return model;
	}
	
	@RequestMapping(value = "/makePayment", method = RequestMethod.GET)
	public ModelAndView showMakePaymentPage() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("payment", new Payment());
		model.setViewName("makepayment");
		model.addObject("urlMap", mainPageUrls());
		return model;
	}

	@RequestMapping(value = "/makePayment", method = RequestMethod.POST)
	public ModelAndView makePayment(@ModelAttribute("payment") Payment payment, Principal principal) {

		ModelAndView model = new ModelAndView();
		Integer userId;
		
		try {
			userId = userService.findUserByEmail(principal.getName()).getUserId();
		} catch (Exception e) {
			model.addObject("message", LOGIN_AGAIN_MESSAGE);
			model.setViewName("login");
			
			return model;
		}
		paymentService.makePayment(userId, payment);
		model.addObject("urlMap", mainPageUrls());
		model.setViewName("makepayment");
	
		return model;
	}

	@RequestMapping("/viewWithdrawals")
	public ModelAndView viewWithdrawals(Principal principal) {
		
		ModelAndView model = new ModelAndView();
		Integer userId;
		
		try {
			userId = userService.findUserByEmail(principal.getName()).getUserId();
		} catch (Exception e) {
			model.setViewName("login");
			return model;
		}
		List<Withdrawal> withdrawals = withdrawalService.listWithdrawals(userId);
		model.addObject("withdrawals", withdrawals);
		model.setViewName("viewwithdrawals");
		model.addObject("urlMap", mainPageUrls());
	
		return model;
	}

	@RequestMapping(value = "/submitWithdrawalRequest", method = RequestMethod.GET)
	public ModelAndView showSubmitWithdrawalPage() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("withdrawal", new Withdrawal());
		model.addObject("urlMap", mainPageUrls());
		model.setViewName("submitwithdrawalrequest");
		
		return model;
	}
	
	@RequestMapping(value = "/submitWithdrawalRequest", method = RequestMethod.POST)
	public ModelAndView submitWithdrawalRequest(@ModelAttribute("withdrawal") Withdrawal withdrawal, Principal principal) {

		ModelAndView model = new ModelAndView();
		Integer userId;
		
		try {
			userId = userService.findUserByEmail(principal.getName()).getUserId();
		} catch (Exception e) {
			model.setViewName("login");
			
			return model;
		}
		
		withdrawalService.submitWithdrawal(userId, withdrawal);
		model.addObject("urlMap", mainPageUrls());
		model.setViewName("submitwithdrawalrequest");
		
	
		return model;
	}
	
	@RequestMapping("/activities")
	public ModelAndView viewActivities(Principal principal) {
		
		ModelAndView model = new ModelAndView();
		Integer userId;
		
		try {
			userId = userService.findUserByEmail(principal.getName()).getUserId();
		} catch (Exception e) {
			model.setViewName("login");
			return model;
		}
		List<Activity> activities = activityService.listActivity(userId);	
		model.addObject("urlMap", mainPageUrls());
		model.addObject("activities", activities);
		model.setViewName("activities");
		return model;
	}
}
