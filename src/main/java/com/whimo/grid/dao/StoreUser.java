/*
* Copyright (c) 2016 WhimiIndustries
* All rights reserved
* @author Devvrat Nigam
*/
package com.whimo.grid.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.whimo.grid.pojo.UserAccount;

public class StoreUser {

	public StoreUser(UserAccount ua){
		//creating session factory object  
		SessionFactory	factory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		//creating session object  
		 Session session = factory.openSession();
				
		//creating transaction object  
		 Transaction t = session.beginTransaction();
	    try{
	    session.save(ua);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    t.commit();
	    session.close();
	    
	    System.out.println("Success");
	}
}
