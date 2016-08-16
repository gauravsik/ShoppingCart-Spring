package com.bitwise.shop.helpers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bitwise.shop.models.User;


public class UserValidation implements Validator {

	@Override
	public boolean supports(Class<?> obj) {
		return User.class.equals(obj.getClass());
	}
	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User)obj;
		System.out.println("in user validation");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "errors.username", "Username  required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "errors.password", "Password  required");
		
		boolean checkLength = user.getUsername().length() < 5;
		if (checkLength)
			errors.rejectValue("username", "insufficient", "Username must be atleast 5 chars long");
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		boolean isPassValid = user.getPassword().matches(regex);
		
		String errorMessage = "Invalid Password! \n must be atleast 8 characters long and \ncontain alpha numeric content, special symbols,uppercase \nand lowercase letter ";
		if (! isPassValid)
			errors.rejectValue("password", "invalidPassword", errorMessage);
					
	}

}
