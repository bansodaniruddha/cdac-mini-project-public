package com.cdac.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.jdbc.JdbcConnection;

public class ServletDelete {

	@WebServlet
	("/DeleteServlet")
	public class DeleteServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	  
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String emaild=request.getParameter("rowemail");
			JdbcConnection conn=new JdbcConnection();
			conn.DeleteByEmail(emaild);
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewData.jsp");
	        dispatcher.forward(request, response);
			
			
			
			
			
		}

	}
}
