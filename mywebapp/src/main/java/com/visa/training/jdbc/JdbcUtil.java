package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
	public static Connection getConnection() {
		Connection c = null;
		// Now establish a connection, there will be exceptions so throw them
		try {
			// Load driver for connection
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/visa", "visa", "secret");
			// c = DriverManager.getConnection("jdbc:mysql://ip:port/mydb", "username",
			// "pswd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}