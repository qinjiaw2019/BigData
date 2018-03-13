package com.ljy.day11;

public class NULL {
    public static void hahaha(){
        System.out.println("HelloWorld");
    }
    @SuppressWarnings("static-access")
	public static void main(String[] args){
        ((NULL) null).hahaha();
        //IllegalArgumentException;
        //NumberFormatException:
    }
}
