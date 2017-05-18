package com.cristiano.dao;

import org.hibernate.SessionFactory;

import com.cristiano.util.HibernateUtil;

public abstract class BaseDao {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			sessionFactory = HibernateUtil.getSessionFactory();
		}
		
		return sessionFactory;
	}
}
