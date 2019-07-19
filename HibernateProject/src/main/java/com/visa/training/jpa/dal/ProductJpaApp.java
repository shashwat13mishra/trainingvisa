package com.visa.training.jpa.dal;

import java.util.List;

import com.visa.training.jpa.domain.Product;

public class ProductJpaApp {
	public static void main(String[] args) {
		JpaProductDAO dao = new JpaProductDAO();
		/*Product test = new Product("hibernate", 9999, 1000);
		Product saved = dao.save(test);
		System.out.println(saved);
		test = new Product("hibernate2", 9999, 1000);
		System.out.println(dao.save(test));
		Product fromDB = dao.findById(test.getId());
		System.out.println("FromDB: " + fromDB);
		fromDB.setName("hibernate3");
		dao.update(fromDB);
		System.out.println("Updated" + dao.findById(fromDB.getId()));
		System.out.println("Removed");
		//dao.remove(fromDB.getId());
		dao.remove(1);
		System.exit(0);
		*/
		List<Product> all = dao.findAll();
		all.forEach(System.out :: println);
	}
}
