package com.ljy.day12;

public class TestQueue {
	public static void main(String[] args) {
		Queue<String>queue = new Queue<>();
		queue.push("java");
		queue.push("c++");
		queue.push("python");
		System.out.println("size:"+queue.getSize());
		System.out.println("isEmpty:"+queue.isEmpty());
		System.out.println(queue);
		System.out.println(queue.pull());
		System.out.println("===============clear========");
		queue.clear();
		System.out.println("size:"+queue.getSize());
		System.out.println("isEmpty:"+queue.isEmpty());
		System.out.println(queue.pull());
	}
}
