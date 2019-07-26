package com.visa.training.secureapp.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@Autowired
	AdminOnlyBean bean;
	
	@RequestMapping("/api/sample")
	public List<String> sample(){
		String[] a = {"This","is","from","secure","resource"};
		List<String> strings = new ArrayList<String>(Arrays.asList(a));
		String lastElement = null;
		try {
			lastElement = bean.adminOnlyOperation();
		}catch (Exception e) {
			e.printStackTrace();
			lastElement = "permission denied";
		}
		strings.add(lastElement);
		return strings;
	}

}
