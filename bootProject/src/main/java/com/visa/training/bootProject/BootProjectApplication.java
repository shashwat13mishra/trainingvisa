package com.visa.training.bootProject;

import java.net.URI;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.visa.training.bootProject.domain.Product;

@SpringBootApplication
public class BootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootProjectApplication.class, args);
		/*
		 * ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
		 * ui.createProductWithUI();
		 */
	}

}