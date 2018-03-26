package com.ljy.day21.其他流对象;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <pre>
 * PrintWriter字符打印流
 * 操作的设备:
 * 1.File类型的文件
 * 2.字符串类型的文件
 * 3.字节流对象
 * 4.字符流对象
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月26日
 */
public class Demo2 {
	public static void main(String[] args) throws IOException {
		//从键盘输入数据
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 	@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(".\\src\\com\\ljy\\day21\\其他流对象\\temp.txt"));
	 	//从文件输入文件
	 	
	 	//输出
	 	//支持字节输出流  从内存输入到控制台
	 	//PrintWriter pw = new PrintWriter(System.out);
	 	//支持字符输出流--从内存输入到文件
	 	PrintWriter pw = new PrintWriter(new FileWriter(".\\src\\com\\ljy\\day21\\其他流对象\\temp2.txt"), true);
	 	//实现将数据写入到控制台
	 	String data = null;
	 	while((data = reader.readLine())!=null) {
	 		pw.write(data);
	 		pw.write("\r\n");
	 	}
	 	pw.flush();
	 	pw.close();
	}
}
