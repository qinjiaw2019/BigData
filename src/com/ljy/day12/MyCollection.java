package com.ljy.day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyCollection {
	private Collection<Object> c = new ArrayList<>();
	public static void main(String[] args) {
		MyCollection mc = new MyCollection();
		mc.add();
		mc.iterator();
	}
	
	private void add() {
		c.add("java");
		c.add("c/c++");
		c.add("php");
		c.add("python");
	}
	
	private void iterator() {
		Iterator<Object> it = c.iterator();
		while(it.hasNext()) {
			Object object = it.next();
			System.out.println(object);
		}
	}
	

}
