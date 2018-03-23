package com.ljy.day20.标准输入流;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * <pre>
 * 字符流 出发点:磁盘(文本文件) 目的地:内存
 * 标准输入流 出发点:键盘 目的地:内存
 * 
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月23日
 */
public class Demo {
	public static void main(String[] args) {
		//这里可以直接得到标准输入流的对象,并与键盘进行了绑定,可以直接从键盘接受数据
		InputStream in = System.in;
		try {
			byte[]array = new byte[1024];
			int num = 0;
			BufferedWriter br = new BufferedWriter(new FileWriter("./note/sysin.log",true));
			while(true) {
				num = in.read(array);//是一个阻塞式的方法,会一直等待
				String string = new String(array,0,num);
				if (string.equals("exit\r\n")) {
					break;
				}
				br.write(string);
				br.flush();
				System.out.println(string);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
