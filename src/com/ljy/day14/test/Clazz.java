package com.ljy.day14.test;

//班级
public class Clazz {
	private String classNum;

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public Clazz(String classNum) {
		super();
		this.classNum = classNum;
	}

	public Clazz() {
		super();
	}

	@Override
	public String toString() {
		return "Clazz [classNum=" + classNum + "]";
	}
	
}
