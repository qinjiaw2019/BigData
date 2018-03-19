package com.ljy.day16.两个人向银行的同一个账户里存钱;

import java.util.Random;

public class CunQian implements Runnable {

	Bank Bank = new Bank();
	Random random = new Random();
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			Bank.addMoney(random.nextInt(200));
		}
	}

}
