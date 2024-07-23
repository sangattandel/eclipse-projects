package com.hibernate.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bankinfo", catalog = "training")
public class BankInformation {
	
	private int id;
	private String bankName;
	private String accountNumber;
	private String ssn;
	
	public BankInformation() {
		super();
	
	}
	
	public BankInformation(int id, String bankName, String accountNumber, String ssn) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.ssn = ssn;
	}
	
	@Column(name = "bankname", length = 255)
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Column(name = "accountnumber", length = 255)
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Column(name = "ssn", length = 255)
	public String getSsn() {
		return ssn;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	@Id
	@Column(name="id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
