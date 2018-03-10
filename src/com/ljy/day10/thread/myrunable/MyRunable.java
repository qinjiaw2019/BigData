package com.ljy.day10.thread.myrunable;

public class MyRunable implements Runnable {

	@Override
	public void run() {
		System.out.println("运行中");
	}

	public static void main(String[] args) {
		new MyRunable().test();
		System.out.println("运行结束");
	}
	
	private void test(){
		Thread thread = new Thread(this);
		thread.start();
	}
}
