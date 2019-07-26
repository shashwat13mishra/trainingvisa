package com.visa.training.secureapp.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@RequestMapping("/api/sample")
	public List<String> sample(){
		String[] a = {"This","is","from","secure","resource"};
		return Arrays.asList(a);
	}

}
