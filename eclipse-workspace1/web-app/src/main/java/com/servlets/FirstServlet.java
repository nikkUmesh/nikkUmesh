package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FirstServlet implements Servlet {

	//Life cycle method
	ServletConfig conf;
	
	public void init(ServletConfig conf) {

		this.conf=conf;
		System.out.println("Creating object.........");
	}

	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("Servicing..........");	
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<h1>This is my output from servlet method</h1>");
        out.println("<h1>Today date and time is "+new Date().toString()+" </h1>");

	}
	
	public void destroy(){
		System.out.println("Going to destroy servlet obj..");
		
	}
	// Non-lifecycle method
	public ServletConfig getServletConfig() {
		return this.conf;
	}
	public String getServletInfo() {
		return "This servlet created by Umesh sharma";
	}

}
