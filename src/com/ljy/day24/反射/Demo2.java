package com.ljy.day24.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <pre>
 * 通过字节码文件获取实例对象
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月29日
 */
@SuppressWarnings({"unused"})
public class Demo2 {
	public static void main(String[] args) {
		//普通方法获取对象
		Person person = new Person();
		//通过字节码的方式
		
		//1.通过无参的构造方法创建对象
		fun1();
		//2.通过有参的构造得到创建对象
		fun2();
	}

	private static void fun2() {
		try {
			Class<?> cls = Class.forName("com.ljy.day24.反射.Person");
			//这里的参数是构造方法中参数的类型
			//简单数据类型也有字节码文件,表示方式是类型.class
			Constructor<?> constructor = cls.getConstructor(String.class,int.class,String.class);
			//调用构造方法创建对象
			Object object = constructor.newInstance("张三",21,"男");
			System.out.println(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void fun1() {
		try {
			//获取字节码文件对象
			Class<?> cls = Class.forName("com.ljy.day24.反射.Person");
			//创建Person类型的实例对象
			//相当于在方法的内部调用了无参的构造方法
			//Object obj = cls.newInstance();
			Constructor<?> constructor = cls.getConstructor();
			Object object = constructor.newInstance();
			System.out.println(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
