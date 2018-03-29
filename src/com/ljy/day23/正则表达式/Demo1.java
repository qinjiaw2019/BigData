package com.ljy.day23.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {
	public static void main(String[] args) {
		String str = "ereaa(333) 345-1245你好 快乐啊(333) 345-1245eqrewq";
		String regex = "\\(\\d{3}\\)\\s\\d{3}-\\d{4}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
