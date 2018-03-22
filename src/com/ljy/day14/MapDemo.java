package com.ljy.day14;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
	public static void main(String[] args) {
		System.out.println(sort("fhdjkhjafdjsklfdsjklfdjskalfsjk"));
		// System.out.println(order("aaacccbbfffff"));
	}

	public static String order(String str) {
		if (str == null) {
			return null;
		}
		char[] array = str.toCharArray();
		char temp;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		Map<Character, Integer> map = new /* Linked */HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (!map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				Integer integer = map.get(array[i]);
				map.put(array[i], integer + 1);
			}
		}

		Set<Entry<Character, Integer>> set = map.entrySet();
		Iterator<Entry<Character, Integer>> iterator = set.iterator();
		StringBuffer sBuffer = new StringBuffer();
		while (iterator.hasNext()) {
			Entry<Character, Integer> next = iterator.next();
			sBuffer.append(next.getKey() + "(" + next.getValue() + ")");
		}
		return sBuffer.toString();
	}

	public static String sort(String str) {
		// 1.转数组
		char[] array = str.toCharArray();
		// 2.将字符存入map中
		// 让字母作为key,让字母的数量作为value
		//HashMap不能实现排序,TreeMap可以实现排序
		Map<Character, Integer> map = new TreeMap<>();
		// 遍历字符数组
		//由于Character有自动的排序功能(实现了Comparable接口,也重写了HashCode和equale方法)
		//又对于map来说,是根据key进行排序的
		for (int i = 0;  i < array.length; i++) {
			// 过滤,只要字母
			if ((array[i] >= 'a' && array[i] <= 'z') || (array[i] >= 'A' && array[i] < 'Z')) {
				Integer value = map.get(array[i]);
				if (value==null) {
					map.put(array[i], 1);
				}else {
					map.put(array[i], value+1);
				}
			}
		}
		//拼接字符串
		Set<Entry<Character,Integer>> entrySet = map.entrySet();
		Iterator<Entry<Character, Integer>> iterator = entrySet.iterator();
		StringBuffer sBuffer = new StringBuffer();
		while(iterator.hasNext()) {
			Entry<Character, Integer> next = iterator.next();
			Character key = next.getKey();
			Integer value = next.getValue();
			sBuffer.append(key).append("(").append(value).append(")");
		}
		return sBuffer.toString();
	}
}
