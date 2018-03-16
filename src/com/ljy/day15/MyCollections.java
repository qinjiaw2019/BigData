package com.ljy.day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyCollections {
	public static void main(String[] args) {
		ArrayList<String>list = new ArrayList<>();
		Collections.addAll(list, "aaaa","java","a","abc","Hello world");
		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int len = o1.length()-o2.length();
				return len==0?o1.compareTo(o2):len;
			}
		};
		Collections.sort(list, comparator);
		System.out.println(list);
		Comparator<String> reverseOrder = Collections.reverseOrder(comparator);
		Collections.sort(list, reverseOrder);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(Collections.max(list, comparator));
		
	}
}
