package com.raj.excel.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcelFile {
	
	public static void main(String[] args) throws IOException {

		//writeXLSFile();
		//readXLSFile();

		//writeXLSXFile();
		readXLSXFile();

	}
	

	public static void readXLSFile() throws IOException {
		InputStream ExcelFileToRead = new FileInputStream(
				"C:\\Documents and Settings\\Administrator\\Desktop\\Country-isd-codes.xlsx");
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row;
		HSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext()) {
			row = (HSSFRow) rows.next();
			Iterator cells = row.cellIterator();

			while (cells.hasNext()) {
				cell = (HSSFCell) cells.next();

				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
					System.out.print(cell.getStringCellValue() + " ");
				} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					System.out.print(cell.getNumericCellValue() + " ");
				} else {
					// U Can Handel Boolean, Formula, Errors
				}
			}
			System.out.println();
		}

	}

	public static void writeXLSFile() throws IOException {

		String excelFileName = "C:/Test.xls";// name of excel file

		String sheetName = "Sheet1";// name of sheet

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);

		// iterating r number of rows
		for (int r = 0; r < 5; r++) {
			HSSFRow row = sheet.createRow(r);

			// iterating c number of columns
			for (int c = 0; c < 5; c++) {
				HSSFCell cell = row.createCell(c);

				cell.setCellValue("Cell " + r + " " + c);
			}
		}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		// write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

	public static void readXLSXFile() throws IOException {
		InputStream ExcelFileToRead = new FileInputStream(
				"C:\\Documents and Settings\\Administrator\\Desktop\\Country-isd-codes.xlsx");

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/test";

		// Database credentials
		final String USER = "root";
		final String PASS = "root";
		Connection conn = null;
		Statement stmt = null;
		
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

		XSSFWorkbook test = new XSSFWorkbook();

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();

		List<String> countryName = new ArrayList<String>();
		List<String> countryCode = new ArrayList<String>();
		List<String> countryISD = new ArrayList<String>();
		try {
			//STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      
		      String sql = "SELECT * FROM countries";
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         String cName = rs.getString("name");
		         String alpha2 = rs.getString("alpha_2");
		         String code = rs.getString("fld_avl_ctry_iso_code");
		         //Display values
		         //System.out.println("Name: " + countryName);
		         countryName.add(cName);
		         countryCode.add(alpha2);
		         countryISD.add(code);
		      }
		      rs.close();
		      
		      
		      while (rows.hasNext()) {
					row = (XSSFRow) rows.next();
					Iterator cells = row.cellIterator();
					
					String cn = "";
					String code = "";
					while (cells.hasNext()) {
					
						cell = (XSSFCell) cells.next();
						
							if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
								System.out.print(cell.getStringCellValue() + " ");
								cn = cell.getStringCellValue();
							} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
								System.out.print(cell.getNumericCellValue() + " ");
								code = "+" + (int)cell.getNumericCellValue();
							} 
					}
					
					for (String string : countryName) {
						if(cn.equalsIgnoreCase(string)) {
							String update = "UPDATE countries SET fld_avl_ctry_iso_code = '"+code +"' WHERE name = '"+cn+"'";
							stmt.executeUpdate(update);
						}
					
					}
					System.out.println();
				}
		      
		      
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

	public static void writeXLSXFile() throws IOException {

		String excelFileName = "C:/Test.xlsx";// name of excel file

		String sheetName = "Sheet1";// name of sheet

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName);

		// iterating r number of rows
		for (int r = 0; r < 5; r++) {
			XSSFRow row = sheet.createRow(r);

			// iterating c number of columns
			for (int c = 0; c < 5; c++) {
				XSSFCell cell = row.createCell(c);

				cell.setCellValue("Cell " + r + " " + c);
			}
		}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		// write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

}