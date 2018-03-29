package com.ljy.day24.复习1.线程安全2;

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
	public synchronized void produce(String name,double price) {
		while(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		this.price = price;
		this.count++;
		flag = true;
		System.out.println(Thread.currentThread().getName()+"生产了:"+name+" 产品价格:"+price);
		notifyAll();
	}

	/**
	 * 消费
	 */
	public synchronized void consume() {
		while(!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"消费了:"+name+" 产品价格:"+price);
		flag = false;
		notifyAll();
	}
}
