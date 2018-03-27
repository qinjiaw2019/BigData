package com.ljy.day21.test.test1;

import java.util.Scanner;

/**
 * <pre>
 * 记录一个程序的使用次数，超过5次提示去注册
 * </pre>
 * 
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月26日
 */
public class Demo1 {
	public static void main(String[] args) {
		boolean b = SystemConfig.initConfig();
		if(b) {
			//获取可用天数
			String status = SystemConfig.getRegistStatus();
			if(SystemConfig.REGISTED.equals(status)) {
				//已经注册
				System.out.println("欢迎使用xxx软件");
			}else {
				int count = SystemConfig.getAvailableCount();
				if(count<0 || count>5) {
					System.out.println("系统错误!");
				}else if(count==0) {
					Scanner scanner = new Scanner(System.in);
					System.out.println("免费使用次数已用完,");
					do {
						System.out.println("请选择:\t1.注册\t2.退出");
						try {
							int input = scanner.nextInt();
							if(input==1) {
								SystemConfig.changeRegistStatus(SystemConfig.REGISTED);
								System.out.println("注册完成,继续使用");
								scanner.close();
								break;
							}else {
								scanner.close();
								break;
							}
						}catch (Exception e) {
							System.out.println("输入错误,请重新输入");
						}
					} while (true);
					
					
				}else {
					System.out.println("欢迎使用xxx软件,还能免费使用"+(count-1)+"次");
					SystemConfig.changeAvailableCount(count-1);
				}
			}
		}else {
			System.out.println("系统初始化失败");
		}
	}
}
