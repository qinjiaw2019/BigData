package com.ljy.day12;

import java.util.LinkedList;

/**
 * 栈:先进后出
 * 队列:先进先出
 *	该类作用:模拟队列
 */
public class Queue<E> {
	//内部维护的集合
	private LinkedList<E> list = new LinkedList<>();

	public Queue() {
	}
	
	//存
	public boolean push(E e) {
		return list.offerFirst(e);
	}
	//取
	public E pull() {
		return list.pollLast();
	}
	//获取队列中数据的大小
	public int getSize() {
		return list.size();
	}
	//判断队列是否为空
	public boolean isEmpty() {
		return list.isEmpty();
	}
	//清空队列
	public void clear() {
		list.clear();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
}
