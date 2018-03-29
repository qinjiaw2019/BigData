package com.ljy.day23.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * <pre>
 * TCP 之服务器端
 * 
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月28日
 */
public class Server {
	private ServerSocket server = null;
	private ExecutorService threadPool = null;

	public Server(int port) throws IOException {
		server = new ServerSocket(port);
		threadPool = Executors.newFixedThreadPool(30);
	}

	public void startServer() throws IOException {
		System.out.println("服务器已启动....");
		while (true) {
			Socket socket = server.accept();
			System.out.println(socket.getInetAddress()+" 链接成功....");
			threadPool.submit(new Task(socket));
		}
	}

	public void closeServer() {
		if(server!=null) {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private final class Task implements Runnable {
		private Socket socket;

		public Task(Socket socket) {
			super();
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				outputStream.write("连接成功".getBytes());
				//获取数据
				byte[]data = new byte[1024];
				int len = 0;
				while((len = inputStream.read(data))!=-1) {
					String str = new String(data,0,len);
					try {
						outputStream.write(str.toUpperCase().getBytes());
					}catch (Exception e) {
						outputStream.write("转换失败".getBytes());
					}
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server(60056);
			server.startServer();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
