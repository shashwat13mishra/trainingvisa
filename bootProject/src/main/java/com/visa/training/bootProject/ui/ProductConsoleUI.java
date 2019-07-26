package com.visa.training.bootProject.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visa.training.bootProject.domain.Product;
import com.visa.training.bootProject.service.ProductService;

@Component
public class ProductConsoleUI {
	ProductService service;
	
	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}

	public void createProductWithUI() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a name: ");
		String name = kb.nextLine();
		System.out.println("Enter a price: ");
		float price = Float.parseFloat(kb.nextLine());
		System.out.println("Enter a QOH: ");
		int qoh = Integer.parseInt(kb.nextLine());

		Product p = new Product(name, price, qoh);
		try {
			int id = service.addNewProduct(p);
			System.out.println(id);
		} catch (IllegalArgumentException e) {
			System.out.println("Value too low for creation");
		}
	}
}