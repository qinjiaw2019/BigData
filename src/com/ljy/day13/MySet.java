package com.ljy.day13;

import java.util.HashSet;
import java.util.Set;

public class MySet {
	public static void main(String[] args) {
		Set<Dog>set = new HashSet<>();
		set.add(new Dog("金毛", 13));
		set.add(new Dog("金毛", 14));
		set.add(new Dog("泰迪", 13));
		set.add(new Dog("金毛", 16));
		System.out.println(set);
		
	}
	
}



class Dog{
	String name;
	int age;
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
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	//可以根据自己的要求判断如何去重
	//现在根据年龄和姓名去重
	@Override
	public int hashCode() {
		return name.hashCode()+age*1000;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Dog) {
			Dog dog = (Dog)obj;
			return age==dog.age&&name.contentEquals(dog.name);
		}
		return super.equals(obj);
	}
	
}