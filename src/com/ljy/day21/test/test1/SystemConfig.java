package com.ljy.day21.test.test1;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class SystemConfig {
	private static final String SYSCONFIGPATH = ".\\src\\com\\ljy\\day21\\test\\test1\\demo1config.properties";
	public static final String REGISTED = "1";
	public static final String UNREGISTED = "0";

	/**
	 * 获取注册状态
	 * 
	 * @return
	 */
	public static String getRegistStatus() {
		Properties properties = getProperties();
		if (properties!=null) {
			return properties.getProperty("regist-status", "0");
		}
		return null;
	}

	public static boolean initConfig() {
		File file = new File(SYSCONFIGPATH);
		if (!file.exists()) {
			File parentFile = file.getParentFile();
			if (!parentFile.exists()) {
				parentFile.mkdirs();
			}
			FileOutputStream out = null;
			try {
				file.createNewFile();
				Properties properties = new Properties();
				properties.setProperty("regist-status", "0");
				properties.setProperty("available-count", "5");
				out = new FileOutputStream(file);
				properties.store(out, "system init");
				commit(properties, "system init");
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			} finally {
				close(out);
			}
		} else {
			return true;
		}

	}

	/**
	 * 修改可用次数
	 * 
	 * @param count
	 */
	public static void changeAvailableCount(int count) {
		Properties properties = getProperties();
		if(properties!=null) {
			properties.setProperty("available-count", String.valueOf(count));
			commit(properties, new Date().toString() + " change available-count");
		}
		
	}
	
	public static void changeRegistStatus(String status) {
		Properties properties = getProperties();
		if(properties!=null) {
			properties.setProperty("regist-status", status);
			commit(properties, new Date().toString() + " change regist-status");
		}
	}

	public static void commit(Properties properties, String msg) {
		if (properties == null)
			return;
		File file = new File(SYSCONFIGPATH);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			properties.store(out, "msg");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取可用次数
	 * 
	 * @return
	 */
	public static int getAvailableCount() {
		Properties properties = getProperties();
		if(properties!=null) {
			return Integer.valueOf(properties.getProperty("available-count", "0"));
		}
		return -1;
	}

	private static void close(Closeable... closeables) {
		for (Closeable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static Properties getProperties() {
		Properties properties = new Properties();
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(SYSCONFIGPATH);
			properties.load(inputStream);
			return properties;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			close(inputStream);
		}
		return null;
	}
}
