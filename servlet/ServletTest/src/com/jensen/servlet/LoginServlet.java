package com.jensen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jensen.util.User;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select id, name, email from Users where email=? and password=? limit 1");
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs != null && rs.next()){
				
				User user = new User(rs.getString("name"), rs.getString("email"), rs.getInt("id"));
				HttpSession session = request.getSession();
				session.setAttribute("User", user.getName());
				request.getRequestDispatcher("ProfileServlet").forward(request,response);
			}else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
				PrintWriter out= response.getWriter();
				out.println("<font color=red>No user found with given email id, please register first.</font>");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("DB Connection problem.");
		}finally{
			
				try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			
			
		
		}
	}

}
