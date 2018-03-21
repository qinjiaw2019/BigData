package com.ljy.day18.反射;

/**
 * 动态给属性赋值
 * <pre>
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月21日
 */
public class Demo3 {
	//动态获取类并给属性赋值
	public static void main(String[] args) {
		//得到字节码文件
		try {
			@SuppressWarnings({ "unchecked", "unused" })
			Class<Person> clazz = (Class<Person>) Class.forName("com.ljy.day18.反射.Person");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
