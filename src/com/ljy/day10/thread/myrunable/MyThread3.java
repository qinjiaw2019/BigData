package com.ljy.day10.thread.myrunable;

public class MyThread3 extends Thread {
	private int count = 5;

	
	public MyThread3(String name) {
		super();
		this.setName(name);
	}


	@Override
	public void run() {
		while(count>0){
			count--;
			System.out.println("”…"+currentThread().getName()+"º∆À„,count="+count);
		}
	}
	
	
	public static void main(String[] args) {
		MyThread3 a = new MyThread3("A");
		MyThread3 b = new MyThread3("B");
		MyThread3 c = new MyThread3("C");
		a.start();
		b.start();
		c.start();
	}
}
