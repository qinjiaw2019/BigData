package com.ljy.day24.反射;

public class Person {
	private String name;
	private int age;
	private String sex;

	public Person(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public Person() {
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	public void run() {
		System.out.println("run");
	}
	
	public void eat(String apple) {
		System.out.println("eat:"+apple);
	}
	
	public static void play() {
		System.out.println("Play");
	}
	
	public static void play(String something) {
		System.out.println("Play:"+something);
	}
}
