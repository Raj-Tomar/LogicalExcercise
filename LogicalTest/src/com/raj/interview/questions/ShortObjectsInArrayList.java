package com.raj.interview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * This question asked in Ness Technologies
 * How to short objects in ArrayList
 */
public class ShortObjectsInArrayList {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		Employee e1 = new Employee(1, "aaa");
		Employee e2 = new Employee(2, "bbb");
		Employee e3 = new Employee(3, "ccc");
		list.add(e3);
		list.add(e1);
		list.add(e2);
		System.out.println("Before Sort : ");
		for (Employee e : list) {
			System.out.println(e);
		}

		Collections.sort(list);
		System.out.println("After Sort : ");
		for (Employee e : list) {
			System.out.println(e);
		}

		List<Student> al = new ArrayList<Student>();
		Student s1 = new Student(1, "Raj");
		Student s2 = new Student(2, "Tomar");
		Student s3 = new Student(3, "SSS");
		al.add(s3);
		al.add(s1);
		al.add(s2);

		System.out.println("Before Sort : ");
		for (Student s : al) {
			System.out.println(s);
		}
		Collections.sort(al, Student.studentRollNo);
		System.out.println("After Sort : ");
		for (Student s : al) {
			System.out.println(s);
		}

	}

	static class Employee implements Comparable<Employee> {

		private int id;
		private String name;

		public Employee(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + "]";
		}

		@Override
		public int compareTo(Employee o) {
			int compareId = ((Employee) o).getId();
			/* For Ascending order */
			return this.id - compareId;
			/* For Descending order do like this */
			// return compareId-this.id;
		}
	}

	static class Student {

		private Integer rollNo;
		private String name;

		public Student(Integer rollNo, String name) {
			super();
			this.rollNo = rollNo;
			this.name = name;
		}

		public Integer getRollNo() {
			return rollNo;
		}

		public void setRollNo(Integer rollNo) {
			this.rollNo = rollNo;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Student [rollNo=" + rollNo + ", name=" + name + "]";
		}

		/* Comparator for sorting the list by roll no */

		public static Comparator<Student> studentRollNo = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				int rollNo1 = o1.getRollNo();
				int rollNo2 = o2.getRollNo();
				/* For ascending order */
				return rollNo1 - rollNo2;
				/* For descending order */
				// return rollNo2 - rollNo1;
			}
		};

		public static Comparator<Student> studentName = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				String name1 = o1.getName();
				String name2 = o2.getName();
				// ascending order
				return name1.compareTo(name2);
				// descending order
				// return name2.compareTo(name1);
			}

		};

	}
}
