package com.cookbook19.processing.json.data;

import org.json.JSONObject;

public class WriteOrgJson4 {
	
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Name", "robinParse")
		.put("Version", "1.2.3")
		.put("Class", "RobinParse");
		String printable = jsonObject.toString();
		System.out.println(printable);
	}

}
