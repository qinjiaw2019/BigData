package com.ljy.day14.test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
//测试类
public class Test {
	public static void main(String[] args) {
		//创建map集合,比较器用匿名内部类的方式
		Map<Clazz, Set<Student>>map = new TreeMap<>(new Comparator<Clazz>() {

			@Override
			public int compare(Clazz o1, Clazz o2) {
				return o1.getClassNum().compareTo(o2.getClassNum());
			}
		});
		//创建学生比较器
		ComWidthStudent comWidthStudent = new ComWidthStudent();
		//班级1的学生集合
		Set<Student>set1 = new TreeSet<>(comWidthStudent);
		//创建2个学生实例
		Student stu11 = new Student("zhangsan");
		Student stu12 = new Student("lisi");
		set1.add(stu11);
		set1.add(stu12);
		//创建班级1
		Clazz c1 = new Clazz("一班");
		
		map.put(c1, set1);
		
		//创建二班学生集合
		Set<Student>set2 = new TreeSet<>(comWidthStudent);
		//创建两个学生实例
		Student stu21 = new Student("wangwu");
		Student stu22 = new Student("zhaoliu");
		set2.add(stu21);
		set2.add(stu22);
		//创建班级2
		Clazz c2 = new Clazz("二班");
		map.put(c2, set2);
		
		//遍历方式1
		System.out.println("========方式1======================");
		Set<Clazz> set = map.keySet();
		Iterator<Clazz> iterator = set.iterator();
		while(iterator.hasNext()) {
			Clazz clazz = iterator.next();
			Set<Student> setStu = map.get(clazz);
			Iterator<Student> iteratorStudent = setStu.iterator();
			while(iteratorStudent.hasNext()) {
				Student next = iteratorStudent.next();
				System.out.println(clazz.getClassNum()+" 班的学生 "+next.getSchoolNum());
			}
		}
		//遍历方式2
		System.out.println("===========方式2===================");
		Set<Entry<Clazz,Set<Student>>> entrySet = map.entrySet();
		Iterator<Entry<Clazz, Set<Student>>> itEntrySet = entrySet.iterator();
		while(itEntrySet.hasNext()) {
			Entry<Clazz, Set<Student>> next = itEntrySet.next();
			Clazz key = next.getKey();
			Set<Student> value = next.getValue();
			Iterator<Student> itValue = value.iterator();
			while(itValue.hasNext()) {
				Student student = itValue.next();
				System.out.println(key.getClassNum()+" 班的学生 "+student.getSchoolNum());
			}
		}
		
	}
}
