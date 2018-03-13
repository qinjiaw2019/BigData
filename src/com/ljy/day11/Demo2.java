package com.ljy.day11;

import java.util.Arrays;
import java.util.Random;

public class Demo2 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = r.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        //sort(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        long time = System.currentTimeMillis();
        /* int temp = 0;
       for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }*/

        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("castTime:" + (System.currentTimeMillis() - time));
    }



   /* //冒泡排序
    public static void bubbleSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){//控制的是整体的次数
            for(int j=0;j<arr.length-1-i;j++){//控制的是确定一个元素需要比较的次数
                if (arr[j]>arr[j+1]) {//利用^位运算符实现交换
                    arr[j] = arr[j] ^ arr[j+1];
                    arr[j+1] = arr[j] ^ arr[j+1];
                    arr[j] = arr[j] ^ arr[j+1];
                }
            }
        }
    }*/

   /* //选择排序
    public static void selectSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){//控制的是整体的次数
            for(int j=i;j<arr.length-1;j++){//控制的是确定一个元素需要比较的次数
                if (arr[i]>arr[j+1]) {//利用^位运算符实现交换
                    arr[i] = arr[i] ^ arr[j+1];
                    arr[j+1] = arr[i] ^ arr[j+1];
                    arr[i] = arr[i] ^ arr[j+1];
                }
            }
        }
    }*/


    //冒泡排序
    public static void bubbleSort(int[] aar) {
        for (int i = 0; i < aar.length - 1; i++) {
            for (int j = 0; j < aar.length - 1 - i; j++) {
                if (aar[j] > aar[j + 1]) {
                    aar[j] = aar[j] ^ aar[j + 1];
                    aar[j + 1] = aar[j] ^ aar[j + 1];
                    aar[j] = aar[j] ^ aar[j + 1];
                }
            }
        }
    }

    //选择排序
}
