package com.whimo.grid.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.whimo.grid.pojo.SignUpCredentials;
import com.whimo.grid.pojo.UserAccount;

public class SignUpPageValidator implements Validator{

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(SignUpCredentials.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userFirstName", "error.empty.userFirstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userLastName", "error.empty.userLastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail", "error.empty.userEmail");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.empty.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "error.empty.userPassword");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "securityQuestion", "error.empty.securityQuestion");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "securityAnswer", "error.empty.securityAnswer");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "charityNonProfitOfChoice", "error.empty.charityNonProfitOfChoice");
		SignUpCredentials credentials = (SignUpCredentials)target;
		if(!credentials.getUserEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
			errors.rejectValue("userEmail", "error.invalid.userEmail");
		}
	}

	
}
