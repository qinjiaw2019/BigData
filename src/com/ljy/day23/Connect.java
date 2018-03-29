package com.ljy.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Connect {
	public static void main(String[] args) {
		//客户端线程
		Thread client = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Client client = new Client(InetAddress.getLocalHost().getHostAddress(), 60035);
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					String line = null;
					System.out.println("请输入要发送的内容");
					while((line=reader.readLine())!=null) {
						client.sendMsg(line);
						if(line.equals("over")) {
							client.close();
							break;
						}
					}
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		client.start();
		
		//服务器端线程
		Thread server = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Server server = new Server(60035);
				server.receiveMsg();
			}
		});
		server.start();
	}
}

/**
 * 
 * <pre>
 * 客户端
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月28日
 */
class Client {
	private DatagramSocket socket;
	private int port;
	private String ip;

	public Client(String ip, int port) {
		super();
		this.port = port;
		this.ip = ip;
		try {
			this.socket = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}

	}

	public void sendMsg(String msg) {
		byte[] bytes = msg.getBytes();
		try {
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(ip), port);
			socket.send(packet);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (this.socket != null && !this.socket.isClosed()) {
			this.socket.close();
		}
	}

}

/**
 * 
 * <pre>
 * 服务器端
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月28日
 */
class Server {
	private DatagramSocket socket;

	public Server(int port) {
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public void receiveMsg() {
		
		try {
			while (true) {
				byte[] data = new byte[1024];
				DatagramPacket packet = new DatagramPacket(data, data.length);
				socket.receive(packet);
				InetAddress address = packet.getAddress();
				byte[] msgBytes = packet.getData();
				String msg = new String(msgBytes).trim();
				System.out.println(address.getHostAddress() + ":" + msg);
				if(msg.equals("over")) {
					socket.close();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (this.socket != null && !this.socket.isClosed()) {
			this.socket.close();
		}
	}
}