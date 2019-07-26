package com.visa.training.bootProject;

import java.net.URI;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.visa.training.bootProject.domain.Product;

import reactor.core.publisher.Flux;

public class RESTtest {
	// typesafe get for collection;

	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<List<Product>> response = restTemplate.exchange("http://localhost:8080/api/", HttpMethod.GET, null,
			new ParameterizedTypeReference<List<Product>>() {
			});
	List<Product> products = response.getBody();
	static String REST_SERVICE_URI = "http://localhost:8080/api/";

	/* GET */
	private static void getUser() {
		System.out.println("Testing getUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		Product p = restTemplate.getForObject(REST_SERVICE_URI + "/products/181", Product.class);
		System.out.println(p);
	}

	/* POST */
	private static void createUser(Product p) {
		System.out.println("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/products/", p, Product.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

	/* PUT */
	private static void updateUser(Product p) {
		System.out.println("Testing update User API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(REST_SERVICE_URI + "/products/181", p);
		System.out.println(p);
	}

	/* DELETE */
	private static void deleteUser() {
		System.out.println("Testing delete User API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/products/181");
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		getAll();
		long stop = System.currentTimeMillis();
		System.out.println("Listing took "+(stop - start)+" ms");
		doSomeOtherWork();
		
		Thread.sleep(3000);
		/*
		 * System.out.println("Creating Product"); Scanner kb = new Scanner(System.in);
		 * System.out.println("Enter a name: "); String name = kb.nextLine();
		 * System.out.println("Enter a price: "); float price =
		 * Float.parseFloat(kb.nextLine()); System.out.println("Enter a QOH: "); int qoh
		 * = Integer.parseInt(kb.nextLine()); Product p = new Product(name, price, qoh);
		 * createUser(p);
		 * 
		 * System.out.println("Updating Product"); kb = new Scanner(System.in);
		 * System.out.println("Enter a name: "); name = kb.nextLine();
		 * System.out.println("Enter a price: "); price =
		 * Float.parseFloat(kb.nextLine()); System.out.println("Enter a QOH: "); qoh =
		 * Integer.parseInt(kb.nextLine()); p = new Product(name, price, qoh);
		 * updateUser(p);
		 */
	}

	private static void getAll() {
		/*
		 * System.out.println("Testing API----------"); RestTemplate restTemplate = new
		 * RestTemplate(); ResponseEntity<List<Product>> response =
		 * restTemplate.exchange("http://localhost:8080/api/products", HttpMethod.GET,
		 * null, new ParameterizedTypeReference<List<Product>>() { }); List<Product> p =
		 * response.getBody(); p.forEach(System.out::println);
		 */
		WebClient client = WebClient.create("http://localhost:8080");
        Flux<Product> all = client.get().uri("/api/products").retrieve().bodyToFlux(Product.class);
        all.subscribe(System.out::println);
	}

	private static void doSomeOtherWork() {
		System.out.println("Doing some other work");
	}

}