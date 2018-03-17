package com.ljy.day15;

public class Base {
	private String name = "base";
    public Base() {
        tellName();//子类有重写,调子类的
        printName();//子类有重写,调子类的
    } 
    public void tellName() {
        System.out.println("Base tell name: " + name);
    } 
    public void printName() {
        System.out.println("Base print name: " + name);
    }
}
