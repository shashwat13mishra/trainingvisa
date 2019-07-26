package com.visa.training.bootProject.service;

import java.util.List;

import com.visa.training.bootProject.domain.Product;


public interface ProductService {
public int addNewProduct(Product p);
public Product findById(int id);
public List<Product> findAll();
public void delete(int id);
public int updateProduct(Product toBeUpdated);

}
