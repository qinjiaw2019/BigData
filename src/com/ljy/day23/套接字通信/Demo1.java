package com.ljy.day23.套接字通信;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * <pre>
 * 网络通信
 * 
 * TCP(传输控制协议):
 * 占用系统资源比较多
 * 面向连接的,可靠的,基于字节流的传输层通信协议,传输的是流
 * 安全的,连续的
 * 传输大量数据,速度慢
 * 
 * UDP(用户数据报协议):
 * 占用资源少
 * 面向无连接的,不保证安全性,传输的是包
 * 少量数据
 * 速度快
 * </pre>
 * <hr>
 * 
 * 客户端: (app/浏览器) 服务器端:!=主机
 * 
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月28日
 */
public class Demo1 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("10.0.113.54", 55555);
			OutputStream os = socket.getOutputStream();
			os.write("".getBytes());
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1024];
			int len;
			StringBuilder sb = new StringBuilder();
			len = inputStream.read(bytes);
			sb.append(new String(bytes, 0, len));
			System.out.println("服务器" + ":" + sb.toString());
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
