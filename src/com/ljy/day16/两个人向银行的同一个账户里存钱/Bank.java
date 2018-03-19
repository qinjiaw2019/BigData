package com.ljy.day16.两个人向银行的同一个账户里存钱;

public class Bank {
	int sum;
	@SuppressWarnings("unused")
	private Object object = new Object();
	// 锁代码块
	/*
	 * <pre> public void addMoney(int money) { synchronized (object) { sum += money;
	 * System.out.println(Thread.currentThread().getName() + "往账户存了" + money +
	 * " 当前账户余额" + sum); }
	 *
	 * } </pre>
	 */

	// 锁方法,锁对象是this,this是当前对象的引用,被多个线程共享了,所以this可以当作锁对象
	public synchronized void addMoney(int money) {
		sum += money;
		System.out.println(Thread.currentThread().getName() + "往账户存了" + money + " 当前账户余额" + sum);
	}

	// 静态同步函数---相当于在synchronized后面默认跟着当前的字节码文件Bank.class
	@SuppressWarnings("unused")
	private static synchronized void test() {
		synchronized (Bank.class) {

		}
	}
}
