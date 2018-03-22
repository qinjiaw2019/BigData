package com.ljy.day19.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
	public static void main(String[] args) throws IOException {
		// 创建写出流
		FileWriter writer = new FileWriter("./src/com/ljy/day19/buffer/TestBufferedWriter.java");
		BufferedWriter bw = new BufferedWriter(writer);

		// 写数据
		bw.write("package com.ljy.day19.buffer;");
		bw.newLine();
		bw.newLine();
		bw.write("//使用字符缓冲输出流写的文件");
		bw.newLine();
		bw.write("public class TestBufferedWriter {");
		bw.newLine();
		bw.write("\tpublic static void main(String[] args) {");
		bw.newLine();
		bw.write("\t\tSystem.out.println(\"Hello World\");");
		bw.newLine();
		bw.write("\t}");
		bw.newLine();
		bw.write("}");
		bw.newLine();
		bw.write("");
		bw.newLine();
		bw.flush();
		writer.close();
		bw.close();
		System.out.println("ok");
	}
}
