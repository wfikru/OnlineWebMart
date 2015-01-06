package edu.mum.cs490.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegistrationValidator implements Validator {
	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return RegistrationUser.class.isAssignableFrom(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.registrationUser.email", "Field name is required.");
 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
			"required.registrationUser.password", "Field name is required.");
 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"required.registrationUser.confirmPassword", "Field name is required.");
 
		RegistrationUser cust = (RegistrationUser)target;
		
		if(!(cust.getPassword().equals(cust.getConfirmPassword()))){
			if (cust.getPassword().length()>0)	errors.rejectValue("password", "notmatch.registrationUser.password");
		}
 
	}
}
