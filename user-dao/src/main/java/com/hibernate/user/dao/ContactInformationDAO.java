package com.hibernate.user.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.user.model.ContactInformation;
import com.hibernate.user.util.HibernateUtil;

public class ContactInformationDAO {
	
	public void createContactInformation(ContactInformation contactInformation) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			session.persist(contactInformation);
			tx.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
		}
	}
	
	public void deleteContactInformation(int id) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			ContactInformation contactInformation = (ContactInformation) session.getReference(ContactInformation.class, id);
			
			if (contactInformation != null) {
				
				session.remove(contactInformation);
				tx.commit();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
		}
	}
	
	public void updateContactInformation(ContactInformation contactInformation) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			session.merge(contactInformation);
			tx.commit();
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
		}
	}
	
	public ContactInformation getContactInformation(int id) {
		
		Session session = null;
		Transaction tx = null;
		ContactInformation contactInfo = null;
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			contactInfo = (ContactInformation) session.getReference(ContactInformation.class, id);
			tx.commit();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return contactInfo;
	}
	
}
