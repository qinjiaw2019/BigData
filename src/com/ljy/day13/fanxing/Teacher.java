package com.ljy.day13.fanxing;

public class Teacher extends Person{
	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Teacher [salary=" + salary + "]";
	}
	
}
