package com.ljy.day18.io流5;

import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * <pre>
 * 将数据从文本文件取出
 * 分析:
 * 	取出,所以是输入流,操作的是文本文件,所以是字符流
 * 
 * read()方法的原理:
 * 控制磁头每次向后移动一个字符,依次读取,知道将所有的字符读完,当read()返回-1时,说明读完了
 * 
 * read(char[]):本质也是一个一个的读,每次读返回的int值是本次读取到的有效字符个数,返回-1表示读完
 * 每次读的数据存放到数组中
 * 通常数组长度一般是1024
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月21日
 */
public class Demo2 {
	public static void main(String[] args) {
		// 1.创建
		FileReader fileReader = null;
		try {
			//注意,这里的文件不存在一定会报异常
			fileReader = new FileReader("F:\\work\\java\\eclipseProjects\\BigData\\note\\class\\day18-io流.txt");
			char[] array = new char[1024];
			int len = 0;
			//注意,当文件读完时,返回-1
			while ((len = fileReader.read(array)) != -1) {
				//注意,new String(array, 0, len)表示的是从数组0(0表示下标,如果是1就是从开始第二个位置开始)开始,
				//共取值len个,所以len指的不是下标,而是字符个数
				String content = new String(array, 0, len);
				System.out.println(content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
