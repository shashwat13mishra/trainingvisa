package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String s1 = request.getParameter("n1");
    	String s2 = request.getParameter("n2");
    	String op = request.getParameter("op");
    	
    	double n1 = Double.parseDouble(s1);
    	double n2 = Double.parseDouble(s2);
    	double result=0;
		switch(op) {
    	case "+":
    		result = n1 + n2;
    		break;
    	case "-":
    		result = n1 - n2;
    		break;
    	case "*":
    		result = n1 * n2;
    		break;
    	case "/":
    		result = n1 / n2;
    		break;
    	}
		response.setContentType("tree/html");
		
		PrintWriter out = response.getWriter();
		out.println("<b>Hello</b>");
		/*
		 * request.setAttribute("result", result);
		 * request.getRequestDispatcher("calcresult_el.jsp").forward(request, response);
		 */
		//out.println(n1 + " " + op + " " + n2 + " = "+result);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}