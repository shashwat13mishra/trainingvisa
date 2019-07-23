package com.visa.training.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.visa.training.domain.Product;
@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product p = (Product) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Name can't be empty");
	}

}

