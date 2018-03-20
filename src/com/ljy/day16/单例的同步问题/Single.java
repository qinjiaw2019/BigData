package com.ljy.day16.单例的同步问题;

/**
 * <pre>
 * 单例中线程安全的问题 
 * 三步: 
 *   1.构造方法私有化 
 *   2.私有的静态成员变量 
 *   3.公共的静态方法,将当前唯一的对象提供出去
 * </pre>
 * 
 * @author lijiayan
 *
 */
public class Single {

}

// 懒汉式
class SingleInstance {
	private static SingleInstance instance = null;

	private SingleInstance() {
	}

	/**
	 * 该写法第一次由于要判断两次同步锁,所以第一次效率有点低
	 * @return
	 */
	public static SingleInstance getInstance() {
		if (instance == null) {//尽量少的判断同步问题,提高效率
			synchronized (SingleInstance.class) {// 获取当前类的字节码文件,充当同步代码块的锁,让多个线程之间互斥
				if (instance == null) {
					synchronized (SingleInstance.class) {
						instance = new SingleInstance();
					}

				}

			}

		}
		return instance;
	}

	// 工作的位置
}

// 饿汉式 不存在线程安全问题
class SingleInstance1 {
	private static SingleInstance1 instance = new SingleInstance1();

	private SingleInstance1() {
	}

	public static SingleInstance1 getInstance() {
		return instance;
	}

	// 工作的位置
	
	
	
}