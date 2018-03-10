package com.ljy.day10.thread.mythread;

public class MyThread2 extends Thread{
	private int i;
	
	public MyThread2(int i) {
		super();
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println(this.i);
	}
}
