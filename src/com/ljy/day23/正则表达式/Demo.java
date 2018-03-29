package com.ljy.day23.正则表达式;

/**
 * 
 * <pre>
 * 正则表达式:
 * 	专门用来操作字符串的,简化代码
 * 	相当于一个规则
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月28日
 */
public class Demo {
	public static void main(String[] args) {
		
		/**
		 * 正则表达式
		 * 验证qq是否是符合规则的
		 * 1.都是数字
		 * 2.长度在[5,12]
		 * 3.不能以0开头
		 */
		System.out.println(checkQQ("1136558349"));
	}
	
	public static boolean checkQQ(String qq) {
		String regex = "^[1-9]\\d{4,11}$";
		return qq.matches(regex);
	}
}
