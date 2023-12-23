package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cdac.Entity.Employee;


public class JdbcConnection {

	
public void  add(Employee en){
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","cdac");
			String sql = "insert into tbl_Empl values(?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,en.getName() );

			stmt.setString(3,en.getEmail());
			stmt.setString(2,en.getPassword());
		
			stmt.setString(4,en.getCountry());
			stmt.executeUpdate();
			System.out.println("Executed");
			conn.close();
		}

		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			//instead we should throw exception
		}
		
	}

public List<Employee> Fetch() {
	Connection conn1 = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","cdac");
		String sql = "select * from tbl_Empl";
		PreparedStatement stmt = conn1.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		List<Employee> list = new ArrayList<>();
		while(rs.next()) {
			Employee q = new Employee();
			
			q.setName(rs.getString("name"));
			q.setEmail(rs.getString("email"));
			q.setPassword(rs.getString("password"));
		
			q.setCountry(rs.getString("country"));
	
			list.add(q);
		}
		return list;
	}
	catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		 //instead we should throw exception
	}
	finally {
		try { conn1.close(); } catch(Exception e) { }
	}
	return null;
}
public void DeleteByEmail(String emaild){
	
	Connection conn = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","cdac");
		String sql = "delete from tbl_Empl where email=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1,emaild);
		stmt.executeUpdate();
		
		System.out.println("Executed");
		conn.close();
	}

	catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		//instead we should throw exception
	}
	
}


}
