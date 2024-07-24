package com.user.client.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.user.model.BankInformation;
import com.user.client.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserBankInformationController {
	
	HttpSession session;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/bankinfo", method = RequestMethod.GET)
	public ModelAndView viewBankInfoPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bankInfo");
		return mav;
	}
	
	@RequestMapping(value = "/bankinfo", method = RequestMethod.POST)
	public ModelAndView addBankInfo(HttpServletRequest request, HttpServletResponse response, @ModelAttribute BankInformation bankInfo) throws ClassNotFoundException, SQLException {
		
		ModelAndView mav = new ModelAndView();
		session = request.getSession();
		
		userService.addBankInfo(bankInfo);
		
		session.setAttribute("bankInfo", bankInfo);
		mav.setViewName("successPage");
		
		return mav;
	
	}
}
