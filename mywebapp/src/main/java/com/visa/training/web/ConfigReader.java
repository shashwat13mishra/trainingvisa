package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigReader extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletConfig config = getServletConfig();
		String initParamValue = config.getInitParameter("user");

		ServletContext application = getServletContext();
		String contextParamValue = application.getInitParameter("company");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body bgcolor = red>");
		out.println("Company : "+contextParamValue);
		out.println("User : "+initParamValue);

	}
}
