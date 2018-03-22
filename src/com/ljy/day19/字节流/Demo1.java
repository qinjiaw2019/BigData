package com.ljy.day19.字节流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * <pre>
 * 缓冲字节流数据的读写
 * BufferedInputStream
 * BufferedOutputStream
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月22日
 */
public class Demo1 {
	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(".\\note\\linux\\linux-文件管理.txt"));
			bos = new BufferedOutputStream(new FileOutputStream(".\\src\\com\\ljy\\day19\\字节流/linux-文件管理_copy.txt"));
			byte[] array = new byte[1024];
			int len = 0;
			while((len = bis.read(array))!=-1) {
				bos.write(array, 0, len);
				bos.flush();
			}
			System.out.println("拷贝成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (bos!=null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
			if (bis!=null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
