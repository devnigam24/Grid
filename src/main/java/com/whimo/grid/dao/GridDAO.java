/*
* Copyright (c) 2016 WhimiIndustries
* All rights reserved
* @author Devvrat Nigam
*/
package com.whimo.grid.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GridDAO {

	private static final Logger log = Logger.getAnonymousLogger();

	private static final ThreadLocal<Session> sessionThread = new ThreadLocal<Session>();
	@SuppressWarnings("deprecation")
	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static Session getSession() {
		Session session = (Session) GridDAO.sessionThread.get();

		if (session == null) {
			session = sessionFactory.openSession();
			GridDAO.sessionThread.set(session);
		}
		return session;
	}

	protected void getSessionBeginTransaction() {
		getSession().beginTransaction();
	}

	protected void getSessionTransactionAndCommit() {
		getSession().getTransaction().commit();
	}

	protected void rollbackTransaction() {
		try {
			getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			log.log(Level.WARNING, "Cannot rollback", e);
		}
		try {
			getSession().close();
		} catch (HibernateException e) {
			log.log(Level.WARNING, "Cannot close", e);
		}
		GridDAO.sessionThread.set(null);
	}

	public static void close() {
		getSession().close();
		GridDAO.sessionThread.set(null);
	}
}
