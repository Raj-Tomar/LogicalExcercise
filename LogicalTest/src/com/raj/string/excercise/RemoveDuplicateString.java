package com.raj.string.excercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateString {

	public static void main(String[] args) {
		String[] arr = {"w10","w20","w10","w30","w20","w40","w50","w50"};
		RemoveDuplicateStringFromArray(arr);
	}
	
	public static void RemoveDuplicateStringFromArray(String[] arr) {
		System.out.println("Current Input : "+Arrays.toString(arr));
		List<String> dup = new ArrayList<String>();
		List<String> uniq = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			boolean isUnique = true;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i].equalsIgnoreCase(arr[j])){
					dup.add(arr[i]);
				}
			}
			for (int j = 0; j < arr.length; j++) {
				if(arr[i].equalsIgnoreCase(arr[j]) && i != j){
					isUnique = false;
					break;
				}
			}
			if(isUnique) {
				uniq.add(arr[i]);	
			}
		}
		System.out.println("Duplicates : "+Arrays.toString(dup.toArray()));
		System.out.println("Unique : "+Arrays.toString(uniq.toArray()));
	}
}
