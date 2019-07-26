package com.visa.training.secureapp.web;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class AdminOnlyBean {
	
	@RolesAllowed("ADMIN")
	public String adminOnlyOperation() {
		return "this is for admin";
	}

}
