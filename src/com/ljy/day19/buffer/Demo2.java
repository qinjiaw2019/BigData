package com.ljy.day19.buffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo2 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		//使用缓冲读入流
		//创建两个流
		FileReader reader = new FileReader("./src/com/ljy/day19/buffer/TestBufferedWriter.java");
		//创建缓冲读入流并关联
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		//开始读
		//读一个字符
		int num;
		/*while((num = bufferedReader.read())!=-1) {
			System.out.println((char)num);
		}*/
		
		//读一个数组
		/*char[]array = new char[1024];
		while ((num=bufferedReader.read(array))!=-1) {
			System.out.println(new String(array,0,num));
		}*/
		
		//注意点:1.将所有的数据读完,再读,返回null;
		//		2.再读一行数据,不会读最后的换行符
		String line = null;
		while ((line = bufferedReader.readLine())!=null) {
			System.out.println(line);
			
		}
		
		reader.close();
		bufferedReader.close();
		
	}
}
