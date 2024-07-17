package com.hibernate.webapp.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.webapp.model.User;
import com.hibernate.webapp.util.HibernateUtil;

public class UserDAO {

	public void addUser(User user) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateUtil.getInstance().getSession();
			tx = session.beginTransaction();
			session.persist(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
