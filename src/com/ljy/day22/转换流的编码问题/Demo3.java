package com.ljy.day22.转换流的编码问题;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 
 * <pre>
 * 转换流的编码问题
 * <strong>中国的编码:GBK,GB2312</strong>
 * <strong>欧洲:ISO8859-1</strong>
 * <strong>美国:ASCII</strong>
 * <strong>通用标准:UTF-8</strong>
 * 编码:将字符串转化成byte序列的过程
 * 编码错误:在执行读与写的时候,由于使用的编码字符集不同,造成了乱码的出现
 * 举例:GBK编码,IOS8859-1解码  或者UTF-8编码,GBK解码
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月27日
 */
public class Demo3 {
	public static void main(String[] args) {
		//writeData1();
		//readData1();
		//readData2();
		
		writeData2();
		readData3();
		readData4();
	}

	// utf-8编码 写出
	public static void writeData1() {
		try {
			// 创建输出流并关联文件,第一个参数是字节输出轮流,第二个参数是输出时指定的编码格式
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
					new FileOutputStream(".\\src\\com\\ljy\\day22\\转换流的编码问题\\demo3_utf8.txt"), "UTF-8");
			outputStreamWriter.write("创建输出流并关联文件,第一个参数是字节输出轮流");
			outputStreamWriter.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 编码格式是GBK 写出
	public static void writeData2() {
		try {
			// 创建输出流并关联文件,第一个参数是字节输出轮流,第二个参数是输出时指定的编码格式
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
					new FileOutputStream(".\\src\\com\\ljy\\day22\\转换流的编码问题\\demo3_gbk.txt"), "GBK");
			outputStreamWriter.write("创建输出流并关联文件,第一个参数是字节输出轮流");
			outputStreamWriter.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 读入
	// 编码格式是utf8
	public static void readData1() {
		try {
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(".\\src\\com\\ljy\\day22\\转换流的编码问题\\demo3_utf8.txt"), "utf-8");
			char[] aar = new char[20];
			int len = 0;
			StringBuffer sb = new StringBuffer();
			while ((len = reader.read(aar)) != -1) {
				sb.append(new String(aar, 0, len));
			}
			reader.close();
			System.out.println(sb.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 读入
		// 编码格式是utf8
		public static void readData2() {
			try {
				InputStreamReader reader = new InputStreamReader(
						new FileInputStream(".\\src\\com\\ljy\\day22\\转换流的编码问题\\demo3_utf8.txt"), "GBK");
				char[] aar = new char[20];
				int len = 0;
				StringBuffer sb = new StringBuffer();
				while ((len = reader.read(aar)) != -1) {
					sb.append(new String(aar, 0, len));
				}
				reader.close();
				System.out.println(sb.toString());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	// 读入
	// 编码格式是utf8
	public static void readData3() {
		try {
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(".\\src\\com\\ljy\\day22\\转换流的编码问题\\demo3_gbk.txt"), "GBK");
			char[] aar = new char[20];
			int len = 0;
			StringBuffer sb = new StringBuffer();
			while ((len = reader.read(aar)) != -1) {
				sb.append(new String(aar, 0, len));
			}
			reader.close();
			System.out.println(sb.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		// 读入
		// 编码格式是utf8
		public static void readData4() {
			try {
				InputStreamReader reader = new InputStreamReader(
						new FileInputStream(".\\src\\com\\ljy\\day22\\转换流的编码问题\\demo3_gbk.txt"), "UTF-8");
				char[] aar = new char[20];
				int len = 0;
				StringBuffer sb = new StringBuffer();
				while ((len = reader.read(aar)) != -1) {
					sb.append(new String(aar, 0, len));
				}
				reader.close();
				System.out.println(sb.toString());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


}
