/*
* Copyright (c) 2016 WhimiIndustries
* All rights reserved
* @author Devvrat Nigam
*/
package com.whimo.grid.interaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface GridTimelineInterface {

	ModelAndView doGet(HttpServletRequest request, HttpServletResponse response);

	ModelAndView doPost(HttpServletRequest request, HttpServletResponse response);

	void getValuesFromRequest(HttpServletRequest request);

	ModelAndView processRequest(String viewName);

}
