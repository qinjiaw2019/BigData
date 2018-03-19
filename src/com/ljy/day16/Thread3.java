package com.ljy.day16;

/**
 * <pre>
 * 创建线程的两种方式:
 * 	方式一:创建Thread的子类
 *		由于任务与线程绑定, 操作不方便 
 * 	方式二:单独创建线程类与任务类
 *		实现了任务与线程分离,操作更加方便
 * </pre>
 * 
 * @author lijia
 *
 */
public class Thread3 {
	public static void main(String[] args) {
		// 因为Thread本身已经实现了Runable接口,所以这里thread1可以充当任务类
		Thread thread1 = new Thread();
		Thread thread2 = new Thread(thread1);
		thread1.start();
		thread2.start();

		new Thread() {
			public void run() {
				System.out.println("执行了");
			};
		}.start();
	}
}
