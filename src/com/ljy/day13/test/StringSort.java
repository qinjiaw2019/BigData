package com.ljy.day13.test;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class StringSort {
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
		});
		Collections.addAll(set, "12","23","13","45");
		System.out.println(set);
	}
	
}
