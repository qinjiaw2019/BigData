package com.ljy.day21.其他流对象;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * <pre>
 * Properties:本质上是一个HashTable(线程安全的)集合,存储的是属性,属性以键值对的形式进行存储
 * key和value 必须是字符串,不需要使用泛型
 * 
 * Properties的使用需要与流相结合
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月26日
 */
public class Demo3 {
	public static void main(String[] args) {
		//fun1();
		//fun2();
		//fun3();
		fun4();
	}

	private static void fun4() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(".\\src\\com\\ljy\\day21\\config.properties"));
			properties.list(System.out);
			properties.setProperty("age", "35");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
