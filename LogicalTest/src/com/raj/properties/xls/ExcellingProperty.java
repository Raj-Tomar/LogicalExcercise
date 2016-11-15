package com.raj.properties.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcellingProperty {

	private File fileProp = null;
	private FileInputStream fisProp = null;
	private Properties properties = null;
	private static ArrayList<String> propertiesKey = new ArrayList<String>();
	private static ArrayList<String> propertiesValue = new ArrayList<String>();
	private File fileExcel = null;
	private FileOutputStream fosExcel = null;
	public void readPropertyFile(String propertiesFilePath) {
		fileProp = new File(propertiesFilePath);
		if (fileProp.isFile()) {
			try {
				fisProp = new FileInputStream(fileProp);
				properties = new Properties();
				// reading properties file
				properties.load(fisProp);
				Enumeration<?> keysEnum = properties.keys();
				propertiesKey.add(fileProp.getName());
				propertiesValue.add("");
				while (keysEnum.hasMoreElements()) {
					String propKey = (String) keysEnum.nextElement();
					// adding properties keys into arraylist
					propertiesKey.add(propKey);
					String propValue = (String) properties.getProperty(propKey);
					// adding properties values into arraylist
					propertiesValue.add(propValue);
				}
				fisProp.close();
			} catch (FileNotFoundException fnfe) {
				System.out.println("Property File Not Found");
				fnfe.printStackTrace();
			} catch (IOException ioe) {
				System.out.println("Error!!!");
				ioe.printStackTrace();
			} finally {
				try {
					fisProp.close();
				} catch (IOException ioe) {
					System.out.println("Error!!!-closing properties file");
				}
			}
		} else {
			System.out.println("Path specified for Property file is incorrect");
		}
	}
	public void writePropertiesIntoExcel(String excelPath) {
		try {
			fileExcel = new File(excelPath);
			fosExcel = new FileOutputStream(fileExcel);
			// creating workbook
			HSSFWorkbook workBook = new HSSFWorkbook();
			// creating sheet
			HSSFSheet workSheet = workBook.createSheet("Sheet1");
			for (int i = 0; i < propertiesKey.size(); i++) {
				// creating row
				HSSFRow row = workSheet
						.createRow(workSheet.getLastRowNum() + 1);
				// creating cell
				HSSFCell cellZero = row.createCell(0);
				HSSFCell cellOne = row.createCell(1);
				// setting cell value
				cellZero.setCellValue(new HSSFRichTextString((propertiesKey
						.get(i).toString())));
				cellOne.setCellValue(new HSSFRichTextString((propertiesValue
						.get(i).toString())));
			}
			// writing into xls file
			workBook.write(fosExcel);
			fosExcel.flush();
			fosExcel.close();
			workBook.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("xls file not found");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("Error!!!- xls");
			ioe.printStackTrace();
		}
	}
	public static void main(String args[]) {
		ExcellingProperty exp = new ExcellingProperty();
		File file = new File("E:\\");
		if (file.isDirectory()) {
			File[] fileArr = file.listFiles();
			for (int j = 0; j < fileArr.length; j++) {
				exp.readPropertyFile(fileArr[j].getPath());
			}
		}
		exp.writePropertiesIntoExcel("E:\\properties.xls");
	}
}
