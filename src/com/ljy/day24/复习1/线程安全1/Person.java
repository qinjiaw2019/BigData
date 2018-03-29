package com.ljy.day24.复习1.线程安全1;

public class Person {
	private String name;
	private String sex;
	private boolean b = false;

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + "]";
	}

	public synchronized void in(String name, String sex) {
		if(isB()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		this.sex = sex;
		setB(true);
		notify();
		
	}

	public synchronized void out() {
		if (!isB()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(toString());
		setB(false);
		notify();

	}
}
