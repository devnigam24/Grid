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

public class MongoDAO extends GridMongoClientDAO {
	private static final Logger logger = Logger.getLogger(ClassName.class.getName());
	private MongoClient mongoClient;
	private MongoDatabase db;

	@Value(value = "${serverName}")
	private String serverName;
	@Value(value = "${portNumber}")
	private int portNumber;
	@Value(value = "${SignUpdataBase}")
	private String signUpdatabaseName;
	
	public MongoDAO() {

	}

	public Boolean getMongoClient() {
		try {
			// To connect to mongodb server
			this.mongoClient = new MongoClient(serverName, portNumber);
			logger.log(Level.INFO, "Connect to " + this.mongoClient.getClass() + " successfully");

			if (super.getMongoClientForUser(mongoClient)) {
				// Now connect to your databases
				this.db = mongoClient.getDatabase(signUpdatabaseName);
				logger.log(Level.INFO, "Connect to " + db.getName() + " successfully");
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getClass().getName() + ": " + e.getMessage());
			return Boolean.FALSE;
		}
	}

	public void createThisUserCollection(String CollectionName) {
		try {
			if (this.db != null) {
				db.createCollection(CollectionName);
				logger.log(Level.INFO, "collection created " + db.getCollection(CollectionName) + " Successfully");
			}
			super.createThisUserCollection(CollectionName);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/**
	 * @param userEmail
	 * @param signupcredentials
	 */
	public void insertValues(String userName, SignUpCredentials signupcredentials) {
		Document signUpDocument = new Document();
		signUpDocument.append("firstName", signupcredentials.getUserFirstName());
		signUpDocument.append("lastNAme", signupcredentials.getUserLastName());
		signUpDocument.append("emailID", signupcredentials.getUserEmail());
		signUpDocument.append("userName", signupcredentials.getUserName());
		signUpDocument.append("dob", signupcredentials.getDob());
		signUpDocument.append("location", signupcredentials.getLocation());
		signUpDocument.append("securityQuestion", signupcredentials.getSecurityQuestion());
		signUpDocument.append("securityAnswer", signupcredentials.getSecurityAnswer());
		signUpDocument.append("charityNonProfitOfChoice", signupcredentials.getCharityNonProfitOfChoice());
		db.getCollection(userName).insertOne(signUpDocument);
		super.insertLoginValues(userName, signupcredentials);
	}
}
