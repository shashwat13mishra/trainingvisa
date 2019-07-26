package com.visa.training.bootProject.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visa.training.bootProject.domain.Product;
import com.visa.training.bootProject.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	ProductService service;

	@RequestMapping(value = "/api/products", method = RequestMethod.GET)
	public List<Product> getAll() {
		try {
			Thread.sleep(2000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/products/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") int id) {
		Product p = service.findById(id);
		if (p != null) {

			return new ResponseEntity<Product>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/api/products", method = RequestMethod.POST)
	public ResponseEntity createProduct(@RequestBody Product toBeCreated) {
		try {
		int id = service.addNewProduct(toBeCreated);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/api/products/"+id));
		return new ResponseEntity<>(headers, HttpStatus.OK);
		}
		catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@RequestBody Product toBeUpdated){
		try {
			System.out.println(toBeUpdated);
			int id = service.updateProduct(toBeUpdated);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/api/products/"+id));
			return new ResponseEntity<>(headers, HttpStatus.OK);
			}
			catch (IllegalArgumentException e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
	
	
@RequestMapping(value = "/api/products/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteProduct(@PathVariable int id){
	try {
		service.delete(id);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.FOUND);
		}
		catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND  );
		}
	}
}