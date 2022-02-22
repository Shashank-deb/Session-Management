package com.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("name");
		out.println("<h1>Servlet1</h1>");
		out.println("<h1> Hello "+name+", Welcome to My Website!");
		out.println("<h1><a href='Servlet2'>"+"Go to Servlet2");
		
		
		//creating cookie 
		//we cannot make space 
		//but we can make underscroll 
		//to run the code
		//request2+cookie to servlet2
		Cookie c=new Cookie("user_name",name);
		res.addCookie(c);
		
		
	}

}
