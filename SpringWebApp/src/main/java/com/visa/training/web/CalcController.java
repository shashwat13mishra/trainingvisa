package com.visa.training.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

	@RequestMapping("/calculator")
	public ModelAndView calculate(@RequestParam("n1") double n1, @RequestParam("n2") double n2,
			@RequestParam String op) {
		double res = 0;

		switch (op) {
		case "+":
			res = n1 + n2;
			break;
			
		case "-":
			res = n1 - n2;
			break;

		case "*":
			res = n1 * n2;
			break;

		case "/":
			res = n1 / n2;
			break;

		}
		String result = n1 + op + n2 +" = " + res;
		String viewName = "calcview" ;
		Map<String,Object> attributes = new HashMap<String, Object>();
		attributes.put("result",result);
		return new ModelAndView(viewName, attributes);
		
	}

}
