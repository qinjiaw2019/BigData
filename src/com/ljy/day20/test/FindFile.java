package com.ljy.day20.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindFile {
	private List<File> list = null;

	public FindFile() {
		list = new ArrayList<>();
	}

	public void findFileByExtension(String extension, File dir) {
		if (extension == null || dir == null) {
			return;
		}
		if (dir.isFile() && dir.getName().endsWith(extension) && !dir.getName().equals("zong.txt")) {
			this.list.add(dir);
		}else {
			File[] files = dir.listFiles();
			if (files!=null) {
				for (File file : files) {
					findFileByExtension(extension, file);
				}
			}
		}
	}
	
	public List<File> getList() {
		return list;
	}

}
