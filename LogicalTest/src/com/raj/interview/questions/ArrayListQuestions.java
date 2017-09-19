package com.raj.interview.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/*
 * Remove Duplicates from ArrayList without using HashSet.
 * This question asked in Nisum, Charter Global
 * 
 * 	Solutions :
 * 	1. Use HashSet
 *  2. Remove Duplicate values from ArrayList.
 *  3. Iterate List using "for" loop or Iterator and use "contains()" method for adding items in new List.
*/
public class ArrayListQuestions {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(3);
		list.add(2);
		
		//list = removeDuplicatesUsingSet(list);
		//list = removeDuplicateLogic1(list);
		//list = removeDuplicatesFromList(list);
		
		//for (Integer i : list) System.out.println(i);
		
		
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(3);
		list.add(2);
		
		list = removeElementFromList(list);
		for(Integer i : list)
			System.out.println(i);
		
	}
	
	public static List<Integer> removeDuplicatesUsingSet(List<Integer> list) {
		Set<Integer> hs = new HashSet<Integer>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		return list;
	}
	
	public static List<Integer> removeDuplicatesFromList(List<Integer> list){
		for(int i = 0; i<=list.size(); i++){
			for(int j=i+1; j<list.size(); j++){
				if(list.get(i).equals(list.get(j))){
					list.remove(j);
				}
			}
		}
		return list;
	}
	
	public static List<Integer> removeDuplicateLogic1(List<Integer> list) {
		List<Integer> uni = new ArrayList<Integer>();
		for (Integer i : list) {
			if (!uni.contains(i))
				uni.add(i);
		}
		return uni;
	}
	
	public static List<Integer> removeElementFromList(List<Integer> list){
		// This is a clever way to create the iterator and call iterator.hasNext() like
		// you would do in a while-loop. It would be the same as doing:
		// Iterator<Integer> iterator = list.iterator();
		//	while (iterator.hasNext()) {
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			Integer no = it.next();
			if(no == 1)
				it.remove();
		}
		
		/*
		 for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer string = iterator.next();
			if (string==1 ) {
				// Remove the current element from the iterator and the list.
				iterator.remove();
			}
		}
		*/
		return list;
	}
}
