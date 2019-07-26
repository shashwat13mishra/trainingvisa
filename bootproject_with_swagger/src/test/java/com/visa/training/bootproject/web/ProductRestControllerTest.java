package com.visa.training.bootproject.web;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.visa.training.bootproject.domain.Product;
import com.visa.training.bootproject.service.ProductService;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = {ProductRestController.class})
public class ProductRestControllerTest {

	@Autowired
	MockMvc mvc;
	
	@MockBean
	ProductService service;
	
	@Test
	public void testGetById() throws Exception {
		//Arrange
				Product data = new Product("test", 1999, 1000);
				data.setId(1);
				Mockito.when(service.findById(1)).thenReturn(data);
				//Act and Assert
				mvc.perform(get("/api/products/{id}", 1).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)));
	}

}
