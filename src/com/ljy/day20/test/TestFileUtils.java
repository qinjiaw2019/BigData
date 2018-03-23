package com.ljy.day20.test;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class TestFileUtils {
	@Test
	public void findAndCopyFile() {
		File file = new File("./day21/zuoye/third/zong.txt");
		if (file.exists()) {
			//删除是为了不用程序没运行一次都追加到文件中,这样会越来越大
			file.delete();
		}
		File parentFile = file.getParentFile();
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}
		List<File> list = FileUtils.findFileByExtension(".txt", new File("."));
		for (File f : list) {
			boolean b = FileUtils.copyFile2AnotherFile(f, file);
			System.out.println(f.getPath()+(b?"拷贝成功":"拷贝失败"));
		}
	}
}
