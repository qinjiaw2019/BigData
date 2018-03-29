package com.ljy.day24.复习1.线程安全1;

public class Output implements Runnable{

	private Person p;
	
	
	public Output(Person p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		while(true) {
			p.out();
		}
	}

}
