package com.ljy.day20.文件.递归遍历文件;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 * 定义:有条件的自己调用自己(方法)
 * 条件:
 * 	1.要给一个出口,负责当前的递归
 * 	2.循环次数不能太多,占用太多的内存,死机
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月23日
 */
public class Demo {
	static long  i = 0;
	private static BufferedWriter br = null;
	public static void main(String[] args) throws IOException {
		br = new BufferedWriter(new FileWriter("./统计该系统一共有几个文件"));
		/*File[] files = File.listRoots();
		for (File file : files) {
			listFiles(file);
		}*/
		listFiles(new File("C:/"));
		if (br!=null) {
			br.close();
			System.out.println("计算完成");
		}
		
		// Sum.add(11899);
		// System.out.println(Num.sum(40));
	}

	/**
	 * 遍历文件
	 * 
	 * @param file
	 */
	private static void listFiles(File file) {
		if (file == null) {
			return;
		}
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null) {
				for (File file2 : files) {
					listFiles(file2);
				}
			}

		} else {
			String  tString = file.getPath() + "        已经遍历了"+(++i) +"个文件";
			try {
				br.write(tString);
				br.newLine();
				br.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}

}

class Sum {
	static long sum = 0;

	public static long add(long i) {
		if (i < 0) {
			System.out.println(sum);
			sum = 0;
			return sum;
		}
		sum += i;
		return add(--i);
	}
}

// 1-20 奇数相乘- 偶数相乘
class Num {
	static long jishu = 1;
	static long oushu = 1;

	public static long sum(long i) {
		if (i <= 0) {
			long result = oushu - jishu;
			oushu = 0;
			jishu = 0;
			return result;
		} else {
			if (i % 2 == 0) {
				oushu *= i;
			} else {
				jishu *= i;
			}
			return sum(--i);
		}
	}
}
