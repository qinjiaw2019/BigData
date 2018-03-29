package com.ljy.day24.反射的例子;

public class XiaoAi implements USB{

	@Override
	public void open() {
		System.out.println("Hello OK?");
	}

	@Override
	public void close() {
		System.out.println("结束使用小爱同学");
	}

}
