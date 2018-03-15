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
		String sourse = "12,23,13,45,33";
		Collections.addAll(set,sourse.split(","));
		System.out.println(set);
	}

}
