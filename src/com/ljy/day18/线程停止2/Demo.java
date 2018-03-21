package com.ljy.day18.线程停止2;

/**
 * 
 * 
 * <pre>
 * 线程停止:结束线程 
 * 1.通过一个标识停止
 * 2.stop():不建议使用
 * 3.调用线程的interrupt():
 * 原理:让处于长期等待的子线程发生终端的异常,我们就可以在catch里面将flag值变成false,一次来结束线程
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月21日
 */
public class Demo {
	public static void main(String[] args) {
		//标识停止
		Thread thread = new Thread(new Runnable() {
			public boolean flag = true;
			
			@Override
			public void run() {
				int i = 0;
				while(flag) {
					System.out.println(Thread.currentThread().getName()+"...."+i);
					if (i++==10) {
						flag = false;
					}
				}
			}
		});
		thread.start();
		
		
		//3.调用线程的interrupt():
		Thread thread2 = new Thread(new Runnable() {
			boolean flag = true;
			private Object object = new  Object();
			@Override
			public void run() {
				System.out.println("子线程2开启...");
				while(flag) {
					synchronized (object) {
						try {
							object.wait();
							System.out.println("..........");
						} catch (InterruptedException e) {
							e.printStackTrace();
							flag = false;
						}finally {
							System.out.println("线程停止了");
						}

					}
				}
			}
		});
		
		thread2.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread2.interrupt();
	}
}
