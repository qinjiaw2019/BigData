package com.ljy.day19.字节流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo {
	public static void main(String[] args) {
		fileWrite();
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
	
	
}

