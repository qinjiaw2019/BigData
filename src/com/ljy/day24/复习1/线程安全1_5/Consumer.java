package com.ljy.day24.复习1.线程安全1_5;

/**
 * 
 * <pre>
 * 消费
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月29日
 */
public class Consumer implements Runnable{

	private Product p;
	
	
	public Consumer(Product p) {
		super();
		this.p = p;
	}


	@Override
	public void run() {
		
		while(true) {
			p.consume();
		}
	}
	
}
