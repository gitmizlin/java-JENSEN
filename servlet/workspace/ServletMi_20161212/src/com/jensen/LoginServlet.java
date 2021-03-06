package com.jensen;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();

		if (userName == null || userName.equals("") || password == null || password.equals("")) {
			out.print("Please enter both username " + "and password. <br/><br/>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
			requestDispatcher.include(request, response);
		}

		else if (userName.equals("mi") && password.equals("111")) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);
			out.println("Logged in successfully.<br/>");
			out.println("Click on the below link to see " + "the values of Username and Password.<br/>");
			out.println("<a href='DisplaySessionValueServlet'>" + "Click here</a>");
			out.close();

		} else {
			out.print("Wrong username or password. <br/><br/>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
			requestDispatcher.include(request, response);
		}
	}
}