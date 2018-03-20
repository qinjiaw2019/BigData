package com.ljy.day17.面向对象的线程通讯1;

import com.ljy.day17.面向对象的线程通讯1.Input;

/**
 * <pre>
 * 
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月20日
 */
public class Demo {
	public static void main(String[] args) {
		// 创建数据类对象
		Data data = new Data();

		// 创建两个任务类对象,将数据传给任务
		Input input = new Input(data);
		Output output = new Output(data);

		// 创建两个线程类对象,将任务交给线程
		Thread thread1 = new Thread(input);
		Thread thread2 = new Thread(output);

		// 开启线程
		thread1.start();
		thread2.start();
	}

}

/**
 * <pre>
 * 数据类
 * 将应该由data干的活交给data自己来干
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月20日
 */
class Data {
	String name;

	String sex;

	boolean flag;

	/**
	 * 将数据交给输入任务只之前对数据的处理
	 */
	public synchronized void setData(String name, String sex) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		this.name = name;
		this.sex = sex;
		flag = true;
		notify();
	}

	public synchronized void getData() {
			if (!flag) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("姓名:" + name + " 性别:" + sex);
			flag = false;
			notify();
	}
}

/**
 * <pre>
 * 
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月20日
 */
class Input implements Runnable {
	private Data data;

	public Input(Data data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		int i = 1;
		while (true) {
			if (i == 1) {
				data.setData("芙蓉姐姐", "女");
			} else {
				data.setData("凤姐", "男");
			}
			i = (i + 1) % 2;

		}

	}
}

/**
 * <pre>
 * 传出任务
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月20日
 */
class Output implements Runnable {
	private Data data;

	public Output(Data data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		while (true) {
			data.getData();
		}
	}

}
