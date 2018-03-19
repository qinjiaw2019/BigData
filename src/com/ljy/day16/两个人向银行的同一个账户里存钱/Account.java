package com.ljy.day16.两个人向银行的同一个账户里存钱;

public class Account {
	private int money;
	private Object object = new Object();
	public void add(int money) {
		synchronized (object) {
			System.out.println(Thread.currentThread().getName()+"往账户存了"+money+"块钱");
			this.money += money;
			show();
		}
		
	}
	
	public void show() {
		System.out.println("当前账户余额:"+money);
	}
}
