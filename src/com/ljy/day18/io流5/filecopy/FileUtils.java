package com.ljy.day18.io流5.filecopy;

import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 * 文本文件拷贝
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月21日
 */
public class FileUtils {
	/**
	 * 文本文件拷贝
	 * 
	 * @param sourcePath
	 *            源文件
	 * @param targetPath
	 *            目标文件
	 * @return
	 */
	public static boolean copy(String sourcePath, String targetPath) {
		// 读文件
		FileReader fr = null;
		// 写文件
		FileWriter fw = null;
		boolean result = false;
		try {
			fr = new FileReader(sourcePath);
			fw = new FileWriter(targetPath);
			char[] array = new char[1024];
			int len = 0;
			while ((len = fr.read(array)) != -1) {
				fw.write(array, 0, len);
			}
			fw.flush();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream(fr, fw);
		}
		return result;
	}

	/**
	 * 关闭流
	 * 
	 * @param closes
	 */
	private static void closeStream(Closeable... closes) {
		for (Closeable closeable : closes) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
