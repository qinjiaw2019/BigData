package com.ljy.day21.test.test2;

import java.util.ArrayList;

public class MyArrayList<E> extends ArrayList<E>{
	private static final long serialVersionUID = 1L;
	@Override
	public boolean add(E e) {
		if (contains(e)) {
			return false;
		}
		return super.add(e);
	}
	
	
}
