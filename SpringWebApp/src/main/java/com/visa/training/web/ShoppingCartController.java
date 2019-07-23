package com.visa.training.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"selectedBooks","selectedCars","selectedBikes"})
public class ShoppingCartController {

	@RequestMapping("/addBooks")
	public String addbooks(@RequestParam("Books") String[] selectedBooks, Map model) {
		model.put("selectedBooks", selectedBooks);
		return "cars";
	}

	@RequestMapping("/addCars")
	public String addcars(@RequestParam("Cars") String[] selectedCars, Map model) {
		model.put("selectedCars", selectedCars);
		return "bikes";
	}

	@RequestMapping("/addBikes")
	public String addbikes(@RequestParam("Bikes") String[] selectedBikes, Map model) {
		model.put("selectedBikes", selectedBikes);
		return "cart";
	}

	/*
	 * @RequestMapping("/addBooks") public ModelAndView
	 * addBooks(@RequestParam("Books") String[] selectedBooks, HttpSession session)
	 * { String viewName = "cars"; session.setAttribute("selectedBooks",
	 * selectedBooks); return new ModelAndView(viewName); }
	 * 
	 * @RequestMapping("/addCars") public ModelAndView addCars(@RequestParam("Cars")
	 * String[] selectedCars, HttpSession session) { String viewName = "bikes";
	 * session.setAttribute("selectedCars", selectedCars); return new
	 * ModelAndView(viewName); }
	 * 
	 * @RequestMapping("/addBikes") public ModelAndView
	 * addBikes(@RequestParam("Bikes") String[] selectedBikes, HttpSession session)
	 * { String viewName = "cart"; Map<String, Object> attributes = new
	 * HashMap<String, Object>(); attributes.put("selectedBooks",
	 * session.getAttribute("selectedBooks")); attributes.put("selectedCars",
	 * session.getAttribute("selectedCars")); attributes.put("selectedBikes",
	 * session.getAttribute("selectedBikes")); return new ModelAndView(viewName,
	 * attributes); }
	 */

}