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
import com.whimo.grid.constants.AllPagesUrlConstants;
import com.whimo.grid.controller.GridSignupController;
import com.whimo.grid.interaces.GridSignUpControllerInterface;
import com.whimo.grid.pojo.SignUpCredentials;
import com.whimo.grid.utils.GridUtils;

@Controller
@RequestMapping("/signUpPage.grid")
public class GoToSignUp implements GridSignUpControllerInterface{

	/* (non-Javadoc)
	 * @see com.whimo.grid.interaces.GridSignUpControllerInterface#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, com.whimo.grid.pojo.SignUpCredentials, org.springframework.validation.BindingResult, java.lang.String)
	 */
	@Override
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response, SignUpCredentials credentials,
			BindingResult result, String viewName) {
		this.setDefaultValues(request, response,result);
		return this.processRequest(request,response,AllPagesUrlConstants.SIGN_UP_PAGE_ONE);
	}

	/* (non-Javadoc)
	 * @see com.whimo.grid.interaces.GridSignUpControllerInterface#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, com.whimo.grid.pojo.SignUpCredentials, org.springframework.validation.BindingResult, java.lang.String)
	 */
	@Override
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response, SignUpCredentials credentials,
			BindingResult result, String viewName) {
		return this.processRequest(request,response,AllPagesUrlConstants.SIGN_UP_PAGE_ONE);
	}

	/* (non-Javadoc)
	 * @see com.whimo.grid.interaces.GridSignUpControllerInterface#processRequest(java.lang.String)
	 */
	@Override
	public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response,String viewName) {
		return new ModelAndView(viewName);
	}

	/* (non-Javadoc)
	 * @see com.whimo.grid.interaces.GridSignUpControllerInterface#setDefaultValues(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void setDefaultValues(HttpServletRequest request, HttpServletResponse response,BindingResult result) {
		GridUtils.populateDateOfBirthValues(request);		
	}}
