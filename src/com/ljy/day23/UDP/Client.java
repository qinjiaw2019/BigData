package com.ljy.day23.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * <pre>
 * UDP通信之客户端
 * 1.创建UDP通信的对象---socket对象----类是DataPramSocket
 * 2.准备数据封装包-------DataGramPacket(数据包,包含相关的属性和内容)
 * 3.发送数据,通过send方法
 * 4.关闭Socket对象
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月28日
 */
public class Client {
	public static void main(String[] args) {
		while(true) {
			for (int i = 1; i < 255; i++) {
				try {
					DatagramSocket socket = new DatagramSocket();
					String msg = "测试一下,不要将我ip发群里";
					byte[] bytes = msg.getBytes("GBK");
					DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.0.113."+i), 60035);
					socket.send(packet);
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
	}
}
