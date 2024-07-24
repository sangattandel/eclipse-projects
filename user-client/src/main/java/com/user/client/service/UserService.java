package com.user.client.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.hibernate.user.model.BankInformation;
import com.hibernate.user.model.ContactInformation;
import com.hibernate.user.model.PersonalInformation;

@Service
@Component
public class UserService {
	
	public static final String REST_URL="http://localhost:8090/api/";
	
	RestTemplate restTemplate = new RestTemplate();
	
	public PersonalInformation addPersonalInfo(PersonalInformation personalInfo) throws ClassNotFoundException, SQLException {
		
		List<HttpMessageConverter<?>> messageConverter = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		messageConverter.add(converter);
		restTemplate.setMessageConverters(messageConverter);
		
		PersonalInformation savedPersonalInfo = restTemplate.postForObject(REST_URL + "personalInfo/add", personalInfo, PersonalInformation.class);
		return savedPersonalInfo;
		
	}
	
	public void addContactInfo(ContactInformation contactInfo) throws ClassNotFoundException, SQLException {
		
		List<HttpMessageConverter<?>> messageConverter = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		messageConverter.add(converter);
		restTemplate.setMessageConverters(messageConverter);
		
		restTemplate.postForObject(REST_URL + "contactInfo/add", contactInfo, ContactInformation.class);
		
	}
	
	public void addBankInfo(BankInformation bankInfo) throws ClassNotFoundException, SQLException {
		
		List<HttpMessageConverter<?>> messageConverter = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		messageConverter.add(converter);
		restTemplate.setMessageConverters(messageConverter);
		restTemplate.postForObject(REST_URL + "bankInfo/add", bankInfo, BankInformation.class);
		
	}
	
	

}
