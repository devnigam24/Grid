package com.whimo.grid.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login.grid")
public class HomeController{
	@Value(value = "${portNumber}")
	private String message;
	
	/* 
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(ModelMap model)
			throws Exception {
		model.addAttribute("message",message);
		return new ModelAndView("login");		
	}
}
