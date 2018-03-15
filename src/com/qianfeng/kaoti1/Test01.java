package com.qianfeng.kaoti1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		int[] array = new int[10];
		createArray(array);
		System.out.println(Arrays.toString(array));
		writeArray(array);
		bubbleSort(array);
		System.out.println(Arrays.toString(array));

		delteOneAndSort();
		createDirAndFiles();
	}

	
	
	/**
	 * 请使用File类在当前项目下创建ExemFile文件夹,并且使用File类依次创建<br/>
	 * Company1.y、Company2.cy、Company3.cy、Company4.cy、Company5.cy文件
	 */
	private static void createDirAndFiles() {
		File file = new File("F:\\work\\java\\eclipseProjects\\BigData\\src\\com\\qianfeng\\kaoti1", "ExemFile");
		if (!file.exists()) {
			file.mkdirs();
			createFiles(file,
					new String[] { "Company1.y", "Company2.cy", "Company3.cy", "Company4.cy", "Company5.cy" });
		}
	}

	private static void createFiles(File parent, String[] strings) {
		for (String fileName : strings) {
			File file = new File(parent, fileName);
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 有如下一个数组{11,22,1,33,1,1,44,55,66,1,77,1,1,88} <br/>
	 * 要求将其中为1的元素值给去掉，通过合适的代码得到如下的新数组
	 */
	private static void delteOneAndSort() {
		System.out.println("===============去1排序=============");
		int[] array = { 11, 22, 1, 33, 1, 1, 44, 55, 66, 1, 77, 1, 1, 88 };
		System.out.println(Arrays.toString(array));
		bubbleSort(array);
		int newLen = array.length;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				array[i] = -1;
				newLen--;
			}
		}

		int[] newArray = new int[newLen];

		for (int i = 0, j = 0; i < array.length; i++) {
			if (array[i] >= 0) {
				newArray[j] = array[i];
				j++;
			}
		}
		System.out.println(Arrays.toString(newArray));
	}

	/**
	 * 使用冒泡排序对数组中的元素进行升序排列(3分)
	 * 
	 * @param array
	 */
	private static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					array[j] = array[j] ^ array[j + 1];
					array[j + 1] = array[j + 1] ^ array[j];
					array[j] = array[j] ^ array[j + 1];
				}
			}
		}
	}

	/**
	 * 请随机生成10个从2到222之间的数字(大于等于2小于等于222)， 将生成的随机数存储在整型数组中(不考虑重复)(3分)
	 * 
	 * @param array
	 */
	private static void createArray(int[] array) {
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(221) + 2;
		}
	}

	/**
	 * 请将上述的数组内容写入到当前项目下的randomArray.txt文件中，数字之间使用”-”隔开， <br/>
	 * 并且在文件的结尾追加上”张三-2015/11/12 21:47:20” 即：自己的姓名和当前的时间记录在文件的末尾(5分)
	 * 
	 * @param array
	 */
	private static void writeArray(int[] array) {
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i < array.length - 1) {
				sBuilder.append(array[i] + "-");
			} else {
				sBuilder.append(array[i]);
			}
		}
		SimpleDateFormat format = new SimpleDateFormat("张三-yyyy/MM/dd HH:mm:ss");
		String date = format.format(new Date());

		File file = new File("F:\\work\\java\\eclipseProjects\\BigData\\src\\com\\qianfeng\\kaoti1", "randomArray.txt");

		try {
			FileWriter fw = new FileWriter(file);
			fw.write(sBuilder.toString());
			fw.write("\r\n");
			fw.write(date);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
