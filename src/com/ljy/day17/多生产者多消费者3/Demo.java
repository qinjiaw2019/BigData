package com.ljy.day17.多生产者多消费者3;

/**
 * 
 * <pre>
 * 生产者和消费者
 * 1.单生产者单消费者
 * 2.多生产者和多消费者
 * 
 * 
 * 1.单生产者消费者
 * 类似单传入单传出
 * 生产者有生产任务
 * 消费者有消费任务
 * 
 * 
 * 生产者和消费者都可以看作是一个线程
 * 所以:一定是多线程
 * 2.多生产者多消费者
 * 线程:多生产线程多消费线程
 * 任务:一个生产任务,一个消费任务
 * 
 * 分析:
 * 生产任务类:负责生产
 * 消费任务类:负责消费
 * 生产者和消费者共同的数据:产品类
 * 
 * 错误描述:当有两个生产线程,两个消费线程同时存在的时候,又可以出现生产一次,消费多次等错误情况的出现.
 * 出现错误的原因是:当线程重新唤醒之后没有判断标记,直接执行了下面的代码
 * 改进:将if-->while
 * 
 * 继续运行程序,会出现死锁的情况,即四个线程都出现等待状态
 * 原因:唤醒的都是本方的线程,导致所有的线程都出现等待
 * 改进:将notify()-->notifyAll();由于notify()是唤醒同一把锁下的任意线程
 *     而notifyAll()是唤醒同一把锁下的所有线程
 *  
 * 会出现死锁的情况:
 * 1.所有线程处于等待状态
 * 2.锁嵌套
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月20日
 */
public class Demo {
	public static void main(String[] args) {
		Product product = new Product();
		// 创建生产消费任务类
		Produce produce = new Produce(product);
		Consumer consumer = new Consumer(product);
		// 创建生产消费线程
		Thread threadP1 = new Thread(produce);
		Thread threadP2 = new Thread(produce);
		Thread threadC1 = new Thread(consumer);
		Thread threadC2 = new Thread(consumer);
		threadP1.start();
		threadP2.start();
		threadC1.start();
		threadC2.start();
	}
}

// 生产任务
class Produce implements Runnable {
	private Product product;

	public Produce(Product product) {
		super();
		this.product = product;
	}

	@Override
	public void run() {
		while (true)
			product.produce("韩红版XXX", 1000.00);
	}

}

// 消费任务
class Consumer implements Runnable {
	private Product product;

	public Consumer(Product product) {
		super();
		this.product = product;
	}

	@Override
	public void run() {
		while (true)
			product.consume();
	}

}

class Product {

	private String name;

	private double price;
	// 产品数量
	private int count;

	private boolean flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	// 为生产准备的数据
	public synchronized void produce(String name, double price) {
		// 判断生产是否进入等待状态
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.count++;// 生产一次,产品总数加1
		this.name = name + " 产品数量:" + count;
		this.price = price;
		System.out.println(Thread.currentThread().getName() + "生产了:" + name + " 产品价格:" + price);

		flag = !flag;
		notifyAll();

	}

	// 为消费准备的数据
	public synchronized void consume() {
		// 判断消费是否进入等待状态
		while (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// this.count--;
		System.out.println(Thread.currentThread().getName() + "消费了:" + name + " 产品价格:" + price);
		flag = !flag;
		notifyAll();
	}
}
