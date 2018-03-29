package com.ljy.day24.复习1.线程安全1_5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * <pre>
 * 产品类
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月29日
 */
public class Product {
	private String name;
	private double price;
	private int count;
	private boolean flag = false;
	private Lock lock;
	// 生产线程的Condition对象,用于唤醒生产线程的唤醒等待
	private Condition proCon;
	// 消费线程的Condition对象,用于唤醒消费线程等待
	private Condition conCon;

	public Product() {
		super();
		lock = new ReentrantLock();
		proCon = lock.newCondition();
		conCon = lock.newCondition();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * 生产
	 */
	public  void produce(String name, double price) {
		lock.lock();
		try {
			while (flag) {
				try {
					proCon.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.name = name;
			this.price = price;
			this.count++;
			flag = true;
			System.out.println(Thread.currentThread().getName() + "生产了:" + name + " 产品价格:" + price);
			//唤醒一个消费线程
			conCon.signal();
		}finally {
			lock.unlock();
		}
		
	}

	/**
	 * 消费
	 */
	public synchronized void consume() {
		lock.lock();
		try {
			while (!flag) {
				try {
					conCon.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "消费了:" + name + " 产品价格:" + price);
			flag = false;
			//唤醒一个生产线程
			proCon.signal();
		}finally {
			lock.unlock();
		}
		
	}
}
