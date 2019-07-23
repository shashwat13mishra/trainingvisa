package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	ProductDAO dao;

	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public int addNewProduct(Product p) {
		int id = 0;
		if (p.getPrice() * p.getQoh() >= 10000) {

			Product created = dao.save(p);
			id = created.getId();
		} else
			new IllegalArgumentException("Min value of stock should be at least 10k");
		return id;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Product p = dao.findById(id);
		if (p.getPrice() * p.getQoh() > 10000000) {
			throw new IllegalArgumentException("");
		} else
			dao.remove(id);
	}

}