package com.ljy.day22.序列化流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <pre>
 * 序列化流:
 * 
 * 存储手段:集合,数组,对象,文件
 * 
 * 分成两类
 * 临时存储:存放在内存中,随着程序的关闭而释放,集合数组,对象
 * 长久存储:存储在磁盘中,即使程序关闭,数据也能继续保存
 * 
 * 序列化:
 * 就是将数据从内存存放到磁盘中,出具可以长久的保存
 * 反序列化:就是将数据从磁盘放回内存
 * 
 * 对象序列化的作用:
 * 可以让数据进行持久化存储
 * 
 * 进行序列化的步骤:对象序列化
 * 1.创建一个类
 * 2.实现Serializable接口
 * 3.使用对应的流将对象存入磁盘中---序列化   ObjectOutputStream
 * 4.使用对应的流将对象从磁盘中取出--反序列化 ObjectInputStream
 * 5.关闭流
 * 
 * 注意:序列化流在工作的时候需要关联对应的输入流和输出流完成工作
 * 
 * 
 * 总结:序列化和反序列化过程中的特点:
 * 1.合理使用序列化流和反序列化流,要与输入流和输出流配合使用
 * 2.进行序列化的类一定要实现Serializable接口,只要实现了该接口就可以进行序列化,包括集合,基本数据类型的包装类等
 * 3.进行序列化的类要保证当前类和他内部的所有元素都要实现Serializable接口(比如有一个自定义类属性成员,但是这个属性成员没有实现这个接口,则会序列化失败)
 * 
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月27日
 */
public class Demo2 {
	public static void main(String[] args) {
		// 序列化
		//writeObj();
		// 反序列化
		readObj();
	}

	/**
	 * 注意点1:
	 * 将Person对象序列化后将Person类删除,再进行反序列化的时候出现了异常,原因是
	 * 反序列化在执行的时候依赖字节码文件,没有字节码文件所以反序列化失败
	 */
	private static void readObj() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(".\\src\\com\\ljy\\day22\\序列化流\\obj.data"));
			Person p = (Person) ois.readObject();
			System.out.println(p);
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void writeObj() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(".\\src\\com\\ljy\\day22\\序列化流\\obj.data"));
			Person person = new Person();
			person.setAge(21);
			person.setName("张三");
			//person.setSex("男");
			oos.writeObject(person);
			oos.close();
			System.out.println("序列化成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 
 * <pre>
 * 序列化时使用系统ID和自定义ID的区别
 * 使用系统的序列化和反序列ID不能手动设置,使用的是编译器默认生成的,一旦类发生了改动,类会重新赋值
 * 使用自定义的,序列化和反序列化ID不会发生改变,所以当反序列化的时候即使对Person类进行 了一些
 * 改动,也能反序列化成功
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月27日
 */
class Person implements Serializable{
	
	/**
	 * default:值是用户自己指定的,默认值是1L
	 */
	//private static final long serialVersionUID = 1L;
	/**
	 * 
	 * java.io.InvalidClassExcption:
	 * 出现的原因是没有声明自己的而是用系统默认的,在进行反序列的时候,类被改动,系统认为现在
	 * 的类已经不是原来的那个类,重新默认了一个不同序列化ID的,认为此类无效
	 * 
	 */
	/**
	 * generated:是由编译器自动生成,后面加L表示是long型的
	 */
	private static final long serialVersionUID = 8108439472319594759L;
	private String name;
	private int age;
	//private String sex;
	
	/*public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age+"]"; /*" +, sex=" + sex + "]"*/
	}

}
