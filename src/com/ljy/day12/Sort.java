package com.ljy.day12;

import java.util.Arrays;
import java.util.Random;

public class Sort {
	public static void main(String[] args) {
		Random random = new Random();
		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = random.nextInt(20);
		}
		// System.out.println("冒泡排序前");
		// System.out.println(Arrays.toString(array));
		// System.out.println("冒泡排序后");
		// bubbleSort(array);
		// System.out.println(Arrays.toString(array));
		System.out.println("选择排序前");
		System.out.println(Arrays.toString(array));
		System.out.println("选择排序后");
		selectSort(array);
		System.out.println(Arrays.toString(array));
	}

	// 1.冒泡排序
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					array[j] = array[j] ^ array[j + 1];
					array[j + 1] = array[j + 1] ^ array[j];
					array[j] = array[j] ^ array[j + 1];
				}
			}
		}

	}

	// 2.选择排序
	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					array[i] = array[i] ^ array[j];
					array[j] = array[j] ^ array[i];
					array[i] = array[i] ^ array[j];
				}
			}
		}
	}
}
