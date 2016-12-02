package com.whimo.grid.pojo;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "Account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "AccountID", unique = true, nullable = false)
	private long accountID;

	@Column(name = "EmailID", nullable = false, unique = true)
	private String emailID;

	@Column(name = "Password", nullable = false, unique = true)
	private String password;

	@Column(name = "type")
	private String type;
	
	Random randomNumberGenerator = new Random();
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserID", nullable = false, unique = true)
	private long userID;

	public Account() {
	}

	public Account(String emailID, String password) {
		this.emailID = emailID;
		this.password = password;
	}

	public long getAccountID() {
		return accountID;
	}

	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}
}
