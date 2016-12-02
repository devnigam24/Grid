/*
* Copyright (c) 2016 WhimiIndustries
* All rights reserved
* @author Devvrat Nigam
*/
package com.whimo.grid.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.whimo.grid.constants.AllPagesUrlConstants;
import com.whimo.grid.interaces.GridTimelineInterface;

@Controller
@RequestMapping("/userTimelinePage.grid")
public class UserTimeline extends Timeline implements GridTimelineInterface{

	@Override
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) {
		return this.processRequest(AllPagesUrlConstants.USER_TIME_LINE);
	}
	
	@Override
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response) {
		return this.processRequest(AllPagesUrlConstants.USER_TIME_LINE);
	}

	/* 
	 * 
	 */
	@Override
	public void getValuesFromRequest(HttpServletRequest request) {
		
	}

	/* 
	 * 
	 */
	@Override
	public ModelAndView processRequest(String viewName) {
		return new ModelAndView(viewName);
	}}
