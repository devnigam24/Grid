/*
* Copyright (c) 2016 WhimiIndustries
* All rights reserved
* @author Devvrat Nigam
*/
package com.whimo.grid.pojo;

import java.util.Random;

public class SignUpCredentials {

	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userName;
	private String userPassword;
	private String dob;
	private String location;
	private long userID;
	private String securityQuestion;
	private String securityAnswer;
	private String charityNonProfitOfChoice;
	
	public SignUpCredentials(){
		
	}
	public SignUpCredentials(String userFirstName, String userLastName, String userEmail, String userName,
			String userPassword, String dob, String location, String securityQuestion, String securityAnswer,
			String charityNonProfitOfChoice) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassword = userPassword;
		this.dob = dob;
		this.location=location;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.charityNonProfitOfChoice = charityNonProfitOfChoice;
		this.userID = new Random().nextLong();		
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getCharityNonProfitOfChoice() {
		return charityNonProfitOfChoice;
	}

	public void setCharityNonProfitOfChoice(String charityNonProfitOfChoice) {
		this.charityNonProfitOfChoice = charityNonProfitOfChoice;
	}

}
