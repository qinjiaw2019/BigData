package com.ljy.day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * contains工作原理:添加元素的时候,会让当前的元素与已经添加的list2中的每一个元素通过equals比较,比较过程
 * 中如果有true返回,说明整个contains方法的返回结果就是true,只有所有的比较结果都是false,contains返回结果才是fasle
 * 而当返回结果是true的时候,说明list2中已经包含了当前的元素.则不往list2中添加当前元素,如果是false,则往list2中添加当前元素
 * 自定义的类,需要自己重写equals方法
 * @author lijia
 *
 */
public class DerepeatDemo {
	public static void main(String[] args) {
		ArrayList<String>list = new ArrayList<>();
		Collections.addAll(list, "java1","java2","java3","java4","java5","java5");
		System.out.println(list);
		//用来存放不重复的数据
		ArrayList<String>tempList = new ArrayList<>();
//		for(String str:list) {
//			if (!tempList.contains(str)) {
//				tempList.add(str);
//			}
//		}
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String string = iterator.next();
			if (!tempList.contains(string)) {
				tempList.add(string);
			}
		}
		
		System.out.println(tempList);
	}
	
	
}
