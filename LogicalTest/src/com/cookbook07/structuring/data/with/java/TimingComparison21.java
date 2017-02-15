package com.cookbook07.structuring.data.with.java;

import java.util.ArrayList;

public class TimingComparison21 {

	public static final int MAX = 250000;

	public static void main(String[] args) {
		System.out.println(new TimingComparison21().arrayRun());
		System.out.println(new TimingComparison21().arrayListRun());
	}

	public int arrayRun() {
		MutableInteger list[] = new MutableInteger[MAX];
		for (int i = 0; i < list.length; i++) {
			list[i] = new MutableInteger(i);
		}
		int sum = 0;
		for (int i = 0; i < list.length; i++) {
			sum += list[i].getValue();
		}
		return sum;
	}
	
	public int arrayListRun() {
		ArrayList<MutableInteger> list = new ArrayList<>();
		for (int i = 0; i < MAX; i++) {
			list.add(new MutableInteger(i));
		}
		int sum = 0;
		for (int i = 0; i < MAX; i++) {
			sum += ((MutableInteger) list.get(i)).getValue();
		}
		return sum;
	}
}

class MutableInteger {
	
	private int i;
	
	public MutableInteger(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

}
