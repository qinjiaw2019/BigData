package com.ljy.day24.复习1.线程安全1;

public class Input implements Runnable{

	private Person p;
	
	
	public Input(Person p) {
		super();
		this.p = p;
	}


	@Override
	public void run() {
		int i = 1;
		while(true) {
				if(i==1) {
					p.in("这三", "男");
				}else {
					p.in("李四", "女");
				}
				i = (i+1)%2;
			}
			
		}
	

}
