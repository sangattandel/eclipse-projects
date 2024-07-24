package com.user.client.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.user.model.ContactInformation;
import com.user.client.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserContactInformationController {
	
	HttpSession session;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/contactinfo", method = RequestMethod.GET)
	public ModelAndView viewContactInfoPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("contactInfo");
		return mav;
	}
	
	@RequestMapping(value = "/contactinfo", method = RequestMethod.POST)
	public ModelAndView addContactInfo(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ContactInformation contactInfo) throws ClassNotFoundException, SQLException {
		
		ModelAndView mav = new ModelAndView();
		session = request.getSession();
		
		int userID = (int) session.getAttribute("userID");
		
		contactInfo.setId(userID);
		userService.addContactInfo(contactInfo);
		
		session.setAttribute("contactInfo", contactInfo);
		mav.setViewName("bankInfo");
		
		return mav;	
		
	}
}
