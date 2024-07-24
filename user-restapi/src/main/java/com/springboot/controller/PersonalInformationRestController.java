package com.springboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.user.dao.PersonalInformationDAO;
import com.hibernate.user.model.PersonalInformation;

@RestController
@RequestMapping("/api/personalInfo")
public class PersonalInformationRestController {
	
	
	PersonalInformationDAO personalInfoDAO = new PersonalInformationDAO();
	
	
	@DeleteMapping("/delete/{id}")
	public void deletePersonalInfoByID(@PathVariable("id") int id) {
		personalInfoDAO.deletePersonalInformation(id);
		
	}
	
	@PostMapping("/add")
	public PersonalInformation addPersonalInfo(@RequestBody PersonalInformation personalInfo ) {
		
		PersonalInformation savedPersonalInfo = personalInfoDAO.createPersonalInformation(personalInfo);
		return savedPersonalInfo;
	}
	
	@PutMapping("/update/{id}")
	public void updatePersonalInfo(@PathVariable("id") int id, @RequestBody PersonalInformation personalInfo) {
		PersonalInformation existingPersonalInfo = personalInfoDAO.getPersonalInformation(id);
		if (existingPersonalInfo != null) {
			personalInfo.setId(id);
			personalInfoDAO.updatePersonalInformation(personalInfo);
		}
	}
	
	@GetMapping("/get/{id}")
	public PersonalInformation getPersonalInfoById(@PathVariable("id") int id) {
		return personalInfoDAO.getPersonalInformation(id);
	}

}
