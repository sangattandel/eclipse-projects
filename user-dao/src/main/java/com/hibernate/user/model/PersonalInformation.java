package com.hibernate.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personalinfo", catalog = "training")
public class PersonalInformation{
	
	private int id;
	private String firstname;
	private String lastname;
	private String middlename;
	private String gender;
	
	
	public PersonalInformation() {
		super();
	
	}

	public PersonalInformation(String firstName, String lastName, String middleName, String gender) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
		this.middlename = middleName;
		this.gender = gender;
	}
	
	@Column(name = "firstname", length = 255)
	public String getFirstName() {
		return firstname;
	}
	
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}
	
	@Column(name = "lastname", length = 255)
	public String getLastName() {
		return lastname;
	}
	
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}
	
	@Column(name = "middlename", length = 255)
	public String getMiddleName() {
		return middlename;
	}
	
	public void setMiddleName(String middleName) {
		this.middlename = middleName;
	}
	
	@Column(name = "gender", length = 255)
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
