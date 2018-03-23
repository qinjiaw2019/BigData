package com.ljy.day20;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 拷贝图片
 * <pre>
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月23日
 */
public class Demo {
	public static void main(String[] args) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(
					new FileInputStream(new File("C:\\Users\\lijia\\Pictures\\Camera Roll\\sy_101468553566.jpg")));
			File file = new File("./pic/dog.jpg");
			
			if(!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			bos = new BufferedOutputStream(new FileOutputStream(file));
			int len = 0;
			byte[] array = new byte[1024];
			while ((len = bis.read(array)) != -1) {
				bos.write(array, 0, len);
			}
			bos.flush();
			System.out.println("拷贝完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			close(bis,bos);
		}
	}
	public static void close(Closeable...closeables) {
		for(Closeable closeable:closeables) {
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
