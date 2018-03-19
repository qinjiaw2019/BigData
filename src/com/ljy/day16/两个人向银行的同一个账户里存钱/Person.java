package com.ljy.day16.两个人向银行的同一个账户里存钱;

public class Person extends Thread{
	private Account account;
	private int money;
	public Person(Account account,int money) {
		super();
		this.account = account;
		this.money = money;
	}

	@Override
	public void run() {
		this.account.add(money);
	}
	
}
