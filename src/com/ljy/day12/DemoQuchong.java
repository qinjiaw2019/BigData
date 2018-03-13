package com.ljy.day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class DemoQuchong {
	public static void main(String[] args) {
		ArrayList<Person>list = new ArrayList<>();
		Collections.addAll(list, 
				new Person("张三", 12),
				new Person("李四", 13),
				new Person("王五", 12),
				new Person("赵六", 14),
				new Person("赵六", 14));
		System.out.println(list);
		ArrayList<Person>tempList = new ArrayList<>();
		Iterator<Person> iterator = list.iterator();
		while(iterator.hasNext()) {
			Person person = iterator.next();
			if (!tempList.contains(person)) {
				tempList.add(person);
			}
		}
		System.out.println(tempList);
	}
}

class Person{
	 private String name;
	 private int age;
	
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person person = (Person)obj;
			return (person.getName().equals(this.name))&&(person.getAge()==this.age);
		}
		return super.equals(obj);
	}
}
