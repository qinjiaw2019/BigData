package com.ljy.day18.反射;

/**
 * 
 * <pre>
 * 反射:动态获取类(字节码文件,并对其成员进行运行)
 * Person.class
 * 
 * 获取class的方法
 * 1.使用Object提供的Class<?>getClass()方法得到字节码文件
 * 	这种方式需要事先存在对象
 * 2.每种数据类型都有一个class属性,通过该属性得到的就是字节码文件对象
 * 	这种方式需要这种类型事先存在
 * 3.使用Class的静态方法fromName(String),参数是要获取字节码的类的全路径名(包名+类名)
 * 	这种方式只需要提供一个字符串
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月21日
 */
public class Demo {

	public static void main(String[] args) {
		fun1();
		fun3();
	}
	
	
	@SuppressWarnings("unused")
	public static void fun2() {
		
		Class<Person> clazz = Person.class;
	}
	
	public static void fun1() {
		Person person = new Person();
		Class<? extends Person> clazz = person.getClass();
		
		Person person1 = new Person();
		Class<? extends Person> clazz1 = person1.getClass();
		
		System.out.println(clazz==clazz1);
	}
	
	public static void fun3() {
		try {
			Class<?> clazz = Class.forName("com.ljy.day18.反射.Person");
			System.out.println(clazz.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
