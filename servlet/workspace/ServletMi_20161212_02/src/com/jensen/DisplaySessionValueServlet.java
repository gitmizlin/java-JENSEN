package com.jensen;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DisplaySessionValueServlet")
public class DisplaySessionValueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplaySessionValueServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			
			out.println("Please <a href='login.html'>log in</a> first.");

			out.println("<br><br><a href=index.html>" + "Go back to TOP</a>");
			
			
		} else {
		    // Already created.
		}
		
		String userName = (String) session.getAttribute("userName");
		String password = (String) session.getAttribute("password");
		
		out.println("<h3>User info</h3>");
		
		out.println("Username: " + userName + "<br><br>");
		out.println("Password: " + password);
		out.println("<br><br><a href=index.html>" + "Go back to TOP</a>");
		
		out.println("<hr/><form action='LogoutServlet' method='post'><input type='submit' value='Logout' /></form>");
		
	    
		out.close();

	}
	


}