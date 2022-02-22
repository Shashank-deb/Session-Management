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
 * Servlet implementation class Servlet2
 */
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
	    //String name=req.getParameter("name");
		//because the http protocol is stateless 
		//server will not remember the name of the user(first request to server)
		//they only remember username in the first Servlet(second request to server)
		//and suddenly when servlet first called the servlet second 
		//they show the null value in name
		//thus it is important in java to manange the session 
		
		
		//to solve this we will getting all cookies
		Cookie [] cookies=req.getCookies();
		boolean f=false;
		String name="";
		if(cookies==null)
		{
			out.println("<h1> You are new User </h1>");
			out.println("<h1>You do not have previous record on this website store in cookie</h1>");
			return;
		}
		else
		{
			for(Cookie c:cookies)
			{
			  String tempName= c.getName();	
			  if(tempName.equals("user_name"))
			  {
				  f=true;
				  name=c.getValue();
			  }
			}
		}
	
	if(f)
	{
		out.println("<h1>Servlet2</h1>");
		out.println("<h1>Hello "+name+" ,Welcome Back to Website!");
		out.println("<h1>Thankyou for visting</h1>");
	}
	else
	{
		out.println("<h1>You are new user in the website</h1>");
	}
	
	
}

}

