package com.ljy.day14;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MyMap {
	public static void main(String[] args) {
		//一般用String作为键类型
		Map<String, String>map = new HashMap<>();
		//1.添加数据
		map.put("01", "java");
		map.put("02", "java2");
		map.put("03", "java3");
		System.out.println(map);
		String remove = map.remove("03");
		System.out.println(remove);
		System.out.println("size:"+map.size());
		//取出所有的值
		Collection<String> values = map.values();
		System.out.println(values);
		
		Set<Entry<String,String>> entrySet = map.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			String key = next.getKey();
			String value = next.getValue();
			System.out.println("key:"+key+" "+"value:"+value);
		}
	}
}
