package com.visa.training.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.jdbc.Product;
import com.visa.training.jdbc.ProductDAO;

@WebServlet("/productform")
public class Productform extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		Product toBeSaved = new Product(request.getParameter("Name"),
				Float.parseFloat(request.getParameter("Price")),
				Integer.parseInt(request.getParameter("QoH")));
		int generatedId = dao.save(toBeSaved);
		System.out.println(dao);
		System.out.println(generatedId);
		System.out.println(dao.findById(generatedId).toString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
