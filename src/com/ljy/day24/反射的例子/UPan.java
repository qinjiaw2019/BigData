package com.ljy.day24.反射的例子;

public class UPan implements USB{

	@Override
	public void open() {
		System.out.println("开始使用U盘");
	}

	@Override
	public void close() {
		System.out.println("结束是使用U盘");
	}

	
}
