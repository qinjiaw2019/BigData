package com.ljy.day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class MyCollection {
	private Collection<Object> c = new ArrayList<>();
	public static void main(String[] args) {
		MyCollection mc = new MyCollection();
		mc.add();
		mc.iterator();
		System.out.println("=========ArrayList=========");
		myList();
		System.out.println("=========vector============");
		myVector();
		System.out.println("=========LinkedList========");
		myLinkedList();
	}
	
	private void add() {
		c.add("java");
		c.add("c/c++");
		c.add("php");
		c.add("python");
		c.add(new Object());
		c.add(1);
	}
	
	private void iterator() {
		Iterator<Object> it = c.iterator();
		while(it.hasNext()) {
			Object object = it.next();
			if (object instanceof String) {
				System.out.println(object);
			}
		}
	}
	
	public static void myList() {
		List<String>list = new ArrayList<>();
		list.add("java");
		list.add("c++");
		list.add("php");
		ListIterator<String> it = list.listIterator();
		while(it.hasPrevious()) {
			String next = it.previous();
			if ("java".equals(next)) {
				list.remove(next);
			}
		}
		System.out.println(list);
	}

	
	public static void  myVector() {
		Vector<String>vector = new Vector<>();
		vector.add("java");
		vector.add("c++");
		vector.add("python");
		//通过没举器实心遍历,获取没举器对象
		Enumeration<String> elements = vector.elements();
		while (elements.hasMoreElements()) {
			String string = (String) elements.nextElement();
			System.out.println(string);
		}
	}
	
	public static void  myLinkedList() {
		//List<String>list = new LinkedList<>();
		//Collections.addAll(list, "java","php","c++");
		//System.out.println(list);
		LinkedList<String>list = new LinkedList<>();
		list.add("Java");
		list.addFirst("C++");//再开头添加
		list.addLast("php");//再末尾添加
		System.out.println(list);
		
		//jdk1.6+
		list.offerFirst("python");//在开头添加
		list.offerLast("Android");
		
		//取值,将当前的值取出并返回
		list.clear();
		System.out.println(list.peekFirst());//如果没有取到值,返回null
		//System.out.println(list.getFirst());//使用该方法,如果没有取到值,直接报异常
		
		//删除
		//System.out.println(list.removeFirst());如果没有删除的值,报异常
		System.out.println(list.pollFirst());//如果没有删除的值,返回null
		
	}
}
