package com.ljy.day17.生产者与消费者;

public class Test {
	public static void main(String[] args) {
		Person person = new Person();
		Input in = new Input(person);
		Output out = new Output(person);
		
		Thread inThread = new Thread(in);
		Thread outThread = new Thread(out);
		inThread.start();
		outThread.start();
	}
}
