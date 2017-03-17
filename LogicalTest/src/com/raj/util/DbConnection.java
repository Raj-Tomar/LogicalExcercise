package com.raj.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost/test";
	// Database credentials
	final static String USER = "root";
	final static String PASS = "root";
	static Connection connection = null;
	
	public static void main(String[] args) {
		getDbConnection();
	}
	
	public static Connection getDbConnection() {
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
