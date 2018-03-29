package com.ljy.day23.套接字通信;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo2 {
	public static void main(String[] args) throws IOException {
		int port = 55555;
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(port);
		System.out.println("服务器启动成功");
		// 使用线程池,防止并发过高时创建过多线程耗尽资源
		ExecutorService threadPool = Executors.newFixedThreadPool(30);
		while (true) {
			Socket socket = server.accept();
			System.out.println("链接成功");
			threadPool.submit(new Runnable() {

				@Override
				public void run() {
					try {
						InputStream inputStream = socket.getInputStream();
						byte[] bytes = new byte[1024];
						int len;
						StringBuilder sb = new StringBuilder();
						len = inputStream.read(bytes);
						sb.append(new String(bytes, 0, len));
						System.out.println(socket.getInetAddress() + ":" + sb.toString().getBytes());
						OutputStream os = socket.getOutputStream();
						os.write("服务器接收成功".getBytes());
						inputStream.close();
						os.close();
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
