package com.ljy.day13;

import java.util.TreeSet;
@SuppressWarnings({"unchecked","rawtypes"})
public class MyTreeSet {
	
	public static void main(String[] args) {
		TreeSet set = new TreeSet<>();
		//set再存储字符串的时候,可以实现自动排序和去重
		//原因:字符串实现了Comparable借口中的compareTo方法,String调用compareTo的地方是add方法.
		//默认是字典升序排序
		set.add(new Dog1("zhangsan", 12));
		set.add(new Dog1("lisi", 13));
		set.add(new Dog1("wangwu", 14));
		set.add(new Dog1("zhaoliu", 15));
		set.add(new Dog1("x", 15));
		set.add(new Dog1("zhaoliu", 16));
		
		System.out.println(set);
	}

}

@SuppressWarnings("rawtypes")
class Dog1 implements Comparable{
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
	public Dog1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Object o) {
		if (o instanceof Dog1) {
			Dog1 dog1 = (Dog1) o;
			int num = -dog1.age+this.age;
			return num==0?name.compareTo(dog1.name):num;
		}
		return 0;
	}
	
}
