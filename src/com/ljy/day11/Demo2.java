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

    @SuppressWarnings("unused")
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



   /* //鍐掓场鎺掑簭
    public static void bubbleSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){//鎺у埗鐨勬槸鏁翠綋鐨勬鏁�
            for(int j=0;j<arr.length-1-i;j++){//鎺у埗鐨勬槸纭畾涓�涓厓绱犻渶瑕佹瘮杈冪殑娆℃暟
                if (arr[j]>arr[j+1]) {//鍒╃敤^浣嶈繍绠楃瀹炵幇浜ゆ崲
                    arr[j] = arr[j] ^ arr[j+1];
                    arr[j+1] = arr[j] ^ arr[j+1];
                    arr[j] = arr[j] ^ arr[j+1];
                }
            }
        }
    }*/

   /* //閫夋嫨鎺掑簭
    public static void selectSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){//鎺у埗鐨勬槸鏁翠綋鐨勬鏁�
            for(int j=i;j<arr.length-1;j++){//鎺у埗鐨勬槸纭畾涓�涓厓绱犻渶瑕佹瘮杈冪殑娆℃暟
                if (arr[i]>arr[j+1]) {//鍒╃敤^浣嶈繍绠楃瀹炵幇浜ゆ崲
                    arr[i] = arr[i] ^ arr[j+1];
                    arr[j+1] = arr[i] ^ arr[j+1];
                    arr[i] = arr[i] ^ arr[j+1];
                }
            }
        }
    }*/


    //鍐掓场鎺掑簭
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

    //閫夋嫨鎺掑簭
}
