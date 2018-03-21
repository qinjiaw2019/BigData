package com.ljy.day18.守护线程3;

/**
 * 
 * <pre>
 * 守护线程:相当于后台线程,依赖于前台线程.
 * 正常情况下,只要前台线程一结束,守护线程不管是不是还在工作,都会马上结束
 * 典型的守护线程:垃圾回收线程
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月21日
 */
public class Demo {
	public static void main(String[] args) {
		Test1 test1 = new Test1();
		Thread thread1 = new Thread(test1);
		//将前台线程变成守护线程的方法
		//注意.这个方法的调用必须在调用start()方法之前调用
		thread1.setDaemon(true);
		
		thread1.start();
		
		try {
			//睡10s方便观察
			//主线程睡醒就结束
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Test1 implements Runnable{

	@Override
	public void run() {
		while (true) {
			System.out.println("守护线程的任务");
		}
	}
	
}