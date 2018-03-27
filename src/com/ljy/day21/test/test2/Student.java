package com.ljy.day21.test.test2;

public class Student implements Comparable<Student>{
	private String name;
	private float grade1;
	private float grade2;
	private float grade3;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGrade1() {
		return grade1;
	}

	public void setGrade1(float grade1) {
		this.grade1 = grade1;
	}

	public float getGrade2() {
		return grade2;
	}

	public void setGrade2(float grade2) {
		this.grade2 = grade2;
	}

	public float getGrade3() {
		return grade3;
	}

	public void setGrade3(float grade3) {
		this.grade3 = grade3;
	}
	
	public float getSumGrade() {
		return grade1+grade2+grade3;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student student = (Student) obj;
			return student.name.equals(this.name);
		}
		return super.equals(obj);
	}
	
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade1=" + grade1 + ", grade2=" + grade2 + ", grade3=" + grade3 + "sumGrade="+getSumGrade()+"]";
	}

	@Override
	public int compareTo(Student o) {
		if(equals(o))return 0;
		return -(int) (grade1 + grade2 + grade3);
	}
	
	
}
