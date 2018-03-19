package com.ljy.day16.两个人向银行的同一个账户里存钱;

public class Test {
	public static void main(String[] args) {
		//我的
		/*Account account = new Account();
		Person p1 = new Person(account, 100);
		p1.setName("张三");
		
		Person p2 = new Person(account, 200);
		p2.setName("李四");
		p1.start();
		p2.start();*/
		
		//老师讲解
		CunQian cunQian = new  CunQian();
		Thread thread1 = new Thread(cunQian);
		thread1.setName("张三");
		Thread thread2 = new Thread(cunQian);
		thread2.setName("李四");
		
		thread1.start();
		thread2.start();
	}
	
	
}
