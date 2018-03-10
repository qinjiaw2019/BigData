package com.ljy.day10.thread.test;

import com.ljy.day10.thread.mythread.MyThread;
import com.ljy.day10.thread.mythread.MyThread2;

public class Test {
	public static void main(String[] args) {
		test01();
		test02();
	}

	private static void test02() {
		MyThread2 t1 = new MyThread2(1);
		MyThread2 t2 = new MyThread2(2);
		MyThread2 t3 = new MyThread2(3);
		MyThread2 t4 = new MyThread2(4);
		MyThread2 t5 = new MyThread2(5);
		MyThread2 t6 = new MyThread2(6);
		MyThread2 t7 = new MyThread2(7);
		MyThread2 t8 = new MyThread2(8);
		MyThread2 t9 = new MyThread2(9);
		MyThread2 t10 = new MyThread2(10);
		MyThread2 t11 = new MyThread2(11);
		MyThread2 t12 = new MyThread2(12);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
	}

	private static void test01() {
		MyThread myThread = new MyThread();
		myThread.setName("MyThread");
		myThread.start();
		try {
			for(int i = 0;i<10;i++){
				int time = (int)(Math.random()*1000);
				Thread.sleep(time);
				System.out.println("main="+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
