package com.ljy.day17.生产者与消费者;

public class Output implements Runnable {
	private Person person;

	public Output(Person person) {
		super();
		this.person = person;
	}

	@Override
	public void run() {
		while (true) {
			person.getData();
		}
	}

}
