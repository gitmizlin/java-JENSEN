package com.jensen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//namnet vi vill få omkastat
    	String name = request.getParameter("name");
    	//skapa en ett URL-objekt till vår web service
    	//här använder vi Javas net bibliotek och inget tredjepartsbibliotek för att skicka
    	//en request till web services
    	//det finns däremot ett väldigt bra bibliotek som heter http client (apache)
    	//som gör det hela lite enklare
    	URL url=new URL("http://localhost:8082/restWebService/reverser/xml/"+name);
    	PrintWriter out = response.getWriter();
    	//skapa en BR som läser från vår web Service
    	BufferedReader in = new BufferedReader(
    	        new InputStreamReader(url.openStream()));

        String inputLine;
        StringBuilder build = new StringBuilder();
        //så länge det finns något kvar att läsa lägg till
        //på vår String
        while ((inputLine=in.readLine()) != null)
            build.append(inputLine);
        in.close();
        //skapa en String xml från vår StringBuilder
        String xml=build.toString();
        //anropa metoden getTagValue för att parsa från XML
        String reversed = getTagValue(xml,"reversed");
        out.println("originalordet var: "+ name + " baklänges blir det : " + reversed);
	}
    //metod för att kunna hämta värdet från en tag
    //obs förekommer tagsen flera gånger hämtar metoden bara
    //den första förekomsten av tagen
    protected static String getTagValue(String xml, String tagName){
        return xml.split("<"+tagName+">")[1].split("</"+tagName+">")[0];
    }
}
