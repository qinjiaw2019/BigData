package com.ljy.day20.标准输入流入流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * 
 * <pre>
 * 更换标准流的输入源输出源
 * 实现将从键盘(in)----控制台(out)更新成文件
 * System.in默认的输入源是键盘,现在更新成文件
 * System.out默认的输出源是控制台,现在更新成文件
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月23日
 */
public class Demo {
	public static void main(String[] args) {
		try {
			//System.in默认的输入源是键盘,现在更新成文件
			System.setIn(new FileInputStream(".\\src\\com\\ljy\\day20\\package-info.java"));
			//从文件接收数据
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			//System.out默认的输出源是控制台,现在更新成文件
			System.setOut(new PrintStream(new FileOutputStream(".\\src\\com\\ljy\\day20\\标准输入流入流\\package-info-copy.java")));
			//将数据传入文件
			BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String line = null;
			while((line = br1.readLine())!=null) {
				bw1.write(line);
				bw1.newLine();
			}
			bw1.flush();
			br1.close();
			bw1.close();
			System.out.println("拷贝成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
