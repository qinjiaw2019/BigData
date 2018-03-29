package com.ljy.day24.反射的例子;

public class Keyboard implements USB{

	@Override
	public void open() {
		System.out.println("开始使用键盘");
	}

	@Override
	public void close() {
		System.out.println("结束使用键盘");
	}
	
}
