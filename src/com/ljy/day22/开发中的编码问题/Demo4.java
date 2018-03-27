package com.ljy.day22.开发中的编码问题;

import java.util.Arrays;

/**
 * 
 * <pre>
 *  编码:
 *  byte[] getBytes() //对于中文  默认是GBK
 *  使用平台的默认字符集将此 String 编码为 byte 序列，
 *  并将结果存储到一个新的 byte 数组中。 
 *  	
 *  byte[] getBytes(Charset charset) 
 *  使用给定的 charset 将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。 
 *  	
 *  解码:
 *  String(byte[] bytes) //对于中文  默认是GBK
 *  通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。
 *  	
 *  String(byte[] bytes, Charset charset) 
 *  通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。
 *
 *  对于中文的编码:
 *  GBK:2个字节
 *  ISO8859-1:一个字节,但是我们通常认为它不支持中文
 *  UTF:3个字节
 *  ASCII:一个字节
 *  unicode:两个字节
 *  jdk提供给我们的进行比那吗解码的常用方法
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月27日
 * 
 * 
 */
public class Demo4 {
	public static void main(String[] args) {
		// GBK编码,GBK解码
		String str1 = "你好";
		byte[] str1b = str1.getBytes();// 默认是UTF-8(跟工作空间有关系)
		try {
			System.out.println(new String(str1b));
			System.out.println(Arrays.toString(str1b));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String str2 = "你好";
			byte[] str2b = str2.getBytes("GBK");// 默认是UTF-8(跟工作空间有关系)

			System.out.println(new String(str2b, "GBK"));
			System.out.println(Arrays.toString(str2b));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("============================");
		try {
			String str3 = "你好";
			byte[] str3b = str3.getBytes("ISO8859-1");//?? 该编码格式不支持中文

			String x = new String(str3b,"ISO8859-1");
			System.out.println(x);
			System.out.println(Arrays.toString(str3b));
			//byte[] newXb = x.getBytes("ISO8859-1");
			//System.out.println(new String(newXb,"UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
