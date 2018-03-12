package com.ljy.day11;

import java.util.Arrays;
import java.util.Random;

public class Demo2 {
    public static void main(String[] args){
        Random r = new Random();
        int[]array = new int[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = r.nextInt(221)+2;
        }
        System.out.println(Arrays.toString(array));
        sort(array);
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
            for (int j = i+1; j < array.length; j++) {
                if (array[i]>array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("castTime:" + (System.currentTimeMillis() - time));
    }

}
