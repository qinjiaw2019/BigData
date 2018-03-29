package com.ljy.day24.反射;

import java.lang.reflect.Field;

/**
 * 
 * <pre>
 * 给属性赋值
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月29日
 */
public class Demo3 {
	public static void main(String[] args) {
		//通过字节码文件
		try {
			Class<?> cls = Class.forName("com.ljy.day24.反射.Person");
			
			//调用Field相关方法得到属性
			Field nameField = cls.getDeclaredField("name");
			//相当于在重新设定当前的访问权限
			nameField.setAccessible(true);
			//通过字节码文件创建person对象
			Object p = cls.newInstance();
			
			//将Field属性给p,完成赋值
			//第一个参数是当前属性对应的对象,第二个参数是给其的值
			nameField.set(p, "张三");
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("===============反射获取值==================");
		getField();
	}

	private static void getField() {
		Person p = new Person();
		p.setAge(21);
		p.setName("张三");
		p.setSex("男");
		
		
		Class<? extends Person> cls = p.getClass();
		try {
			Field field = cls.getDeclaredField("name");
			field.setAccessible(true);
			System.out.println((String)field.get(p));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
