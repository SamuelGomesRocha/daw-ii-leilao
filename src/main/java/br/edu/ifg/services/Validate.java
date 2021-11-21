package br.edu.ifg.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.edu.ifg.entities.Status;
import br.edu.ifg.entities.User;

public class Validate {

		
		private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();;
		private static Validator validator = factory.getValidator();
	
	
	public static String validationUser(User user) {
		String msg = "";
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		
		
		
		for (ConstraintViolation<User> error: constraintViolations) {
				
				msg +="\n" +error.getMessage();
		}
		return msg;
	}
	
	public static LocalDate yo18Check(){

		
		return null;
	}
	
	
	
}
