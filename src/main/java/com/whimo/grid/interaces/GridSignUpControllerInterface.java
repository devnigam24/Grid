/*
* Copyright (c) 2016 WhimiIndustries
* All rights reserved
* @author Devvrat Nigam
*/
package com.whimo.grid.interaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.whimo.grid.pojo.SignUpCredentials;
import com.whimo.grid.pojo.UserAccount;
import com.whimo.grid.utils.GridUtils;

public interface GridSignUpControllerInterface {

	ModelAndView doGet(HttpServletRequest request, HttpServletResponse response, SignUpCredentials credentials,
			BindingResult result, String viewName);

	ModelAndView doPost(HttpServletRequest request, HttpServletResponse response, SignUpCredentials credentials,
			BindingResult result, String viewName);

	ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response,String viewName);
	
	void setDefaultValues(HttpServletRequest request, HttpServletResponse response,BindingResult result);

}
