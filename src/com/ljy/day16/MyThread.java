package com.ljy.day16;

//直接通过Thread类对象创建线程,一般不这样创建
//   -----因为这样创建的线程没有执行任务,没有意义

//4个售票员同时买票
public class MyThread {
	public static void main(String[] args) {
		// 方式1
		/*
		 * Thread thread1 = new Thread();// 创建的一个线程 Thread thread2 = new Thread();//
		 * 创建的第二个线程
		 * 
		 * // 让线程开始工作工作的方法:start(); thread1.start();// 线程1开始工作 thread2.start();//
		 * 线程2开始工作 System.out.println(Thread.activeCount()); while (Thread.activeCount()
		 * > 1) { System.out.println("活跃线程数:" + Thread.activeCount()); }
		 * 
		 * ChildThread childThread = new ChildThread(); childThread.setName("我自己创建的线程");
		 * childThread.start();
		 * 
		 * ChildThread childThread1 = new ChildThread();
		 * childThread1.setName("我自己又创建的线程"); childThread1.start();
		 */

		// 线程与任务分离的方式
		// 创建唯一任务
		Ticket ticket = new Ticket();

		Thread thread2 = new Thread(ticket);
		Thread thread3 = new Thread(ticket);
		Thread thread4 = new Thread(ticket);
		Thread thread1 = new Thread(ticket);
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}

/**
 * 独立任务
 * 
 * @author lijiayan
 *
 */
class Ticket implements Runnable {
	private Object object = new Object();
	private int num = 20;

	@Override
	public void run() {
		synchronized (object) {
			while (num >= 0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " " + num--);
			}

		}
		System.out.println(Thread.currentThread().getName() + " 票卖完了");
	}

}

class ChildThread extends Thread {
	/**
	 * 该方法就是该线程的任务区
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

}