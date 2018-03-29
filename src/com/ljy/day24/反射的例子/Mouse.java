package com.ljy.day24.反射的例子;

public class Mouse implements USB{

	@Override
	public void open() {
		System.out.println("开始使用鼠标");
	}

	@Override
	public void close() {
		System.out.println("结束使用鼠标");
	}
	
}
