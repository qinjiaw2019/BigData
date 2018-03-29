package com.ljy.day24.复习1.线程安全1_5;

import java.util.Random;

/**
 * 
 * <pre>
 * 生产
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月29日
 */
public class Produce implements Runnable{
	private Product p;
	

	public Produce(Product p) {
		super();
		this.p = p;
	}


	@Override
	public void run() {
		Random random = new Random();
		while(true) {
			p.produce("韩红版v"+p.getCount(), random.nextInt(1000));
		}
	}
	

}
