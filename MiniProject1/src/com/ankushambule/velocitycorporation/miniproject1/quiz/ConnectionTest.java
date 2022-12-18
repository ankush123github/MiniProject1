package com.ankushambule.velocitycorporation.miniproject1.quiz;

import java.sql.*;

public class ConnectionTest {
	
	public Connection getConnectionDetails() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Root");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;				
	}

}
