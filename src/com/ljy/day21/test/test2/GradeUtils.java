package com.ljy.day21.test.test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * 成绩单工具类
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月26日
 */
public class GradeUtils {
	private  static final String PATH = ".\\src\\com\\ljy\\day21\\test\\test2\\stud.txt";
	// 将成绩单写入文件
	public static void saveGradeList(Set<Student> stus) {
		BufferedWriter bos = null;
		try {
			bos = new BufferedWriter(new FileWriter(PATH));
			for (Student stu : stus) {
				String msg = stu.getName()+"\t" + stu.getGrade1()+"\t"+stu.getGrade2()+"\t"+stu.getGrade3()+"\t"+stu.getSumGrade();
				bos.write(msg);
				bos.newLine();
				bos.flush();
			}
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 将成绩单写入文件
		public static void saveGradeList(List<Student> stus) {
			BufferedWriter bos = null;
			try {
				bos = new BufferedWriter(new FileWriter(PATH));
				for (Student stu : stus) {
					String msg = stu.getName()+"\t" + stu.getGrade1()+"\t"+stu.getGrade2()+"\t"+stu.getGrade3()+"\t"+stu.getSumGrade();
					bos.write(msg);
					bos.newLine();
					bos.flush();
				}
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	/**
	 * 读取成绩单
	 */
	public static Set<Student> readGradeList() {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(PATH));
			String line = null;
			Set<Student>set = new TreeSet<>();
			while((line = bufferedReader.readLine())!=null) {
				String[] split = line.split("\t");
				String name = split[0];
				Student student = new Student();
				student.setName(name);
				float grade1 = Float.valueOf(split[1]);
				float grade2 = Float.valueOf(split[2]);
				float grade3 = Float.valueOf(split[3]);
				student.setGrade1(grade1);
				student.setGrade2(grade2);
				student.setGrade3(grade3);
				set.add(student);
			}
			bufferedReader.close();
			return set;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
