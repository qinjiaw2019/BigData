package com.ljy.day24.反射的例子;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * <pre>
 * 运行笔记本
 * 使用鼠标
 * 使用键盘
 * 
 * 总结:
 * 通过反射可以在不更改功能类的前提下,实现新增功能的添加,我们只需要创建
 * 对应的工具类(鼠标类,键盘类,小爱音响类),在通过一个配置文件进行简单配置即可
 * 
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月29日
 */
public class Demo5 {
	public static void main(String[] args) {
		// Mouse mouse = new Mouse();
		// Keyboard keyboard = new Keyboard();
		NoteBook book = new NoteBook();
		book.run();
		// book.useKeyboard(keyboard);
		// book.useMouse(mouse);

		// 利用反射实现再不改变当前类的代码的前提下,实现新增功能
		// 读取配置文件Properties的内容
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(".\\src\\com\\ljy\\day24\\反射的例子\\config.properties"));
			for (int i = 0; i < properties.size(); i++) {
				String key = "usb"+i;
				String value = properties.getProperty(key);
				//创建字节码文件
				Class<?>cls = Class.forName(value);
				USB usb = (USB) cls.newInstance();
				book.useMouse(usb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
