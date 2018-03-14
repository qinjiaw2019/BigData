package com.ljy.day13.fanxing;

public class Student extends Person{
	private String classNum;

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	@Override
	public String toString() {
		return "Student [classNum=" + classNum + "]";
	}

	

	
	
}
