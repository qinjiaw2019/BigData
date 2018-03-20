package com.ljy.day17.锁嵌套出现死锁;

public class Demo {
	/**
	 * <pre>
	 * 执行情况: 
	 * 1.thread1开启,
	 * 2.主线程sleep(20),在这20毫秒内让出CPU,同时thread1抢到CPU,先执行20毫秒,进入if里面的while
	 * 循环,这时thread拿到obj锁,再拿到this锁,开始先sleep 20毫秒
	 * 3.主线程睡醒,重新抢到,修改flag的值,开启thread2,假如thread2抢到CPU,执行跟thread1一样的情况
	 * 4.thread1与thread2交替执行 
	 * 5.死锁情况:
	 * thread1抢到obj锁,thread2抢到this锁,此时thread1等Thread2释放this锁,而thread2等thread1释放obj锁,
	 * 情况僵持,出现死锁.
	 * 
	 * sleep不会释放锁对象,能出现死锁是因为seller执行完后释放了this锁,
	 * 如果是thread1的话又接着释放obj锁,才进入while循环判断
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		Thread thread1 = new Thread(ticket);
		Thread thread2 = new Thread(ticket);
		thread1.start();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ticket.flag = false;
		thread2.start();
	}
}

class Ticket implements Runnable {
	private int num = 100;
	private Object obj = new Object();
	boolean flag = true;

	@Override
	public void run() {
		if (flag) {
			while (true) {
				synchronized (obj) {// 需要拿到obj 锁
					seller();// 需要拿到this锁
				}
			}

		} else {
			while (true) {
				seller();
			}
		}
	}

	private synchronized void seller() {// 需要拿到this锁
		synchronized (obj) {// 需要拿到obj锁
			if (num > 0) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "..." + num--);
			}
		}
	}

}