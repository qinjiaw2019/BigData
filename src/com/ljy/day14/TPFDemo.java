package com.ljy.day14;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 通配符?Demo
 * 
 * @author lijia
 *
 */
public class TPFDemo {
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<>();
		Collections.addAll(set, "java1", "java2", "java3", "java4");
		//iterator(set);
		iterator1(set);
	}

	// 遍历
	public static <E> void iterator(Collection<E> e) {
		Iterator<E> it = e.iterator();
		while (it.hasNext()) {
			E e2 = it.next();
			System.out.println(e2);
		}
	}

	// 遍历
	public static<E> void iterator1(Collection<?> e) {
		Iterator<?> it = e.iterator();
		while (it.hasNext()) {
			//不能使用?直接定义具体的变量
			//? next = it.next();
			System.out.println(it.next());
		}
	}
}
