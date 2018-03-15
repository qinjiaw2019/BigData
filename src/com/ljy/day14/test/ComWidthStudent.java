package com.ljy.day14.test;

import java.util.Comparator;

public class ComWidthStudent implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getSchoolNum().compareTo(o2.getSchoolNum());
	}

}
