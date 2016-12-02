/*
* Copyright (c) 2016 WhimiIndustries
* All rights reserved
* @author Devvrat Nigam
*/
package com.whimo.grid.interaces;

import org.springframework.validation.BindingResult;

public interface GridValidator {
	
	Boolean validateFormFields(Object className, BindingResult result);

}
