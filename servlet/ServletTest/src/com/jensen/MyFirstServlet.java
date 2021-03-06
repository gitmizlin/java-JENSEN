package com.jensen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//används för att säga att adressen localhost:8080/MyFirstServlet ska hanteras av
//denna servleten
//kan använda flera stycken urls som denna servern hanterar
//kan även använda wildcards (*)
//nu hanterar denna servlet alla request på MyFirstServlet/....

@WebServlet(urlPatterns = {"/MyFirstServlet/*", "/hej"})
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyFirstServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		//sparar ner användaruppgifter i variablerna user och pass
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		if(user.equals("Martin") && pass.equals("sjk15"))
			out.println("Succesful Login");
		else
			out.println("invalid login");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post och get ska göra samma sak, alltså anropar vi
		//doGet inne i doPost istället för att skriva samma kod
		//två gånger
		doGet(request, response);
	}

}