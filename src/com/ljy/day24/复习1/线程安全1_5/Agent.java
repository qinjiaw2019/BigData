package com.ljy.day24.复习1.线程安全1_5;

public class Agent {

	public static void main(String[] args) {
		Product product = new Product();
		Produce produce = new Produce(product);
		Consumer consumer = new Consumer(product);
		Thread tp1 = new Thread(produce, "生产线1");
		Thread tp2 = new Thread(produce, "生产线2");

		Thread tc1 = new Thread(consumer, "消费者1");
		Thread tc2 = new Thread(consumer, "消费者2");

		tp1.start();
		tp2.start();

		tc1.start();
		tc2.start();
	}
}
