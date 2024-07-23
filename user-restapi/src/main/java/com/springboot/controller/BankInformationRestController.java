package com.springboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.user.dao.BankInformationDAO;
import com.hibernate.user.model.BankInformation;

@RestController
@RequestMapping("/api/bankInfo")
public class BankInformationRestController {

	BankInformationDAO bankInfoDAO = new BankInformationDAO();
	
	@DeleteMapping("/delete/{id}")
	public void deletePersonalInfoByID(@PathVariable("id") int id) {
		bankInfoDAO.deleteBankInformation(id);
		
	}
	
	@PostMapping("/add")
	public void addPersonalInfo(@RequestBody BankInformation bankInfo) {
		
		bankInfoDAO.createBankInformation(bankInfo);
	}
	
	@PutMapping("/update/{id}")
	public void updatePersonalInfo(@PathVariable("id") int id, @RequestBody BankInformation bankInfo) {
		BankInformation existingBankInfo = bankInfoDAO.getBankInformation(id);
		if (existingBankInfo != null) {
			bankInfo.setId(id);
			bankInfoDAO.updateBankInformation(bankInfo);
		}
	}
	
	@GetMapping("/get/{id}")
	public BankInformation getBankInfoById(@PathVariable("id") int id) {
		return bankInfoDAO.getBankInformation(id);
	}
}
