/*
* Copyright (c) 2016 WhimiIndustries
* All rights reserved
* @author Devvrat Nigam
*/
package com.whimo.grid.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class GridUtils {
	@SuppressWarnings("deprecation")
	public static void populateDateOfBirthValues(HttpServletRequest request) {
		Date today = new Date();
		request.setAttribute("today", today);
		populateMonthValues(request,today.getMonth());
		populateDayValues(request,today.getDate());
		populateYearValues(request,today.getYear()+1900);
	}

	/**
	 * @param request
	 * @param thisYear 
	 */
	private static void populateYearValues(HttpServletRequest request, int thisYear) {		
		List<Integer> yearList = new ArrayList<Integer>();
		for (int i = thisYear; i >= 1980; i--) {
			yearList.add(i);
		}
		request.setAttribute("yearList", yearList);
		request.setAttribute("defaultYear", thisYear);
	}

	/**
	 * @param request
	 * @param thisDay 
	 */
	private static void populateDayValues(HttpServletRequest request, int thisDay) {
		List<Integer> dayList = new ArrayList<Integer>();
		for (int i = 1; i <= 31; i++) {
			dayList.add(i);
		}
		request.setAttribute("dayList", dayList);
		request.setAttribute("defaultDay", thisDay);
	}

	/**
	 * @param request
	 * @param thisMonth
	 */
	private static void populateMonthValues(HttpServletRequest request, int thisMonth) {
		HashMap<Integer, String> monthMap = new HashMap<Integer, String>();
		monthMap.put(0, "January");
		monthMap.put(1, "February");
		monthMap.put(2, "March");
		monthMap.put(3, "April");
		monthMap.put(4, "May");
		monthMap.put(5, "June");
		monthMap.put(6, "July");
		monthMap.put(7, "August");
		monthMap.put(8, "September");
		monthMap.put(9, "October");
		monthMap.put(10, "November");
		monthMap.put(11, "December");
		request.setAttribute("monthMap", monthMap);
		request.setAttribute("defaultMonth", thisMonth);
	}

	/**
	 * @param request 
	 * @param result
	 */
	public static void populateResultInRequest(HttpServletRequest request, BindingResult bindingResult) {
		List<String> ErrorCodesArrayList = new ArrayList<String>();
		for (Object object : bindingResult.getAllErrors()) {
		    if(object instanceof FieldError) {
		        FieldError fieldError = (FieldError) object;
		        ErrorCodesArrayList.add(fieldError.getCode());
		    }else if(object instanceof ObjectError) {
		        ObjectError objectError = (ObjectError) object;
		        ErrorCodesArrayList.add(objectError.getCode());
		    }
		}		
		request.setAttribute("ErrorList", ErrorCodesArrayList);
	}
}
