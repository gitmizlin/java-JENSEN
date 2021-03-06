package com.jensen;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplaySessionValueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplaySessionValueServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("userName");
		String password = (String) session.getAttribute("password");
		out.println("Username: " + userName + "<br/><br/>");
		out.println("Password: " + password);
		out.close();
	}

}