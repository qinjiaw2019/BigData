package com.ljy.day21.其他流对象;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 
 * <pre>
 * 内存流(byte数组流)
 * ByteArrayInputStream:写入内存,在内部有一个数组,数据被放在里面
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月26日
 */
public class Demo7 {
	public static void main(String[] args) throws IOException {
		//创建输入流,关联一个byte型的数组,作为缓冲区数据
		ByteArrayInputStream bais = new ByteArrayInputStream("Hello World".getBytes());
		//创建输出流,不需要指定参数
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		byte[]arr = new byte[1024];
		int lne = 0;
		while((lne = bais.read(arr))!=-1) {
			baos.write(arr,0,lne);
		}
		
		System.out.println(new String(baos.toByteArray()));
		
	}
}
