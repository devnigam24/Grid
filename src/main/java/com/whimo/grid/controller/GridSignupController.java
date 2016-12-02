/*
* Copyright (c) 2016 WhimiIndustries
* All rights reserved
* @author Devvrat Nigam
*/
package com.whimo.grid.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.whimo.grid.dao.MongoDAO;
import com.whimo.grid.interaces.GridValidator;
import com.whimo.grid.pojo.SignUpCredentials;
import com.whimo.grid.pojo.UserAccount;
import com.whimo.grid.validator.SignUpPageValidator;

public class GridSignupController implements GridValidator{
	@Autowired
	@Qualifier("signUpFormValidator")
	private SignUpPageValidator formValidator;
	/*
	 * 
	 */
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(formValidator);
	}

	/**
	 * @param firstName
	 * @param lastNAme
	 * @return 
	 */
	protected void createNewUserAccount(SignUpCredentials signupcredentials) {
		MongoDAO myDao = new MongoDAO();
		if (myDao.getMongoClient()) {
			myDao.createThisUserCollection(signupcredentials.getUserName());
		}

		myDao.insertValues(signupcredentials.getUserName(), signupcredentials);
	}

	/* (non-Javadoc)
	 * @see com.whimo.grid.interaces.GridValidator#validateFormFields(java.lang.Object, org.springframework.validation.BindingResult)
	 */
	@Override
	public Boolean validateFormFields(Object className, BindingResult result) {
		formValidator.validate(className, result);
		if (result.hasErrors()) {
			return Boolean.FALSE;
		}else{
			return Boolean.TRUE;
		}
	}

	/**
	 * @param dOB
	 */
	protected Boolean checkAge(String dOB) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date dateOfNewUserBirth = format.parse(dOB);
			if(2016 - dateOfNewUserBirth.getYear() > 18){
				return Boolean.TRUE;
			}else if(dateOfNewUserBirth.getMonth() > 05){
				return Boolean.TRUE;
			}else{
				return Boolean.FALSE;
			}
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}
}
