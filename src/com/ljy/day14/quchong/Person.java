package com.ljy.day14.quchong;

public class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	public Person() {
		super();
	}
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
		if(obj instanceof Person) {
			Person person = (Person) obj;
			return (person.age == age) && (person.name.equals(name));
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return age*10000+name.hashCode();
	}
	
	@Override
	public int compareTo(Person o) {
		int num = age - o.age;
		return num==0?name.compareTo(o.getName()):num;
	}
}
