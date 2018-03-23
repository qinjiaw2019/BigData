package com.ljy.day20.文件;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * File:用来操作文件或者目录的类
 * 1.创建文件
 * 2.创建目录
 * 3.创建多路径
 * 
 * 判断是否是文件
 * 判断是否是路径
 * 判断是否隐藏
 * 
 * 获取根目录
 * 获取指定目录下的文件或者文件夹
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月23日
 */
public class MyFile {

	public static void main(String[] args) {
		createFile();
		createDir();
		isFlie();
		getLastModifyTime();
		getFileRoot();
	}

	private static void createFile() {
		// 创建File类对象
		File file = new File(".\\src\\com\\ljy\\day20\\文件\\全路径创建的文件");
		// 创建文件
		// 一,以全路径的方式创建文件
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 二,通过父目录 子目录
		File file1 = new File(".\\src\\com\\ljy\\day20\\文件", "用父目录子目录的方式创建的文件");
		try {
			file1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 三,有父目录对象,再有子文件
		File parant = new File(".\\src\\com\\ljy\\day20\\文件");
		File file2 = new File(parant, "先有父目录再创建的子文件");
		try {
			file2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createDir() {
		File file = new File("./src\\com\\ljy\\day20\\文件\\第一层目录/第二层目录(mkdirs)");
		File file1 = new File("./src\\com\\ljy\\day20\\文件\\第一层目录/第2层(mkdir)创建");
		// 这两都只能创建目录,不能创建文件
		file.mkdirs();// 可以创建多层目录
		file1.mkdir();// 只能创建一层目录
	}

	private static void isFlie() {
		File file = new File("src/com/ljy/day20/文件/MyFile.java");
		System.out.println("是否是文件:" + file.isFile() + " " + "是否是目录呢?" + file.isDirectory());
	}

	/**
	 * 注意:文件的查看不修改文件的最后修改时间 获取文件的最后修改时间
	 */
	private static void getLastModifyTime() {
		File file = new File("src/com/ljy/day20/文件/MyFile.java");
		System.out.println(format.format(new Date(file.lastModified())));
	}

	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static void getFileRoot() {
		// File file = new File("src/com/ljy/day20/文件/MyFile.java");
		// 获取当前设备的根目录
		File[] files = File.listRoots();
		for (File f : files)
			System.out.println(f);
		System.out.println("===================");
		File file = new File(".");
		String[] list = file.list();
		//获取当前目录下的文件目录或者文件
		//即当前层的内容,不包括自层,而且得到的只是文件路径或者文件的名字
		for (String string : list) {
			System.out.println(string);
		}
		
		//当前层的文件或者文件夹对象
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			System.out.println(file2.getAbsolutePath());
		}
	}
}
