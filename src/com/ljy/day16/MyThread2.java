package com.ljy.day16;

public class MyThread2 {
	public static void main(String[] args) {
		//创建4个线程
		Seller seller1 = new Seller();
		Seller seller2 = new Seller();
		Seller seller3 = new Seller();
		Seller seller4 = new Seller();
		seller2.start();
		seller3.start();
		seller4.start();
		seller1.start();
	}
}

class Seller extends Thread{
	
	private static int num = 20;
	
	@Override
	public void run() {
		for(int i = 0;i<20 && num>=0;i++) {
			System.out.println(Thread.currentThread()+" "+num--);
		}
	}
}