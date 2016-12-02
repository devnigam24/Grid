/*
* Copyright (c) 2016 WhimiIndustries
* All rights reserved
* @author Devvrat Nigam
*/
package com.whimo.grid.controller.signUp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.whimo.grid.constants.AccountUtilConstants;
import com.whimo.grid.constants.AllPagesUrlConstants;
import com.whimo.grid.controller.GridSignupController;
import com.whimo.grid.interaces.GridSignUpControllerInterface;
import com.whimo.grid.pojo.SignUpCredentials;
import com.whimo.grid.utils.GridUtils;

@Controller
@RequestMapping("/userSignUp.grid")
public class NewUserSighUp extends GridSignupController implements GridSignUpControllerInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.whimo.grid.interaces.GridSignUpControllerInterface#doGet(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * com.whimo.grid.pojo.SignUpCredentials,
	 * org.springframework.validation.BindingResult, java.lang.String)
	 */
	@Override
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response, SignUpCredentials credentials,
			BindingResult result, String viewName) {
		return this.processRequest(request, response, AllPagesUrlConstants.SIGN_UP_PAGE_ONE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.whimo.grid.interaces.GridSignUpControllerInterface#doPost(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * com.whimo.grid.pojo.SignUpCredentials,
	 * org.springframework.validation.BindingResult, java.lang.String)
	 */
	@Override
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response,
			SignUpCredentials signupcredentials, BindingResult result, String viewName) {
		signupcredentials = this.getValuesFromRequest(request, signupcredentials);
		if (this.validateFormFields(signupcredentials, result)) {
			super.createNewUserAccount(signupcredentials);
			return this.processRequest(request, response, AllPagesUrlConstants.USER_TIME_LINE);
		} else {
			this.setDefaultValues(request, response, result);
			return this.processRequest(request, response, AllPagesUrlConstants.SIGN_UP_PAGE_ONE);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.whimo.grid.interaces.GridSignUpControllerInterface#
	 * getValuesFromRequest(javax.servlet.http.HttpServletRequest)
	 */
	public SignUpCredentials getValuesFromRequest(HttpServletRequest request, SignUpCredentials signupcredentials) {
		String firstName = request.getParameter(AccountUtilConstants.FIRST_NAME);
		request.setAttribute(AccountUtilConstants.FIRST_NAME, firstName);
		String lastNAme = request.getParameter(AccountUtilConstants.LAST_NAME);
		request.setAttribute(AccountUtilConstants.LAST_NAME, lastNAme);
		String emailID = request.getParameter(AccountUtilConstants.EMAILID);
		request.setAttribute(AccountUtilConstants.EMAILID, emailID);
		String userName = request.getParameter(AccountUtilConstants.USERNAME);
		request.setAttribute(AccountUtilConstants.USERNAME, userName);
		String password = request.getParameter(AccountUtilConstants.PASSWORD);
		String securityQuestion = request.getParameter(AccountUtilConstants.SECURITY_QUESTION);
		String securityAnswer = request.getParameter(AccountUtilConstants.SECURITY_ANSWER);
		request.setAttribute(AccountUtilConstants.SECURITY_ANSWER, securityAnswer);
		String charityType = request.getParameter(AccountUtilConstants.CHARITY_NON_PROFIT_OF_CHOICE);
		String dob = AccountUtilConstants.EMPTY_STRING;
		String location = "United States";

		if (AccountUtilConstants.NULL_STRING != this.setDateOfBirthValue(request)) {
			dob = this.setDateOfBirthValue(request);
		}
		
		return new SignUpCredentials(firstName, lastNAme, emailID, userName, password, dob, location,
				securityQuestion, securityAnswer, charityType);

	}

	/**
	 * @param request
	 * @return
	 */
	private String setDateOfBirthValue(HttpServletRequest request) {
		AccountUtilConstants.DOB = (String) request.getParameter(AccountUtilConstants.MONTH_BIRTH) + "/"
				+ request.getParameter(AccountUtilConstants.DAY_BIRTH) + "/"
				+ request.getParameter(AccountUtilConstants.YEAR_BIRTH);
		if (super.checkAge(AccountUtilConstants.DOB)) {
			return AccountUtilConstants.DOB;
		} else {
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.whimo.grid.interaces.GridSignUpControllerInterface#processRequest(
	 * java.lang.String)
	 */
	@Override
	public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response, String viewName) {
		return new ModelAndView(viewName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.whimo.grid.interaces.GridSignUpControllerInterface#setDefaultValues(
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void setDefaultValues(HttpServletRequest request, HttpServletResponse response, BindingResult result) {
		GridUtils.populateDateOfBirthValues(request);
		GridUtils.populateResultInRequest(request, result);
	}
}
