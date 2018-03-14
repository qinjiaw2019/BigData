package com.ljy.day13.comparator;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class StringComparatorTest {
	public static void main(String[] args) {
		Set<String>set= new TreeSet<>(new StringComparator());
		Collections.addAll(set, "a","aa","bbb","cccc","bbbb","ddddd");
		System.out.println(set);
	}
}
