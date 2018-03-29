package com.ljy.day24.test;

import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		Person p = new Person("张三");
		// 将p的地址值拷贝一份给实参
		// 拷贝的地址值与原来的值除了同时指向一个对象以外,没有其他关系
		change(p);
		System.out.println(p);
		System.out.println("============================");
		int[] array = { 11, 43, 23, 32, 78, 90, 45,  47 ,68,12};
		Sort sort = new Sort();
		// sort.bubbleSort(array);
		sort.selectSort(array);
		System.out.println(Arrays.toString(array));
		int num = 49;
		System.out.println(num + " "+sort.binerySearch(num, array));
	}

	private static void change(Person p) {
		// 操作的是拷贝的值,这里重新将一个新值赋值给p,与TODO中的p没有关系
		p = new Person("李四");
		// 操作的是拷贝值所指向的那个堆中的对象.

		p.name = "李四";
		//Arrays.binarySearch(a, key)
	}

}

class Sort {
	// 冒泡排序
	public void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					array[j] = array[j] ^ array[j + 1];
					array[j + 1] = array[j + 1] ^ array[j];
					array[j] = array[j] ^ array[j + 1];
				}
			}
		}
	}

	public int binerySearch(int num, int[] array) {
		int low = 0;
		int up = array.length-1;
		while(low<=up) {
			int mid = (up+low)/2;
			if(array[mid]>num) {
				up = mid-1;
			}else if(array[mid]<num) {
				low = mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}

	// 选择排序
	public void selectSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					array[i] = array[i] ^ array[j];
					array[j] = array[j] ^ array[i];
					array[i] = array[i] ^ array[j];
				}
			}
		}
	}

}

class Person {
	String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

}