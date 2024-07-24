package com.hibernate.user.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.user.model.PersonalInformation;
import com.hibernate.user.util.HibernateUtil;


public class PersonalInformationDAO {

	public PersonalInformation createPersonalInformation(PersonalInformation personalInformation) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			session.persist(personalInformation);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return personalInformation;
		
	}
	
	public void deletePersonalInformation(int id) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			PersonalInformation personalInformation = (PersonalInformation) session.getReference(PersonalInformation.class, id);
			
			if (personalInformation != null) {
				
				session.remove(personalInformation);
				tx.commit();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
		}
	}
	
	public void updatePersonalInformation(PersonalInformation personalInformation) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			session.merge(personalInformation);
			tx.commit();
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
		}
	}
	

	public PersonalInformation getPersonalInformation(int id) {
		
		Session session = null;
		Transaction tx = null;
		PersonalInformation personalInfo = null;
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			personalInfo = (PersonalInformation) session.getReference(PersonalInformation.class, id);
			tx.commit();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return personalInfo;
	}
}
