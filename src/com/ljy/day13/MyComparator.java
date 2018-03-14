package com.ljy.day13;

import java.util.Comparator;
import java.util.TreeSet;
@SuppressWarnings({"rawtypes","unchecked"})
public class MyComparator {
	
	
	public static void main(String[] args) {
		
		//set再存储字符串的时候,可以实现自动排序和去重
		//原因:字符串实现了Comparable借口中的compareTo方法,String调用compareTo的地方是add方法.
		//默认是字典升序排序
		
		//创建比较器对象
		ComparatorImpl cimpl = new ComparatorImpl();
		TreeSet set = new TreeSet<>(cimpl);
		//将TreeSet于比较器对象相关联
		System.out.println(set.add(new Dog1("zhangsan", 12)));
		System.out.println(set.add(new Dog1("lisi", 13)));
		System.out.println(set.add(new Dog1("wangwu", 14)));
		System.out.println(set.add(new Dog1("zhaoliu", 15)));
		System.out.println(set.add(new Dog1("x", 15)));
		System.out.println(set.add(new Dog1("zhaoliu", 16)));
		System.out.println(set.add(new Dog1("zhaoliu", 16)));
		System.out.println(set);
	}
}
//也可以根据我们的需求去比较去重
@SuppressWarnings("rawtypes")
class ComparatorImpl implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if(!(o1 instanceof Dog1)) {
			throw new RuntimeException();
		}
		if(!(o2 instanceof Dog1)) {
			throw new RuntimeException();
		}
		Dog1 d1 = (Dog1) o1;
		Dog1 d2 = (Dog1) o2;
		int num = d1.getAge()-d2.getAge();
		return num!=0?num:d1.getName().compareTo(d2.getName());
	}
	
}