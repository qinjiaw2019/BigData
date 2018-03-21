package com.ljy.day18.java1_5之后的锁机制;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * <pre>
 * 多生产者多消费者
 * 
 * 比较synchronized与Lock
 * 在jdk1.5之前使用的同步机制----synchronized   隐式同步
 * synchronized(锁){//锁就是对象,这里获取称为获取锁,对于锁我们还可以称为锁旗舰或监听器
 * 		同步代码
 * }//释放锁
 * 
 * 在jdk1.5之后出现的新的同步机制----Lock  显式用不
 * 相当于将锁面向对象,使用内部提供的方法实现功能
 * 原理:
 * 创建Lock的子对象,通过子对象干活,用ReentrantLock实现类来创建
 * Lock的使用方法
 * 1.先让锁对象调用lock()方法获取锁
 * 2.写同步代码
 * 3.让锁对象调用unlock()释放锁
 * 
 * 使用时机:
 * 一般在多生产者多消费者的时候使用Lock,其他情况倾向于使用synchronized.
 * 
 * 效率上Lock比synchronized要高
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月21日
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

/**
 * <pre>
 * Lock的使用方法
 * 1.先让锁对象调用lock()方法获取锁
 * 2.写同步代码
 * 3.让锁对象调用unlock()释放锁
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月21日
 */
class Product {

	private String name;

	private double price;
	// 产品数量
	private int count;

	private boolean flag;

	// 创建一个锁对象
	private Lock lock = new ReentrantLock();

	//得到和锁对象绑定的Condition对象,
	//分别实现不同线程的唤醒等待
	//创建Condition对象,用于控制生产线程的唤醒等待
	Condition proCon = lock.newCondition();
	//创建用于消费的Condition对象,用于控制消费线程的唤醒等待
	Condition consuCon = lock.newCondition();
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
	public void produce(String name, double price) {
		lock.lock();// 让线程获取锁
		try {
			while (flag) {
				try {
					proCon.await();//让生产线程等待
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.count++;// 生产一次,产品总数加1
			this.name = name + " 产品数量:" + count;
			this.price = price;
			System.out.println(Thread.currentThread().getName() + "生产了:" + name + " 产品价格:" + price);

			flag = !flag;
			consuCon.signal();//唤醒一个消费线程
		} finally {// 通过try()finally{}限定了当前的锁对象必须被释放
			lock.unlock();// 让线程释放锁
		}

	}

	// 为消费准备的数据
	public void consume() {
		lock.lock();//获取锁----与produce方法使用相同锁,保证这两块代码同步
		try {
			while (!flag) {
				try {
					consuCon.await();;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// this.count--;
			System.out.println(Thread.currentThread().getName() + "消费了:" + name + " 产品价格:" + price);
			flag = !flag;
			proCon.signal();
		} finally {
			lock.unlock();
		}
		
	}
}
