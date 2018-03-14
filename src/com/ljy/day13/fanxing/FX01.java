package com.ljy.day13.fanxing;

import java.util.List;

public class FX01 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Tool<Student>tool = new Tool<>();
		Student student = new Student();
		student.setAge(20);
		student.setName("张三");
		student.setClassNum("三年级三班");
		tool.setObj(student);
		
		Student obj = tool.getObj();
		FXOnFun fxOnFun = new FXOnFun();
		List<Student> list = fxOnFun.getList(Student.class);
	}
}
