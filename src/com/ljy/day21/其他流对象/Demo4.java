package com.ljy.day21.其他流对象;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * <pre>
 * 模拟系统的属性集合对象
 * 优点:
 * 	1.以键值对的形式存储数据
 * 	2.内部封装了大量的方法
 * 		store
 * 		list
 * 		load
 * 		...
 * 
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月26日
 */
public class Demo4 {
	public static void main(String[] args) throws IOException {
		//1.创建一个属性集合对象
		Properties properties = new Properties();
		//2.创建输入流 temp4.txt代表磁盘中的文件
		//注意:Properties必须保存以键值对形式存在的数据
		FileReader reader = new FileReader(".\\src\\com\\ljy\\day21\\其他流对象\\temp4.txt");
		//3.将输入流中的内容加载到属性集合对象
		properties.load(reader);
		//打印到控制台
		properties.list(System.out);
		//修改值
		properties.setProperty("name", "zhangsan");
		properties.setProperty("介绍", "zhangsan是个人才");
		//存储
		properties.store(new FileWriter(".\\src\\com\\ljy\\day21\\其他流对象\\temp4.txt",false), "2018/3/26");
		
	}
}
