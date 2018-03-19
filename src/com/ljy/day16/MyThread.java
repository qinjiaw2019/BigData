package com.ljy.day16;

//直接通过Thread类对象创建线程,一般不这样创建
//   -----因为这样创建的线程没有执行任务,没有意义

//4个售票员同时买票
/*
 * 产生负数的原因:
 * 	1.多个线程操作了一个数据
 * 	2.共享语句有多条,一个线程抢到cpu,没有执行完,cpu被抢走,当再次抢到cpu的时候,会执行后面的语句,造成错误的发生
 * 解决方案:
 * 	在代码中使用同步代码块(同步锁)
 * 	解释:在某一段任务中,同一时间只允许有一个线程执行任务,其他线程即使抢到cpu也无法进入代码块,
 * 	          只已经进入代码块的线程执行完后,其他线程才能执行这个任务
 * 对象锁的要求:1.必须是对象 2.必须被对个线程共享
 * 同步代码块特点:由于每次都要判断锁,降低了整体的执行效率
 * 总结:什么情况会使用同步代码块
 * 1.多个线程共享一个数据
 * 2.至少有两个线程
 */
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
	// 创建一个对象锁
	private Object object = new Object();
	private int num = 20;
	private boolean wan = false;

	@Override
	public void run() {
		while (!wan) {
			synchronized (object) {

				if (num > 0) {
					try {
						Thread.sleep(0);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " " + num--);
				} else {
					wan = true;
				}
			}
		}
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