package com.ljy.day23.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 
 * <pre>
 * UDP通信之服务器端:
 * 1.创建Socket对象并绑定端口号
 * 2.创建包对象准备接受发过来的数据
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月28日
 */
public class Server {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			DatagramSocket socket = new DatagramSocket(60035);
			byte[]buf = new byte[2014];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			//当程序运行起来的时候,这个方法会一直处于监听状态
			while(true) {
				socket.receive(packet);
				//将数据从包中取出来
				byte[] data = packet.getData();
				System.out.println(new String(data));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
