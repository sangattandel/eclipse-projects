package com.hibernate.user.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.user.model.BankInformation;
import com.hibernate.user.util.HibernateUtil;

public class BankInformationDAO {

	public void createBankInformation(BankInformation bankInformation) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			session.persist(bankInformation);
			tx.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			
		}
	}
	
	public void deleteBankInformation(int id) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			BankInformation bankInformation = (BankInformation) session.getReference(BankInformation.class, id);
			
			if (bankInformation != null) {
				
				session.remove(bankInformation);
				tx.commit();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
		}
	}
	
	public void updateBankInformation(BankInformation bankInformation) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			session.merge(bankInformation);
			tx.commit();
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
		}
	}
	
	public BankInformation getBankInformation(int id) {
		
		Session session = null;
		Transaction tx = null;
		BankInformation bankInfo = null;
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			bankInfo = (BankInformation) session.getReference(BankInformation.class, id);
			tx.commit();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return bankInfo;
	}
	
}
