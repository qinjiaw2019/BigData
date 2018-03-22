package com.ljy.day19.字节流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo {
	public static void main(String[] args) {
//		fileWrite();
//		readFile1();
//		readFile2();
		readFile3();
	}
	
	public static void fileWrite() {
		OutputStream out = null;
		try {
			out = new FileOutputStream(".\\src\\com\\ljy\\day19\\字节流/testFile");
			out.write("Hello World".getBytes());
			out.flush();
			System.out.println("写成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (out!=null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void readFile1() {
		InputStream in = null;
		try {
			in = new FileInputStream("./src/com/ljy/day19/字节流/Demo.java");
			int num = 0;
			while((num=in.read())!=-1) {
				System.out.println(num);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void readFile2() {
		InputStream in = null;
		try {
			in = new FileInputStream("./src/com/ljy/day19/字节流/Demo.java");
			byte[]bytes = new byte[1024];
			int num = 0;
			while((num=in.read(bytes))!=-1) {
				System.out.println(new String(bytes,0,num));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public static void readFile3() {
		InputStream in = null;
		try {
			in = new FileInputStream("./src/com/ljy/day19/字节流/Demo.java");
			//注意:如果文本的字节数太大,不建议使用
			byte[]bytes = new byte[in.available()];
			int num = in.read(bytes);
			System.out.println(new String(bytes,0,num));
			System.out.println("======================================");
			System.out.println(num);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

