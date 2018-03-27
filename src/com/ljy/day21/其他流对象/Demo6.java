package com.ljy.day21.其他流对象;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <pre>
 * 数据流:本子是字节流
 * DataInputStream 数据输入流
 * DataOutputStream 数据输出流
 * 注意:数据流要与字节输入输出流配合使用
 * 
 * 注意:1.数据流在读的时候,读的顺序要与写的顺序保持一致,否则数据会出错
 * 	   2.类型保持一致
 * 
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月26日
 */
public class Demo6 {
	public static void main(String[] args) {
		// 写
		//writeData();
		// 读
		readData();

	}

	private static void readData() {
		DataInputStream dataInputStream = null;
		try {
			dataInputStream = new DataInputStream(new FileInputStream(".\\src\\com\\ljy\\day21\\其他流对象\\temp6.txt"));
			int readInt = dataInputStream.readInt();
			int readInt1 = dataInputStream.readInt();
			boolean b = dataInputStream.readBoolean();
			double d = dataInputStream.readDouble();
			byte readByte = dataInputStream.readByte();
			System.out.println(b);
			System.out.println(d);
			System.out.println(readByte);
			System.out.println(readInt);
			System.out.println(readInt1);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (dataInputStream!=null) {
				try {
					dataInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

	@SuppressWarnings("unused")
	private static void writeData() {
		DataOutputStream dataOutputStream = null;
		try {
			dataOutputStream = new DataOutputStream(new FileOutputStream(".\\src\\com\\ljy\\day21\\其他流对象\\temp6.txt"));
			// 写
			dataOutputStream.writeInt(97);// 4个字节
			dataOutputStream.writeInt(96);// 4个字节
			dataOutputStream.writeBoolean(false);// 1个
			dataOutputStream.writeDouble(3.1415);// 8个
			dataOutputStream.write(33);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dataOutputStream != null) {
				try {
					dataOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}

}
