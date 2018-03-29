package com.ljy.day23.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * <pre>
 * TCP 之客户端:
 * 在客户端与服务器端通信的时候,
 * 对于客户端,既要进行输入,也要进行输出
 * 所有在socket对象的内部,就内置了输入流和输出流,
 * 当进行数据传输的时候,将数据放入Socket对象的内部,
 * 然后将Socket对象传到服务器,相当于在客户端与服务器端建立了一个通道,
 * 两边使用同一个Socket对象,我们可以通过操作这个对象进行数据的传输
 * 
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月28日
 */
public class Client {
	private Socket socket;
	public boolean connect(String address,int port) {
		try {
			socket = new Socket(address, port);
			return true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void sendMsg(String msg) {
		if(socket!=null && socket.isConnected()) {
			try {
				OutputStream stream = socket.getOutputStream();
				stream.write(msg.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void receiveMsg() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					InputStream inputStream = socket.getInputStream();
					int len = 0;
					byte[]data = new byte[1024];
					while((len = inputStream.read(data))!=-1) {
						System.out.println(new String(data,0,len));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
	}
	
	public void close() {
		if(socket!=null && !socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Client client = new Client();
		try {
			client.connect("10.0.113.54", 60056);
			client.receiveMsg();
			client.imputMsg(client);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private  void imputMsg(Client client) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine())!=null) {
			client.sendMsg(line);
		}
	}
}
