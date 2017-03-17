package com.raj.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.raj.util.DbConnection;

public class DbConnectionExample {

	static Connection conn = null;
	static Statement stmt = null;

	public static void main(String[] args) {

		try {
			conn = DbConnection.getDbConnection();

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "SELECT * FROM tbl_avl_countries";
			ResultSet rs = stmt.executeQuery(sql);
			
			List<String> cnCode = new ArrayList<String>();
			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String cName = rs.getString("fld_avl_ctry_code");
				// Display values
				cnCode.add(cName);
			}
			rs.close();
			String path = "https://antelopeimages.s3.amazonaws.com/logo/";
			for (String string : cnCode) {
				String update = "UPDATE tbl_avl_countries SET fld_avl_ctry_flag = '"+path + string.toLowerCase() + ".png" +"' WHERE fld_avl_ctry_code = '"+string+"'";
				stmt.executeUpdate(update);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
