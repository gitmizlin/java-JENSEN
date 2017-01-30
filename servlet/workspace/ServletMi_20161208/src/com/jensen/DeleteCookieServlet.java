package com.jensen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;   
	
	public DeleteCookieServlet() {   
		
	}   
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException { 
		
		res.setContentType("text/html"); 
		PrintWriter out = res.getWriter();   
		
		try { 
			Cookie cookies[] = req.getCookies(); 

			
			for(Cookie cookie : cookies) {				
	            cookie.setValue("");
	            cookie.setHttpOnly(true);
	            cookie.setPath("/");
	            cookie.setMaxAge(0);
//	            res.addCookie(cookie);
	            out.println("Cookie Name: " + cookie.getName() + " / "); 
				out.println("Cookie Value: " + cookie.getValue() + "<br/><br/>"); 
				
			}   

			out.print("Cookie deleted!"); 
			out.print("<form action='GetCookieServlet' method='POST'>"); 
			out.print("<input type='submit' value='Get Cookie'>");
			out.print("</form>");   
			
			
			out.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} 


	} 
	

}