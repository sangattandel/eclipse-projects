package com.hibernate.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contactinfo", catalog = "training")
public class ContactInformation{
	
	private int id;
	private String address;
	private String city;
	private String state;
	private String country;
	private String phone;
	
	public ContactInformation() {
		super();
	
	}
	
	public ContactInformation(int id, String address, String city, String state, String country, String phone) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phone = phone;
	}
	
	@Column(name = "address", length = 255)
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "city", length = 255)
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "state", length = 255)
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "country", length = 255)
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name = "phone", length = 255)
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
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
