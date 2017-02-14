package com.cookbook07.structuring.data.with.java;

import java.util.Date;

public class StructureDemo {

	private Date date;
	
	public StructureDemo() { }
	
	public StructureDemo(int i) {
		this.date = new Date(i);
	}

	public Date getDate() {
		return this.date;
	}

}
