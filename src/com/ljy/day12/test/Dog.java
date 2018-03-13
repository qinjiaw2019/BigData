package com.ljy.day12.test;

public class Dog {
	private String name;
	private String age;
	
	public Dog(String name, String age) {
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Dog) {
			Dog dog = (Dog)obj;
			return dog.name.equals(name)&&dog.age.equals(age);
		}
		return super.equals(obj);
	}
}
