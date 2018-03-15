package com.ljy.day13.fanxing;

public class FXInterface {
	public static void main(String[] args) {
		//测试第一种情况
		Pig pig = new Pig();
		pig.show(3);
		pig.eat();
		
		//测试第二种情况
		Cat<String> cat = new Cat<>();
		cat.show("嘚瑟");
	}

}

interface Inner<E>{
	void show(E e);
}

//接口实现泛型的第一种方式
//接口有泛型,子类没有遵守对应的泛型
//1.如果接口上没有给E一个具体的类型,那方法中的泛型无法直接使用
//对应方法来说,又分成两种情况
//一种是从接口中继承的方法:泛型要与接口的泛型保持一致,并且要给接口的泛型指定一个具体的类型
//一种是自己私有的方法:可以使用接口的泛型,也可以自定义方法的泛型
class Pig implements Inner<Integer>{

	//从接口继承的方法
	@Override
	public void show(Integer e) {
		System.out.println("这是Pig的Show");
	}
	//私有方法
	public void eat() {
		System.out.println("猪只会吃了睡睡了吃");
	}
}

//接口实现泛型的第二种方式
//接口有泛型,子类遵守了对应的泛型
//类上的泛型确定了,接口上的泛型就确定了
class Cat<E> implements Inner<E>{

	@Override
	public void show(E e) {
		System.out.println("这是Cat的Show");
	}
	
}