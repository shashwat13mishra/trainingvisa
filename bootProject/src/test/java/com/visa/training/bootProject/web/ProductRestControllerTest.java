package com.visa.training.bootProject.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.visa.training.bootProject.domain.Product;
import com.visa.training.bootProject.service.ProductService;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
@RunWith(SpringRunner.class)
@WebMvcTest(value = {ProductRestController.class})
public class ProductRestControllerTest {

	@Autowired
	MockMvc mvc;
	
	@MockBean
	ProductService service;
	
	@Test
	public void test() throws Exception {
		 //Arrange
        Product data = new Product("test", 1999, 1000);
        data.setId(1);
        Mockito.when(service.findById(1)).thenReturn(data);
        
        //Act and Assert
        mvc.perform(get("/api/products/{id}", 1).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(1)));	}

}
