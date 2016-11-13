package com.jensen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sätter vad för typ av content servern kommer generera som response
		  response.setContentType("text/html");  
	      PrintWriter out=response.getWriter();  
	      //inkluderar link.html i vår response    
	      request.getRequestDispatcher("link.html").include(request, response);  
	       
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	          
	        if(password.equals("admin123")){  
	            out.print("Du är nu inloggad som " + name);  
	            out.print("<br>Välkommen, "+name);  
	           //skapar en ny session för användaren   
	           HttpSession session=request.getSession();
	           //sätter ett attribut som vi kan identifiera denna användarens namn med
	           session.setAttribute("user", name); 
	           
	        }else{ 
	        	//om det var fel lösenord så omdirigera till login.html
	            out.print("Fel användarnamn eller lösenord!");  
	            request.getRequestDispatcher("login.html").include(request, response);  
	        }  
	          
	        out.close();  

	}

}