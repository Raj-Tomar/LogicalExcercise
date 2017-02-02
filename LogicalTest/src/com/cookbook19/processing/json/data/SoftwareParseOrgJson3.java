package com.cookbook19.processing.json.data;

import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class SoftwareParseOrgJson3 {

	final static String FILE_NAME = "softwareinfo.json";

	public static void main(String[] args) throws Exception {
		
		InputStream jsonInput = SoftwareParseOrgJson.class.getResourceAsStream(FILE_NAME);
		
		if (jsonInput == null) {
			throw new NullPointerException("can't find" + FILE_NAME);
		}
		
		JSONObject obj = new JSONObject(new JSONTokener(jsonInput)); 	// Create the JSONObject from the input
		System.out.println("Software Name: " + obj.getString("name"));	// Retrieve individual String fields
		System.out.println("Version: " + obj.getString("version"));
		System.out.println("Description: " + obj.getString("description"));
		System.out.println("Class: " + obj.getString("className"));
		JSONArray contribs = obj.getJSONArray("contributors");			// Retrieve the JSONArray of contributor names
		for (int i = 0; i < contribs.length(); i++) {					// org.json.JSONArray doesn’t implement Iterable so you can’t use a foreach loop
			System.out.println("Contributor Name: " + contribs.get(i));
		}
	}

}
