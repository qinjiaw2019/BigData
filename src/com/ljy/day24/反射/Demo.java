package com.ljy.day24.反射;

/**
 * <pre>
 * 反射:动态获取类的字节码文件兑现,并对其成员进行抽象
 * 
 * 整体:通过字节码文件对象创建实例对象
 * 工作方式:
 * 1.创建字节码文件对象
 * 2.通过字节码文件对象得到对应的实例对象
 * 3.给属性赋值(通过从属性中抽象出来的类Field)
 * 4.调用方法(通过从方法中抽象出来的类Method)
 * 
 * 
 * 获取字节码文件(.class):
 * a.通过Object 类提供的方法
 * 	Class<?> getClass();得到字节码文件
 * 	缺点:这种方式需要用对象来获取字节码文件
 * b.每种属性都有一个class属性,通过它得到字节码文件
 * 	缺点:必须使用这个类型的类名    不可取
 * c.Class类似提供的静态方法forName(类的全路径名)
 * 	优点:只需要提供一个需要创建类的全路径类名
 * 	总结:通过字符串的方式找到工程中实际存在的类
 * </pre>
 * 
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月29日
 */
public class Demo{
	public static void main(String[] args) {
		fun3();
	}
	
	//a.通过Object 类提供的方法
	//在jvm中一个类始终只有一个字节码文件
	public void fun1() {
		Person person = new Person();
		@SuppressWarnings("unused")
		Class<? extends Person> cls = person.getClass();
	}
	//b.每种属性都有一个class属性,通过它得到字节码文件
	public void fun2() {
		@SuppressWarnings("unused")
		Class<?>cls = Person.class;//字节码文件类
	}
	
	public static void fun3() {
		try {
			//字节码文件,参数是类的全路径名
			//注意点:字符串必须对应一个真实存在的类
			Class<?> cls = Class.forName("com.ljy.day24.反射.Person");
			System.out.println(cls);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

