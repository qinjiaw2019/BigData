package com.ljy.day14.test;

//学生
public class Student {
	private String schoolNum;

	public String getSchoolNum() {
		return schoolNum;
	}

	public void setSchoolNum(String schoolNum) {
		this.schoolNum = schoolNum;
	}

	public Student() {
		super();
	}

	public Student(String schoolNum) {
		super();
		this.schoolNum = schoolNum;
	}

	@Override
	public String toString() {
		return "Student [schoolNum=" + schoolNum + "]";
	}
}
