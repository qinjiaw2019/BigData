package com.ljy.day21.重新认识HashSet;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<Person>set = new HashSet<>();
		Person p1 = new Person("张三", 10);
		Person p2 = new Person("张三", 10);
		set.add(p1);
		set.add(p2);
		System.out.println(set);
	}
}
