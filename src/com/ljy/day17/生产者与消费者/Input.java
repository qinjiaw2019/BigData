package com.ljy.day17.生产者与消费者;

public class Input implements Runnable {

	private Person person;

	public Input(Person person) {
		super();
		this.person = person;
	}

	@Override
	public void run() {
		int i = 1;
		// 输入
		while (true) {
			if (i == 1) {
				person.setData("张三", "男");
			} else {
				person.setData("李四", "女");
			}
			i = (i + 1) % 2;

		}
	}

}
