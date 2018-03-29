package com.ljy.day23.正则表达式;

import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		int[]array = {20,2,3,15,89};
		//bubbleSort(array);
		//System.out.println(Arrays.toString(array));
		selectSort(array);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 选择排序
	 * @param array
	 */
	private static void selectSort(int[] array) {
		for(int i = 0;i<array.length-1;i++) {
			for(int j = i+1;j<array.length;j++) {
				if(array[i]<array[j]) {
					array[i] = array[i] ^ array[j];
					array[j] = array[j] ^ array[i];
					array[i] = array[i] ^ array[j];
				}
			}
		}
	}

	/**
	 * 冒泡排序
	 * @param array
	 */
	@SuppressWarnings("unused")
	private static void bubbleSort(int[] array) {
		for(int i = 0;i<array.length-1;i++) {
			for(int j = 0;j<array.length-1-i;j++) {
				if(array[j]<array[j+1]) {
					array[j] = array[j] ^array[j+1];
					array[j+1] = array[j+1] ^ array[j];
					array[j] = array[j] ^array[j+1];
				}
			}
		}
	}
	
	
}
