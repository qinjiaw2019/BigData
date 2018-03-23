package com.ljy.day20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * <pre>
 * 输入:键盘
 * 目的地:控制台
 * 
 * 输入:键盘
 * 目的地:文件
 * 
 * 输入:文件
 * 输出:控制台
 * 
 * 输入:文件
 * 目的地:文件
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月23日
 */
@SuppressWarnings({"unused","resource"})
public class Demo4 {
	public static void main(String[] args) {
		
	}
	
	public static void case1() throws IOException {
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader br2 = new BufferedReader(new FileReader(""));
		BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("")));
		
	}
}
