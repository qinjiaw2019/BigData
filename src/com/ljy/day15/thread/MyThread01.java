package com.ljy.day15.thread;

public class MyThread01 {
	
	public static void main(String[] args) {
		new MyThread01();
	
		/**
		 * 运行垃圾回收器,出发垃圾回收机制 <br/>
		 * 原理:当执行完下面的方法,会触发垃圾回收机制, 垃圾回收线程会被打开.
		 */
		
		// 输出结果:main 和 "进行垃圾回收了" 随机切换输出,表明有两个线程在抢CPU
		System.out.println("main");
	}

	/**
	 * 应该由系统调用,为了模拟当前多线程功能<br/>
	 * 暂时重写 正常情况下,当MyThread01对象被释放的时候,finalize由系统自动调用
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("进行垃圾回收了");
		super.finalize();
		
	}
}
