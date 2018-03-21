package com.ljy.day18.io流5;

import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 * 将文本数据写入到文本文件
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月21日
 */
public class Demo {
	public static void main(String[] args) {
		FileWriter fileWriter = null;
		try {
			//创建FileWriter类的对象并与写入的文件进行关联
			//这个文件如果有,直接使用,并且将原来数据覆盖,没有则创建新的
			//注意:默认关联文件的位置是当前的工程下
			//第二个参数true:表示追加,false(只有一个参数时的默认情况)覆盖
			//注意:当关联的文件在磁盘中不存在时会报文件找不到的异常,如:G:\\day18-io-file.txt G盘不存在
			fileWriter = new FileWriter("day18-io-file.txt",true);
			//当执行write方法的时候数据被临时放到了内存数据中,这时一个字节数组,内部会查编码表,调用
			//flush的时候才会将数据写入到文件
			fileWriter.write("Hello Java");
			//冲刷
			fileWriter.flush();
			System.out.println("写完毕");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fileWriter!=null) {
				try {
					//注意1:流一旦关闭了,就不能再继续写数据了
					//默认调用了close方法
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
