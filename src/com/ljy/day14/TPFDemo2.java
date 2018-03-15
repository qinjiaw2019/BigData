package com.ljy.day14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.ljy.day13.fanxing.Person;
import com.ljy.day13.fanxing.Student;

/**
 * 通配符? 限制上限 <? extends E>: <br/>
 * 限制的是整个<>可以取得泛型的上限,<>中可以取的是E及E的子类<br/>
 * 限制下限<? super E>:<br/>
 * 限制的是整个<>可以取得泛型的下限,<>中可以取的泛型是E及E的父类
 * 
 * @author lijia
 *
 */
public class TPFDemo2 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//限制上限
		ArrayList<Student>list = new ArrayList<>();
		Student stu1 = new Student();
		stu1.setName("张三");
		stu1.setAge(23);
		list.add(stu1);
		Student stu2 = new Student();
		stu2.setName("李四");
		stu2.setAge(24);
		list.add(stu2);
		
		//因为Student是Person的子类,所以可以调用遍历的方法,Teacher类同理也可以在这使用
		//Person也可以
		iterator(list);
		
		List<Object>list2 = new ArrayList<>();
		//TODO 因为Object不在限制范围之内,所以不能在这使用
		//iterator(list2);
	}
	
	/**
	 * 限制上限
	 * <? extends E>
	 * 该方法遍历的是Person及Person的子类
	 * @param e
	 */
	public static<E> void iterator(Collection<? extends Person> e) {
		//.....
	}
	
	/**
	 * 测试限制下限
	 */
	public static void testXiaXian() {
		ComWidthStudent comWidthStudent = new ComWidthStudent();
		@SuppressWarnings("unused")
		TreeSet<Student>treeSet = new TreeSet<>(comWidthStudent);
		
	}
	
	//创建学生的比较器
	private static final class ComWidthStudent implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			return o1.getAge()-o2.getAge();
		}
		
	}
	
	//创建Person的比较器
	//创建老师的比较器
	
}