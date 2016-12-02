/*
* Copyright (c) 2016 WhimiIndustries
* All rights reserved
* @author Devvrat Nigam
*/
package com.whimo.grid.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.whimo.grid.pojo.SignUpCredentials;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class GridMongoClientDAO {
	private static final Logger logger = Logger.getLogger(ClassName.class.getName());
	private MongoDatabase db;
	
	@Value(value = "${loginDataBase}")
	private String logindataBaseName;
	
	public GridMongoClientDAO() {
		return;
	}

	protected Boolean getMongoClientForUser(MongoClient mongoClient) {
		try {
			// Now connect to your databases
			this.db = mongoClient.getDatabase(logindataBaseName);
			logger.log(Level.INFO, "Connect to " + db.getName() + " successfully");
			return Boolean.TRUE;

		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getClass().getName() + ": " + e.getMessage());
			return Boolean.FALSE;
		}
	}

	/**
	 * @param db 
	 * @param collectionName
	 */
	public void createThisUserCollection(String collectionName) {
		try {
			if (this.db != null) {
				db.createCollection(collectionName);
				logger.log(Level.INFO, "collection created " + db.getCollection(collectionName) + " Successfully");
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/**
	 * @param userName
	 * @param signupcredentials
	 */
	public void insertLoginValues(String userName, SignUpCredentials signupcredentials) {
		Document signUpDocument = new Document();
		signUpDocument.append("userName", signupcredentials.getUserName());
		signUpDocument.append("password", signupcredentials.getUserPassword());
		signUpDocument.append("emailID", signupcredentials.getUserEmail());
		db.getCollection(userName).insertOne(signUpDocument);
	}
}
