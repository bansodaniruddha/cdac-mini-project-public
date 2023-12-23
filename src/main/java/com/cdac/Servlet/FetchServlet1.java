package com.cdac.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cdac.Entity.Employee;
import com.cdac.jdbc.JdbcConnection;




@WebServlet("/Fetch")
public class FetchServlet1 extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Display Data</title>");
        out.println("</head>");
        out.println("<body>");

        try {
            JdbcConnection jdbcConn = new JdbcConnection();
            List<Employee> list = jdbcConn.Fetch();

            out.println("<h2>Data from Database:</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Name</th><th>Email</th><th>Password</th><th>City</th></tr>");

            for (Employee entity : list) {
                out.println("<tr>");
                out.println("<td>" + entity.getName() + "</td>");
                out.println("<td>" + entity.getEmail() + "</td>");
                out.println("<td>" + entity.getPassword() + "</td>");
                out.println("<td>" + entity.getCountry() + "</td>");
                out.println("<td> <a href='Edit'>Edit</a></td>");
                out.println("<td> <a href='Delete'>Delete</a></td>");
                out.println("</tr>");
            }

            out.println("</table>");
//            out.println("<form action='DeleteServlet' method='post'>");
//            out.println("Enter the email data to delete<input type='text' name='rowemail'>");
//            out.println("<input type='submit' value='Delete that row'>");
//            out.println("</form>");


        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error fetching data from database.</p>");
        }

        out.println("</body>");
        out.println("</html>");
		
		
		
	}

	

}
