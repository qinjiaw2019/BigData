package com.ljy.day12.test;

import java.util.LinkedList;

/**
 * 模拟栈:先进后出
 * @author lijiayan
 *
 */
public class Stack<E> {
	private LinkedList<E>list = new LinkedList<>();
	
	public boolean pushStack(E e) {
		return list.offerLast(e);
	}
	
	public E popStack() {
		return list.pollLast();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int getSize() {
		return list.size();
	}
	
	public void clear() {
		list.clear();
	}
}
