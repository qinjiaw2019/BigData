package com.ljy.day18.反射;

import java.lang.reflect.Constructor;

/**
 * <pre>
 * 动态得到字节码文件并创建对象
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月21日
 */
public class Demo2 {
	public static void main(String[] args) {
		createObj2();
	}
	
	public static void createObj() {
		try {
			//得到字节码文件对象
			Class<?> clazz = Class.forName("com.ljy.day18.反射.Person");
			//创建对象
			Object obj = clazz.newInstance();
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用带参数的构造方法创建对象
	 */
	public static void createObj2() {
		try {
			//得到字节码文件对象
			Class<?> clazz = Class.forName("com.ljy.day18.反射.Person");
			//得到带参数的构造方法对象
			Constructor<?> constructor = clazz.getConstructor(String.class,int.class);
			Person obj = (Person) constructor.newInstance("张三",21);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
