package com.ljy.day16.交替输入输出的问题;

/**
 * Thread.sleep()与Object的wait()方法的区别
 * 1.Thread.sleep()会让当前线程阻塞,释放CPU,但是如果当前线程拥有同步锁,不会释放同步锁
 * 2.Object.wait()方法也会让当前线程阻塞,释放CPU,但是如果当前线程拥有同步锁的话会释放同步锁
 * 3.Thread.sleep()到时间,当前线程会自己进入就绪状态(可抢CPU),而wait方法只有等待被唤醒(notify()/notifyAll())
 * 	  才能进入就绪状态
 * 4.Object.wait()必须在同步代码块中使用
 */


/**
 * <pre>
 * 两个线程之间的通讯:每个线程都有自己的任务,大家使用同一份数据
 * 
 * 分析:需要一份数据:公用
 * 两个任务:传入传出
 * 两个线程
 * 
 * 
 * 线程常用的方法
 * wait():让当前的线程处于等待状态,相当于放入了一个池子(线程池),等待唤醒
 * notify():将当前的线程从等待状态唤醒,相当于从池子中取回 //同一把锁下的任意线程
 * notifyAll();取回同一把锁下的所有线程,将所有该锁对象作用的线程唤醒
 * 
 * 为什么要将notify和wait等方法放入Object类中?
 * 因为notify等方法要通过锁对象调用,而所有对象都是Object的子类
 * 
 * 定义:我们习惯把这种唤醒,等待的方式称为多线程的唤醒等待机制
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
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月20日
 */
class Data {
	String name;

	String sex;

	boolean flag;// 作用是控制等待与唤醒之前的切换,默认是false
}

/**
 * <pre>
 * <ol>
 * <li>传入任务</li>
 * <li>传入任务</li>
 * </ol>
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
			/**
			 * <pre>
			 * 对于两个不同的任务各自对应不同的线程,公用一份数据,单独给一个任务进行同步没有意义
			 * 要想让她们呢同步,也要符合同步的基本条件:至少有两个线程
			 * 具体做法:
			 * 给两个同步代码块使用同一把锁,这相当于将两个同步代码块进行了同步,
			 * 又因为两个同步代码块在各自的线程中,所以相当于线程同步了
			 * </pre>
			 */
			synchronized (data) {// 这里的data作为同步锁,是因为被两个线程共享,同时Object.class也可以在这作为同步锁
				// 在执行的代码对应的是哪个线程,通过锁操作的就是哪个线程
				if (data.flag) {// 当flag值为true时,让输入线程处于等待状态
					try {
						data.wait();// 因为这里只有输入线程,所以调用data的wait()方法,一定是让输入线程等待,释放锁释放CPU
						// 等待是在哪一个线程就让哪一个线程等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				if (i == 1) {
					data.name = "芙蓉姐姐";
					data.sex = "女";
				} else {
					data.name = "凤姐";
					data.sex = "男";
				}
				i = (i + 1) % 2;

				data.flag = true;// 当输入线程完成工作后,将标识符变成true
				data.notify();// 没睡调该方法,称为空唤醒,程序允许空唤醒
				// 同一把锁控制所有使用该锁的线程
				// 当有多个线程时,notify()只唤醒任意一个线程
			}

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
			synchronized (data) {
				if (!data.flag) {
					try {
						data.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("姓名:" + data.name + " 性别:" + data.sex);
				data.flag = false;
				data.notify();
			}
		}
	}

}
