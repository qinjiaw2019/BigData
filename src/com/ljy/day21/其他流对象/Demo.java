package com.ljy.day21.其他流对象;

import java.io.IOException;
import java.io.PrintStream;

/**
 * <pre>
 * PrintStream 字节打印流
 * 除了拥有输出流的特点之外,还有打印流的功能
 * 支持的设备:
 * 1.File类型的文件
 * 2.字符串类型的文件
 * 3.字节输出流
 * 
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月26日
 */
public class Demo {
	public static void main(String[] args) throws IOException {
		//1.file类型的文件
//		new PrintStream(new File(".\\src\\com\\ljy\\day21\\其他流对象\\package-info.java"));
		
		//2.字符串类型的文件
//		new PrintStream("temp.txt");//如果文件不存在,则自动创建
		
		//3.字节输出流
//		new PrintStream(new FileOutputStream(""),true);//true:表示自动刷新
		
		PrintStream ps = new PrintStream(".\\src\\com\\ljy\\day21\\其他流对象\\temp.txt");
		ps.write(97); //   00000000 00000000 00000000 01100001  当执行当前方法的时候,默认将当前3个字节去掉(一个字节8为)
		ps.write(353);//a  00000000 00000000 00000001 01100001
		ps.print(353);//a  00000000 00000000 00000001 01100001 进行了自动转化,
		//转化过程:现将int型的353转成字符串,再转成字符数组
		ps.write(String.valueOf(353).getBytes());
		ps.close();
	}
}
