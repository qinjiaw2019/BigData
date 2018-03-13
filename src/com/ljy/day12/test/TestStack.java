package com.ljy.day12.test;

public class TestStack {
	public static void main(String[] args) {
		Stack<String>stack = new Stack<>();
		stack.pushStack("Hello");
		stack.pushStack("World");
		stack.pushStack("!");
		System.out.println("栈目前的元素个数:"+stack.getSize());
		System.out.println(stack.popStack());
		System.out.println("清空栈......");
		System.out.println("栈是否为空:"+stack.isEmpty()+" Size:"+stack.getSize());
	}
}
