package com.ljy.day22.随机访问流;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * <pre>
 * RandomAccessFile 随机访问流
 * 不属于IO体系,只能擦操作文件,内部既有字节输出流,又有内存输入流
 * 作用原理:
 * 	内部有一个大型的字节数组,可以可通过指针(索引)进行控制,当进行随机访问
 * 	的时候,然指针指向对应的字节接可以从当前的字节开始读写
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月27日
 */
public class Demo1 {
	public static void main(String[] args) throws IOException {
		// 写
		writeFile();
		// 读
		//readFile();
	}

	// 读
	@SuppressWarnings("unused")
	private static void readFile() throws IOException {
		// 创建随机访问对象,并关联文件,同时指定当前对象的可操作模式
		// rw--可读写 w--只写 r---只读
		RandomAccessFile accessFile = new RandomAccessFile(".\\src\\com\\ljy\\day22\\随机访问流\\demo1.txt", "rw");
		System.out.println(accessFile.getFilePointer());
		//读的时候,seek 指向的位置应该在文件长度的范围内
		accessFile.seek(15);
		byte[]aar = new byte[6];
		accessFile.read(aar);
		System.out.println(new String(aar));
		System.out.println("程程".getBytes().length);
		accessFile.close();
	}

	// 写
	@SuppressWarnings("unused")
	private static void writeFile() {
		try {
			RandomAccessFile accessFile = new RandomAccessFile(".\\src\\com\\ljy\\day22\\随机访问流\\demo1.txt", "rw");
			accessFile.write("范冰冰".getBytes());
			accessFile.write(97);
			accessFile.writeInt(97);
			System.out.println(accessFile.getFilePointer());//当前文件指针所在的位置(单位是字节)
			/**
			 * seek后面的参数代表当前指针指向的位置,指向的是文件的最后一个字节
			 */
			accessFile.seek(15);
			accessFile.write("程程".getBytes());
			System.out.println(accessFile.getFilePointer());
			//当seek移动到之前有数据的位置再写时,进行的是覆盖而不是后移
			accessFile.seek(0);
			accessFile.write("美女".getBytes());
			accessFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
