package com.visa.training.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visa.training.domain.Product;
import com.visa.training.service.ProductService;

@Controller
public class ProductConsoleController {

	@Autowired
	ProductService service;

	@Autowired
	ProductValidator validator;
	/*
	 * //Not necessary
	 * 
	 * @Autowired public void setService(ProductService service) { this.service =
	 * service; }
	 */

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView listProducts() {
		List<Product> productList = service.findAll();
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("productList", productList);
		Product p = new Product();
		attributes.put("product", p);
		return new ModelAndView("productform", attributes);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product p, Errors validationError) {
		validator.validate(p, validationError);

		if (!validationError.hasErrors())
			service.addNewProduct(p);

		List<Product> productList = service.findAll();
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("productList", productList);
		Product pb =new Product();
		attributes.put("product", pb);

		return new ModelAndView("productform", attributes);
	}

	@RequestMapping("/removeProducts")
	public ModelAndView removeProduct(@RequestParam("id") int id) {
		try {
			service.delete(id);
		} catch (IllegalArgumentException e) {

			Product p = new Product();
			return new ModelAndView("redirect:/products", "product", p);
		}

		List<Product> productList = service.findAll();
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("productList", productList);
		Product p = new Product();
		attributes.put("product", p);

		return new ModelAndView("redirect:/products", attributes);
	}

	/*
	 * @ModelAttribute("productList") public List<Product> getProductList(){ return
	 * service.findAll(); }
	 */
}