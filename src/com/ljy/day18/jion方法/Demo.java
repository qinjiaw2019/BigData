package com.ljy.day18.jion方法;

/**
 * 
 * <pre>
 * jion()方法:--加入
 * 一个线程一旦调用了jion方法,它的优先级就会高于主线程,
 * 	在执行的时候主线程会等到当前线程执行完后再执行
 * 
 * 注意:调用了jion的线程只是对主线程优先级高,对其他线程没有影响
 * 作用:希望让调用jion()的线程的工作在主线程工作完成之前完成
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月21日
 */
public class Demo {
	public static void main(String[] args) {
		Test test = new Test();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + i);
		}
	}
}

class Test implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + i);
		}
	}

}