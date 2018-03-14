package com.ljy.day13.fanxing;

/**
 * 1,让当前的Tool类可以提供给多种类型的对象使用,
 * 2,不用再进行类型转换,避免类型转换错误
 * @author lijia
 *
 * @param <E>:E代表任意一个Person的子类类型
 * 本身代表一种引用数据类型
 * 该工具只让人用.
 * 
 * 泛型的使用:
 * 在类上确定的泛型,可以在类内部的方法上直接使用
 */
public class Tool<E extends Person> {
	private E e;

	public E getObj() {
		return e;
	}

	public void setObj(E e) {
		this.e = e;
	}
	//静态方法不能使用类申明的泛型
	/*public static void Show(E e) {
		
	}*/
	
	public static<F extends Person>void show(F f){
		System.out.println(f.toString());
	}
}
