package com.cookbook07.structuring.data.with.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesCompanies11 {

	public static void main(String[] args) throws IOException {
		
		OutputStream output = new FileOutputStream("PropertiesCompanies11.properties");
		
		Properties props = new Properties();
		// Get my data
		props.put("Adobe", "Mountain View, CA");
		props.put("IBM", "White Plains, NY");
		props.put("Learning Tree", "Los Angeles, CA");
		props.put("Microsoft", "Redmond, WA");
		props.put("Netscape", "Mountain View, CA");
		props.put("O'Reilly", "Sebastopol, CA");
		props.put("Sun", "Mountain View, CA");
		
		// save properties to project root folder
		props.store(output, null);
		
		InputStream input = new FileInputStream("PropertiesCompanies11.properties");
		
		// Now load additional properties
		//props.load(System.in);
		props.load(input);
		// List merged properties, using System.out
		props.list(System.out);

	}
}
