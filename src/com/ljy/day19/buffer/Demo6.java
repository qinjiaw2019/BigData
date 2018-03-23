package com.ljy.day19.buffer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 
 * <pre>
 * 缓冲输入流
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月22日
 */
public class Demo6 {
	public static void main(String[] args) {
		try {
			LjyBufferedReader bufferedReader = new LjyBufferedReader(
					new FileReader("./src/com/ljy/day19/buffer/Demo6.java"));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**
 * <pre>
 * <font color='red' size=3><strong>装饰者模式</strong></font>
 *     装饰模式指的是在不必改变原类文件和使用继承的情况下，动态地扩展一个对象的功能
 * 它是通过创建一个包装对象，也就是装饰来包裹真实的对象。
 *     特点:在原来的基础上进行了功能扩展,所以它还属于原来的体系
 * <hr/>
 * 如果自己要使用装饰着模式:
 * 原来的类Test
 * 装饰类BTest
 * 1.BTest继承Test
 * 2.BTest内有一个Test类型的变量
 * 3.BTest通过构造方法的方式将Test类的对象转入内部,并赋给2中的变量
 * 4.在实现功能的时候,调用Test类的变量实现基本功能,让自己实现增强的功能
 * <hr/>
 * <font color='#ff0000' size=3><strong>适配器模式</strong></font>
 * 对适配器涉及模式的理解:通常理解成变相的装饰者模式
 * 要求在子类中只想使用play方法
 * 分析:SubZiTest继承至ZiTest,ZiTest实现了Inter接口
 * 当SubZiTest只想实现Inter接口的某一个方法的时候,如果直接实现Inter接口,就必须实现所有的方法
 * 如果在SubZiTest与Inter中间插入一个类,就可以让这个类将接口中的所有方法都实现,那对于SubZiTest类就变的接单了
 * 我们可以将这个体系中的ZiTest理解成适配器模式中的设配器
 * <hr>
 * 模拟缓冲输入流
 * 注意点:
 *   1.缓冲输入流输入流的体系,所以要继承Reader
 *   2.要有一个Reader的输入流
 *   3.要有一个带参数的构造方法,将读入流当如当前的缓冲读入流内部
 *   4.编写实现对应的读的方法
 * 
 * 
 * </pre>
 */
class LjyBufferedReader extends Reader {

	private Reader reader;

	public LjyBufferedReader(FileReader reader) {
		super();
		this.reader = reader;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return reader == null ? -1 : reader.read(cbuf, off, len);
	}

	@Override
	public void close() throws IOException {
		if (reader != null) {
			reader.close();
		}
	}

	public String readLine() throws IOException {
		StringBuffer sBuffer = new StringBuffer();
		int len = 0;
		while ((len = reader.read()) != -1) {
			if (len == '\r') {// 遇到\r时属于\r\n(windows换行符)的一部分,所以直接跳过此次循环,进行下一次
				continue;
			}
			if (len == '\n') {
				return sBuffer.toString();
			} else {
				sBuffer.append((char) len);
			}
		}
		// 代码执行到这里,一种文件只有一行数据,一种没有数据
		return sBuffer.length() == 0 ? null : sBuffer.toString();
	}

}
