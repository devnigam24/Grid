package com.whimo.grid.pojo;

import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserAccount")
public class UserAccount extends Account {

	@Column(name = "FirstName", nullable = false, unique = false)
	private String firstName;

	@Column(name = "LastName", nullable = false, unique = false)
	private String lastName;

	@Column(name = "EmailID", nullable = false, unique = true)
	private String emailID;

	@Column(name = "UserName", nullable = false, unique = true)
	private String userName;

	@Column(name = "DOB", nullable = false, unique = false)
	private String dob;

	@Column(name = "Location", nullable = false, unique = false)
	private String location;
	
	@Column(name = "UserID", nullable = false, unique = false)
	private Long userID;

	@Column(name = "SecurityQuestion", nullable = false, unique = false)
	private String securityQuestion;
	
	@Column(name = "SecurityAnswer", nullable = false, unique = false)
	private String securityAnswer;
	
	@Column(name = "CharityNonProfitOfChoice", nullable = false, unique = false)
	private String charityNonProfitOfChoice;
	
	public UserAccount(String firstName, String lastName, String emailID, String userName, Long userID, String password, String dob,
			String location, String securityQuestion, String securityAnswer, String charityNonProfitOfChoice) {
		super(emailID, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID=emailID;
		this.userName=userName;
		this.userID=userID;
		this.dob = dob;
		this.location = location;
		this.securityQuestion=securityQuestion;
		this.securityAnswer=securityAnswer;
		this.charityNonProfitOfChoice=charityNonProfitOfChoice;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Random getRandomNumberGenerator() {
		return randomNumberGenerator;
	}

	public void setRandomNumberGenerator(Random randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}
	
	/**
	 * @return the userID
	 */
	public long getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Long userID) {
		this.userID = userID;
	}

	/**
	 * @return the securityQuestion
	 */
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	/**
	 * @param securityQuestion the securityQuestion to set
	 */
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	/**
	 * @return the securityAnswer
	 */
	public String getSecurityAnswer() {
		return securityAnswer;
	}

	/**
	 * @param securityAnswer the securityAnswer to set
	 */
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	/**
	 * @return the charityNonProfitOfChoice
	 */
	public String getCharityNonProfitOfChoice() {
		return charityNonProfitOfChoice;
	}

	/**
	 * @param charityNonProfitOfChoice the charityNonProfitOfChoice to set
	 */
	public void setCharityNonProfitOfChoice(String charityNonProfitOfChoice) {
		this.charityNonProfitOfChoice = charityNonProfitOfChoice;
	}
}
