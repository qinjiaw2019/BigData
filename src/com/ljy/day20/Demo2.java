package com.ljy.day20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class Demo2 {
	public static void main(String[] args) {
		//writeLog();
		try {
			test();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void writeLog() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
			bw = new BufferedWriter(new FileWriter(new File("./note/sysin.log"), true));
			String line = null;
			while ((line=br.readLine())!=null) {
				bw.write(getTime()+"  "+line);
				bw.newLine();
				bw.flush();
				if (line.equals("over")) {
					break;
				}
			}
			br.close();
			bw.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private final static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static String getTime() {
		return FORMAT.format(new Date());
	}
	
	@Test
	public static void test() throws IOException {
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		
		PrintStream out = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		String string = null;
		while ((string = br.readLine())!=null) {
			bw.write(string);
			bw.newLine();
			bw.flush();
			if ("over".equals(string)) {
				break;
			}
		}
		
		bw.close();
		br.close();
	}
}
