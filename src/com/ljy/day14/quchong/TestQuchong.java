package com.ljy.day14.quchong;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class TestQuchong {
	public static void main(String[] args) {
		//testHashMap();
		//testTreeMap1();
		testTreeMap2();
	}

	@SuppressWarnings("unused")
	private static void testTreeMap1() {
		TreeMap<Person, String>map = new TreeMap<>();
		map.put(new Person("张三", 12), "张三");
		map.put(new Person("张三", 12), "张四");
		map.put(new Person("历史", 13), "历史");
		map.put(new Person("王五", 14), "王五");
		map.put(new Person("赵柳", 15), "赵柳");
		map.put(new Person("周期", 16), "周期");
		System.out.println(map);
	}

	//第一种去重排序
	@SuppressWarnings("unused")
	private static void testHashMap() {
		HashMap<Person, String>map = new HashMap<>();
		map.put(new Person("张三", 12), "张三");
		map.put(new Person("张三", 12), "张四");
		map.put(new Person("历史", 12), "历史");
		map.put(new Person("王五", 12), "王五");
		map.put(new Person("赵柳", 12), "赵柳");
		map.put(new Person("周期", 12), "周期");
		System.out.println(map);
	}
	
	//第二种去重排序
	private static void testTreeMap2() {
		TreeMap<Person, String>map = new TreeMap<>(new ComWidthPerson());
		map.put(new Person("张三", 12), "张三");
		map.put(new Person("张三", 12), "张四");
		map.put(new Person("历史", 13), "历史");
		map.put(new Person("王五", 14), "王五");
		map.put(new Person("赵柳", 15), "赵柳");
		map.put(new Person("周期", 16), "周期");
		System.out.println(map);
	}
	
	//自定义比较器
	private static class ComWidthPerson implements Comparator<Person>{

		@Override
		public int compare(Person o1, Person o2) {
			int num = o1.getAge() - o2.getAge();
			return num==0?o1.getName().compareTo(o2.getName()):num;
		}
		
	}
}
