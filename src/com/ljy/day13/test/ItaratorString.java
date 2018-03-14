package com.ljy.day13.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 遍历字符串
 * @author lijia
 *
 */
public class ItaratorString {
	public static void main(String[] args) {
		List<String>list = new ArrayList<>();
		Collections.addAll(list, "java1","java2","java3","java4","java5");
		for(String str:list) {
			System.out.println(str);
		}
	}
}
