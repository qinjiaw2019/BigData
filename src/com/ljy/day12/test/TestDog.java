package com.ljy.day12.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestDog {
	public static void main(String[] args) {
		List<Dog>dogs = new ArrayList<>();
		Collections.addAll(dogs, new Dog("拉布拉多","1"),
				new Dog("金毛", "2"),
				new Dog("金毛","5"),
				new Dog("金毛","5"),
				new Dog("泰迪", "2"));
		System.out.println("去重前:"+dogs);
		List<Dog>temp = new ArrayList<>();
		Iterator<Dog> it = dogs.iterator();
		while (it.hasNext()) {
			Dog dog = it.next();
			if(!temp.contains(dog)) {
				temp.add(dog);
			}
		}
		System.out.println("去重后:"+temp);
	}
}
