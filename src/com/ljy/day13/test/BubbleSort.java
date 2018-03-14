package com.ljy.day13.test;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = new int[10];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
		System.out.println("排序前:" + Arrays.toString(array));
		bubbleSort(array);
		System.out.println("排序后:" + Arrays.toString(array));
	}

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

}
