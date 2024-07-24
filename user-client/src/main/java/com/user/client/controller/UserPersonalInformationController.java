package com.user.client.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.client.service.UserService;
import com.hibernate.user.model.PersonalInformation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserPersonalInformationController {
	
	HttpSession session;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/personalinfo", method = RequestMethod.GET)
	public ModelAndView viewPersonalInfoPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("personalInfo");
		return mav;
	}
	
	@RequestMapping(value = "/personalinfo", method = RequestMethod.POST, produces = "application/json")
	public ModelAndView addPersonalInfo(HttpServletRequest request, HttpServletResponse response, @ModelAttribute PersonalInformation personalInfo) throws ClassNotFoundException, SQLException {
		
		ModelAndView mav = new ModelAndView();
		session = request.getSession();
			
		PersonalInformation addPersonalInfo = userService.addPersonalInfo(personalInfo);
		session.setAttribute("userID", addPersonalInfo.getId());
		System.out.println(addPersonalInfo.getId());
		session.setAttribute("personalInfo", addPersonalInfo);
				
		mav.setViewName("contactInfo");
		return mav;
		
	}

}
