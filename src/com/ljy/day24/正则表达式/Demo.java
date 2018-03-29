package com.ljy.day24.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
	/*
	 * 使用
	 * 1.匹配
	 * 使用的是String类中的boolean matches(String regex)方法
	 * 2.切割
	 * 使用的是String类中的 String[] split(String regex)方法
	 * 依据正则表达式的字符串来切割
	 * 3.替换
	 * 使用的是String类中的 String replaceAll(String regex, String replacement)  
	 * 把字符串中符合正则表达式的内容替换成第二个参数的内容
	 * 4.获取
	 * 
	 */

	public static void main(String[] args) {
		pipei1();
		String [] phones = {"12382303693","17682303693"};
		for(String phone:phones) {
			System.out.println(pipei2(phone));
		}
		System.out.println("=================切割=============");
		qiege();
		
		System.out.println("=======替换========");
		tihuam();
		System.out.println("========获取=============");
		huoqu();
	}

	
	private static void huoqu() {
		//要求获取连续超过4个字符的子字符串
		String string = "dsafds dsa dfsa   dfsafds fdsa";
		//在这个要求中一下两种regex都可以实现
		//匹配任何空白字符，包括空格、制表符、换页符等。与 [\f\n\r\t\v] 等效。
		//String regex = "\\S{4,}";   //\\S表示出匹配任何非空白字符。与 [^\f\n\r\t\v] 等效。
		String regex = "[a-zA-Z]{4,}";
		//相当于将正则表达式换了一种表达式方式,进行了简单的转化,但是Pattern本身不具有获取数据的能力
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(string);
		//判断是否有符合当前表达式的内容,相当于itarater的hasnext()
		while(matcher.find()) {
			System.out.println(matcher.group());//matcher.group() 相当于itarater的next()
		}
		
	}


	private static void tihuam() {
		//将连续超过5个数字的替换成*****
		String str = "fshdsk4354fdsajklnklfdsa234132nk21vnks2 kls2134vnxskv0000000lkdsafjbfdsl;";
		String regex = "\\d{4,}";
		String replaceAll = str.replaceAll(regex, "*****");
		System.out.println(replaceAll);
		
	}


	private static void qiege() {
		String str = "gougou    maomao         anbei   telangpu";
		String[] strs = str.split("\\s+");//切割3-1次
		for(String s:strs) {
			System.out.println(s);
		}
		
		System.out.println("---------------");
		String str1 = "fhdajkl.fsbaj.djkaJLK.FJLnfj.fnsjklfds";
		for(String s:str1.split("\\.")) {//.匹配除"\r\n"之外的任何单个字符
			System.out.println(s);
		}
	}


	private static boolean pipei2(String phone) {
		//要求匹配手机号码的规则
		String regex = "^1[3-9]\\d{9}$";//[3-9]表示在3-9之间的一个,{9}表示9位,{9,11}表示9或11位
		return phone.matches(regex);
	}


	private static void pipei1() {
		//要求在bk之间有0个或多个o
		String s = "booooooook";
		String regex = "^bo*k$";  //o*代表0个或多个o   o+代表一个或多个o ^表示开始  $表示结尾  ?表示0次或1次
		System.out.println(s.matches(regex));
	}
}
