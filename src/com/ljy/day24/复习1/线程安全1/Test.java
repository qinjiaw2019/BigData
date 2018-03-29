package com.ljy.day24.复习1.线程安全1;

public class Test {
	public static void main(String[] args) {
		Person p = new Person();
		Thread in = new Thread(new Input(p));
		Thread out = new Thread(new Output(p));
		in.start();
		out.start();
	}
}
