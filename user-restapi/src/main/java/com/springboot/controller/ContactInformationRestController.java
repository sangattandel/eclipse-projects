package com.springboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.user.dao.ContactInformationDAO;
import com.hibernate.user.model.ContactInformation;

@RestController
@RequestMapping("/api/contactInfo")
public class ContactInformationRestController {
	
	ContactInformationDAO contactInfoDAO = new ContactInformationDAO();
	
	@DeleteMapping("/delete/{id}")
	public void deletePersonalInfoByID(@PathVariable("id") int id) {
		contactInfoDAO.deleteContactInformation(id);
		
	}
	
	@PostMapping("/add")
	public void addPersonalInfo(@RequestBody ContactInformation contactInfo ) {
		
		contactInfoDAO.createContactInformation(contactInfo);
	}
	
	@PutMapping("/update/{id}")
	public void updatePersonalInfo(@PathVariable("id") int id, @RequestBody ContactInformation contactInfo) {
		ContactInformation existingContactInfo = contactInfoDAO.getContactInformation(id);
		if (existingContactInfo != null) {
			contactInfo.setId(id);
			contactInfoDAO.updateContactInformation(contactInfo);
		}
	}
	
	@GetMapping("/get/{id}")
	public ContactInformation getContactInfoById(@PathVariable("id") int id) {
		return contactInfoDAO.getContactInformation(id);
	}

}
