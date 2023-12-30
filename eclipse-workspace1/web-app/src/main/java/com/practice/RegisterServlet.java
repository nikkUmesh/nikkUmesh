package com.practice;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException,IOException {
		responce.setContentType("text/html");
		PrintWriter out= responce.getWriter();
		out.println("<h2> Welcome to Register Servlet </h2>");
		
		String name=request.getParameter("user_name");
		String password=request.getParameter("user_password");
		String email=request.getParameter("user_email");
		String gender=request.getParameter("user_gender");
		String course=request.getParameter("user_course");
		
		String cond=request.getParameter("condition");
		
		if (cond != null) {
		if (cond.equals("checked")) {
			out.println("<h2> Name :" + name + "</h2>");
			out.println("<h2> Password :" + password +" </h2>");
			out.println("<h2> Email : "+ email + "</h2>");
			out.println("<h2> Gender : "+ gender + "</h2>");
			out.println("<h2> Course : "+ course + "</h2>");
			
		}else {
			out.println("<h2>You have not accepted term and conditions</h2>");
		}
	}
		else {
			out.println("<h2>You have not accepted term and conditions</h2>");

		}

	}
}
