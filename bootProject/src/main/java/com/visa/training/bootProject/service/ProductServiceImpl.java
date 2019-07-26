package com.visa.training.bootProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.bootProject.dal.ProductRepository;
import com.visa.training.bootProject.domain.Product;



@Service
public class ProductServiceImpl implements ProductService {

	ProductRepository dao;

	@Autowired
	public void setDao(ProductRepository dao) {
		this.dao = dao;
	}

	@Override
	public int addNewProduct(Product p) {
		int id = 0;
		if (p.getPrice() * p.getQoh() >= 10000) {

			Product created = dao.save(p);
			id = created.getId();
		} else
			throw new IllegalArgumentException("Min value of stock should be at least 10k");
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
	public int updateProduct(Product toBeUpdated) {
		int id = toBeUpdated.getId();
		Product p = dao.findById(id);
		p.setName(toBeUpdated.getName());
		p.setPrice(toBeUpdated.getPrice());
		p.setQoh(toBeUpdated.getQoh());
		//delete(id);
		//id = addNewProduct(toBeUpdated);
		p = dao.save(p);
		return p.getId();
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Product p = dao.findById(id);
		if (p == null) {
			throw new IllegalArgumentException("Product not exists with this ID");
		} else
			dao.deleteById(id);
	}

}