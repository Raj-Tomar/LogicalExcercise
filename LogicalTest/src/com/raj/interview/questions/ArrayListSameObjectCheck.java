package com.raj.interview.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayListSameObjectCheck {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		ArrayListSameObjectCheck.Employee e1 = new Employee(1, "AAA");
		ArrayListSameObjectCheck.Employee e2 = new Employee(1, "AAA");
		list.add(e1);
		boolean b = list.contains(e2);
		System.out.println(b);
		//list.add(e2);
		
	}
	
	static class Employee{
		
		private Integer id;
		private String name;
		
		public Employee(Integer id, String name){
			this.id = id;
			this.name = name;
		}
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public boolean equals(Object obj) {
			boolean same = false;
			Employee emp = (Employee)obj;
			/*
			if(obj != null && obj instanceof Employee){
				same = this.id==emp.getId() && this.name.equals(emp.getName());
			}
			*/
			
			//For JDK 7 and above, you can use the new Objects class to generate the equals and hash code values.
			if(obj != null && obj instanceof Employee){
				same = this.id == emp.getId() && Objects.equals(this.name, emp.getName());
			}
			return same;
		}
		
		@Override
		public int hashCode() {
			// The 17 and 31 hash code idea is from the classic Java book – effective Java : item 9
			/*
			int result = 17;
	        result = 31 * result + id;
	        result = 31 * result + name.hashCode();
	        return result;
			return result;
			*/
			
			//For JDK 7 and above, you can use the new Objects class to generate the equals and hash code values.
			return Objects.hash(id, name);
			
		}
	}
}
