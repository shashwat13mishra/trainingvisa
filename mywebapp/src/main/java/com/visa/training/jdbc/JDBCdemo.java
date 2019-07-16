package com.visa.training.jdbc;

import java.util.List;

public class JDBCdemo {
	public static void main(String[] args) throws Exception {
		ProductDAO dao = new ProductDAO();
		Product toBeSaved = new Product("comb", 99, 1000);
		int generatedId = dao.save(toBeSaved);
		System.out.println(dao.findById(generatedId).toString());
		List<Product> all = dao.findAll();
		all.forEach(System.out::println);
		//dao.remove(99);
		//dao.findAll().forEach(System.out::println);
		
	}
}
