package com.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request , HttpServletResponse responce) throws ServletException,IOException
	{
	    System.out.println("This is get method..... ");
	    responce.setContentType("text/html");
	    
	    PrintWriter out= responce.getWriter();
	    
	    out.print("<h1> This is get method of myServlet  </h1>");
	    out.println(new Date().toString());
	}
	

}
