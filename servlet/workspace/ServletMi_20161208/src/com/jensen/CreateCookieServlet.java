package com.jensen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCookieServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;   
		
	public CreateCookieServlet() {
	
	}   
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException { 
		
		res.setContentType("text/html"); 
		PrintWriter out = res.getWriter();   
		
		//get parameters from request object
		String userName = req.getParameter("userName").trim(); 
		String password = req.getParameter("password").trim();   
		
		if(userName == null || userName.equals("") || password == null || password.equals("")){
			out.print("Please enter both username " + "and password. <br/><br/>"); 
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html"); 
			requestDispatcher.include(req, res); 
		}
			
		else if(userName.equals("mi") && password.equals("1234")){ 
			
			Cookie cookie1 = new Cookie("userName",userName); 
			Cookie cookie2 = new Cookie("password",password); 
			
			//add cookie in the response object
			res.addCookie(cookie1); 
			res.addCookie(cookie2); 
			out.print("<h3>Login successful & cookies are created!"); 
			out.print("<form action='GetCookieServlet' method='POST'>"); 
			out.print("<input type='submit' value='Get Cookie'>");
			out.print("</form>");   
			out.close(); 
			
		} else { 
			out.print("Invalid username or password. Please try again.<br/><br/>"); 
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html"); 
			requestDispatcher.include(req, res); 
		}
	}
}