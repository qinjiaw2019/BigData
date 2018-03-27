package com.ljy.day21.其他流对象;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 
 * <pre>
 * 序列流:
 * 把多个输入流的内容一次性的打印--字节流
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月26日
 */
public class Demo5 {
	public static void main(String[] args) throws IOException {
		//创建3个输入流
		FileInputStream fileInputStream = new FileInputStream(".\\src\\com\\ljy\\day21\\其他流对象\\temp.txt");
		FileInputStream fileInputStream2 = new FileInputStream(".\\src\\com\\ljy\\day21\\其他流对象\\temp2.txt");
		FileInputStream fileInputStream3 = new FileInputStream(".\\src\\com\\ljy\\day21\\其他流对象\\temp4.txt");
		
		//将三个输入流放入到序列流
		//方式一:先放入一个Vector
		Vector<FileInputStream>vector = new Vector<>();
		//Collections.addAll(vector, fileInputStream,fileInputStream2,fileInputStream3);
		vector.add(fileInputStream);
		vector.add(fileInputStream2);
		vector.add(fileInputStream3);
		//得到枚举器
		Enumeration<FileInputStream> elements = vector.elements();
		
		
		//创建一个序列流对象并关联相关的文件---参数是一个枚举器
		SequenceInputStream sequenceInputStream = new SequenceInputStream(elements);
		FileOutputStream fos = new FileOutputStream(".\\src\\com\\ljy\\day21\\其他流对象\\temp5.txt");
		
		byte[]arra = new byte[1024];
		int len = 0;
		while((sequenceInputStream.read(arra))!=-1) {
			fos.write(arra,0,len);
			fos.flush();
		}
		
		sequenceInputStream.close();
		fos.close();
		System.out.println("wancheng");
	}
}
