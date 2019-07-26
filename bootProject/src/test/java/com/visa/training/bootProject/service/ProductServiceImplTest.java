package com.visa.training.bootProject.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.visa.training.bootProject.dal.ProductRepository;
import com.visa.training.bootProject.domain.Product;

public class ProductServiceImplTest {

	@Test
	public void addNewProduct_Returns_Valid_Id_When_Value_Gt_MinValue() {
		//Arrange
		
		ProductServiceImpl impl = new ProductServiceImpl();
		Product toBeAdded = new Product("test",10000,2);
		
		Product added = new Product("test",10000,2);
		added.setId(1);//as after save Id generated
		ProductRepository mockDAO = Mockito.mock(ProductRepository.class);
		Mockito.when(mockDAO.save(toBeAdded)).thenReturn(added);
		impl.setDao(mockDAO);
		//Act
		
		int id = impl.addNewProduct(toBeAdded);
		
		assertTrue(id > 0);
	}
}