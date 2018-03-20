package com.ljy.day17.生产者与消费者;

public class Person {

	private String name;
	private String sex;
	private boolean flag = false;
	
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
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

	public synchronized void setData(String name,String sex) {
		
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		this.sex = sex;
		flag = !flag;
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
		System.out.println(this.getName()+"..."+this.getSex());
		flag = !flag;
		notify();
	}
}
