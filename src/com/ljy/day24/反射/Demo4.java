package com.ljy.day24.反射;

import java.lang.reflect.Method;

/**
 * <pre>
 * 调用方法
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月29日
 */
public class Demo4 {
	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("com.ljy.day24.反射.Person");
			//1,非静态的无参
			fun1(cls);
			//2.非静态的有参
			fun2(cls);
			//3.静态无参
			fun3(cls);
			//4.静态有
			fun4(cls);
		} catch (Exception e) {
		}
	}

	private static void fun4(Class<?> cls) {
		try {
			Method method = cls.getMethod("play",String.class);
			method.invoke(null,"篮球");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void fun3(Class<?> cls) {
		try {
			Method method = cls.getMethod("play");
			method.invoke(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void fun2(Class<?> cls) {
		try {
			Object object = cls.newInstance();
			Method method = cls.getMethod("eat", String.class);
			method.invoke(object, "苹果");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void fun1(Class<?> cls) {
		try {
			Object object = cls.newInstance();
			Method method = cls.getMethod("run");
			method.invoke(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
