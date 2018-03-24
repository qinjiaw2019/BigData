package com.ljy.day20.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * 
 * <pre>
 * 文件操作工具类
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月23日
 */
public class FileUtils {

	/**
	 * 将一个txt文本文件内容拷贝到另一个文件
	 * 
	 * @param txtFile
	 * @param targetFile
	 * @return
	 */
	public static boolean copyFile2AnotherFile(File txtFile, File targetFile) {
		boolean copyResult = false;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(txtFile));
			// 追加方式
			bw = new BufferedWriter(new FileWriter(targetFile, true));
			String line = null;
			bw.write("====================================================================================");
			bw.newLine();
			bw.write("|"+txtFile.getPath() + ":");
			bw.newLine();
			bw.write("====================================================================================");
			bw.newLine();
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
			copyResult = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeStream(br,bw);
		}
		return copyResult;
	}

	/**
	 * 找出文件夹下后缀名名为指定后缀名的文件
	 * @param extension
	 * @param dir
	 * @return
	 */
	public static List<File> findFileByExtension(String extension,File dir) {
		FindFile findFile = new FindFile();
		findFile.findFileByExtension(extension, dir);
		return findFile.getList();
	}
	
	private static void closeStream(Closeable... closeables) {
		for (Closeable closeable : closeables) {
			if (closeable!=null) {
				try {
					closeable.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}
