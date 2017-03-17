package com.raj.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.raj.util.DbConnection;

public class JavaAndSqlDateCompare {

	public static void main(String[] args) {
		Statement stmt = null;
		ResultSet rs = null;
		Connection con = DbConnection.getDbConnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT NOW()");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(format.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
