//拷贝的文件
package com.ljy.day19.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 * 拷贝文件
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月22日
 */
public class tempDemo2 {
	public static void main(String[] args) {
		FileReader reader =null;
		FileWriter writer = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			reader = new FileReader("./src/com/ljy/day19/buffer/tempDemo2.java");
			writer = new FileWriter("./src/com/ljy/day19/buffer/tempDemo2.java");

			bufferedReader = new BufferedReader(reader);
			bufferedWriter = new BufferedWriter(writer);
			String line = null;
			bufferedWriter.write("//拷贝的文件");
			
			bufferedWriter.newLine();
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("tempDemo2")) {
					line = line.replace("tempDemo2", "tempDemo2");
				}
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
			bufferedWriter.flush();
			System.out.println("拷贝完毕");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("拷贝失败");
		}finally {
			close(writer,reader,bufferedReader,bufferedWriter);
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
