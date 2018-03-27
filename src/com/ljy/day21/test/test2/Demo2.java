package com.ljy.day21.test.test2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * 2.有五个学生，每个学生有3门课的成绩，
 * 从键盘输入以上数据（包括姓名，三门课成绩），
 * 输入的格式：如：zhangsan，30，40，60计算出总成绩，
 * 并把学生的信息和计算出的总分数高低顺序存放在磁盘文件"stud.txt"中。
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月26日
 */
public class Demo2 {
	public static void main(String[] args) {
		inputGrade();
	}

	private static void inputGrade() {
		Scanner scanner = new Scanner(System.in);
		Set<Student> stus = new TreeSet<>();
		int inputCount = 0;
		do {
			System.out.println("请录入学生成绩,格式:zhangsan，30，40，60");
			String input = scanner.next();
			// 检查输入格式
			if (input != null) {
				String[] splits = input.split(",");
				if (splits.length != 4) {
					System.out.println("录入格式错误,请重新录入");
					continue;
				}
				String name = splits[0];
				float[] grades = new float[3];
				try {
					boolean tag = false;
					setGrade: for (int i = 1; i <= 3; i++) {
						grades[i - 1] = Float.valueOf(splits[i]);
						if (grades[i - 1] > 100) {
							System.out.println("成绩不能大于100");
							tag = true;
							break setGrade;
						}
					}
					if (tag) {
						continue;
					}
					Student student = new Student();
					student.setName(name);
					student.setGrade1(grades[0]);
					student.setGrade2(grades[1]);
					student.setGrade3(grades[2]);
					boolean add = stus.add(student);
					if (add) {
						inputCount++;
						System.out.println(student);
					} else {
						System.out.println("重复录入" + name + "的成绩");
					}
					if (inputCount == 5) {
						GradeUtils.saveGradeList(stus);
						scanner.close();
						System.out.println("录入完毕!");
						System.out.println(stus.toString());
						break;
					}
				} catch (Exception e) {
					System.out.println("录入格式错误,请重新录入");
					continue;
				}
			}
		} while (true);
	}
}
