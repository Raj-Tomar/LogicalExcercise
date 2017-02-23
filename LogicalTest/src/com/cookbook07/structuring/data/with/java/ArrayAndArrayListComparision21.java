package com.cookbook07.structuring.data.with.java;

import java.util.ArrayList;

public class ArrayAndArrayListComparision21 {

	public static final int MAX = 250000;

	public static void main(String[] args) {
		System.out.println("ArrayTime : "+arrayRun());
		System.out.println("ArrayListTime : "+arrayListRun());
	}

	public static int arrayRun() {
		Long startTime = System.currentTimeMillis(); // Instant.now().toEpochMilli(); // Java 8
		MutableInteger list[] = new MutableInteger[MAX];
		for (int i = 0; i < list.length; i++) {
			list[i] = new MutableInteger(i);
		}
		int sum = 0;
		for (int i = 0; i < list.length; i++) {
			sum += list[i].getValue();
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("Total Execution Time : "+(endTime - startTime));
		return sum;
	}

	public static int arrayListRun() {
		Long startTime = System.currentTimeMillis();
		ArrayList<MutableInteger> list = new ArrayList<>();
		for (int i = 0; i < MAX; i++) {
			list.add(new MutableInteger(i));
		}
		int sum = 0;
		for (int i = 0; i < MAX; i++) {
			sum += ((MutableInteger) list.get(i)).getValue();
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("Total Execution Time : "+(endTime - startTime));
		return sum;
	}

}
