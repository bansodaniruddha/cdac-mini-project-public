package com.cdac.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.Entity.Employee;
import com.cdac.jdbc.JdbcConnection;

/**
 * Servlet implementation class EmployeeSevlet
 */
@WebServlet("/EmployeeSevlet")
public class EmployeeSevlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		
		Employee em= new Employee();
		em.setCountry(country);
		em.setEmail(email);
		em.setName(name);
		em.setPassword(password);
		
		JdbcConnection jdb=new JdbcConnection();
		jdb.add(em);
		
		
		
		
		
		
	}

}
