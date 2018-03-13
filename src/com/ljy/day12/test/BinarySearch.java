package com.ljy.day12.test;

public class BinarySearch {
	
	public static void main(String[] args) {
		//测试二分查找
		int num = 55;
		int[]array = {1,12,27,28,28,30,35,37,40,55,65};
		int index = new BinarySearch().binarySearch(num, array);
		if (index>=0) {
			System.out.println(num+"再数组中的第"+index);
		}else {
			System.out.println("数组中没有该元素");
		}
	}
	/**
	 * 二分查找
	 * @param num
	 * @param array
	 * @return
	 */
	public int binarySearch(int num,int [] array) {
		
		int start = 0;
		int end = array.length-1;
		while(start<=end) {
			int mid = start +(end-start)/2;
			if(array[mid]>num) {
				end = mid-1;
			}else if(num>array[mid]) {
				start = mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}
}
