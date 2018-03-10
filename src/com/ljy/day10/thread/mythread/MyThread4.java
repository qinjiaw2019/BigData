package com.ljy.day10.thread.mythread;

public class MyThread4 extends Thread {
	private int count = 5;

	@Override
	public void run() {
		synchronized (this) {
			count--;
			System.out.println("ÓÉ"+currentThread().getName()+"¼ÆËã,count="+count);
		}
	}
	
	public static void main(String[] args) {
		MyThread4 myThread4 = new MyThread4();
		Thread a = new Thread(myThread4, "A");
		Thread b = new Thread(myThread4, "B");
		Thread c = new Thread(myThread4, "C");
		Thread d = new Thread(myThread4, "D");
		Thread e = new Thread(myThread4, "E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
		
	}
}
