package com.ljy.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test10 {

	public static void main(String[] args) {
		String res = trim("  sss ");
		System.out.println("|" + res + "|");
		res = "HelloWorld";
		res = reverse(2, 7, res);
		System.out.println("反转后:" + res);

		res = "gfedcba";
		System.out.println("排序前:" + res);
		System.out.println("排序后:" + sortStr(res));
		System.out.println("6921168509256:" + certifyCode("6921168509256"));
		System.out.println("===========================");
		System.out.println(getRandom());

	}

	/**
	 * 1，模拟一个trim方法，去除字符串两端的空格。 思路： 1，判断字符串第一个位置是否是空格，如果是继续向下判断，直到不是空格为止。
	 * 结尾处判断空格也是如此。 2，当开始和结尾都判断到不是空格时，就是要获取的字符串。
	 * 
	 * @author Administrator
	 *
	 */
	public static String trim(String str) {
		if (str == null || str == "")
			return str;
		StringBuffer sb = new StringBuffer(str);
		// 去除前空格
		while (true) {
			if (sb.subSequence(0, 1).equals(" ")) {
				sb.delete(0, 1);
				if (sb.length() == 0)
					return "";
			} else {
				break;
			}
		}
		// 去除后空格
		while (true) {
			int len = sb.length();
			if (sb.subSequence(len - 1, len).equals(" ")) {
				sb.delete(len - 1, len);
				if (sb.length() == 0)
					return "";
			} else {
				break;
			}
		}
		return sb.toString();
	}

	/**
	 * 2，将一个字符串进行反转。将字符串中指定部分进行反转，"abcdefg";abfedcg 思路： 1，曾经学习过对数组的元素进行反转。
	 * 2，将字符串变成数组，对数组反转。 3，将反转后的数组变成字符串。 4，只要将或反转的部分的开始和结束位置作为参数传递即可。
	 * 
	 * @param start
	 * @param end
	 * @param str
	 * @return
	 */
	public static String reverse(int start, int end, String str) {
		if (end - start > str.length() || str == null || start < 0 || end > str.length())
			throw new IllegalArgumentException("参数异常");
		String subFirst = str.substring(0, start);
		String subEnd = str.substring(end, str.length());
		String subMiddle = str.substring(start, end);
		return subFirst + new StringBuilder(subMiddle).reverse() + subEnd;
	}

	/**
	 * 对字符串中字符进行自然顺序排序。 1:将字符串转成字符数组 2：排序 2：将数组转成字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String sortStr(String str) {
		if (str == null)
			return null;
		char[] array = str.toCharArray();
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					char temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return new String(array);
	}

	/**
	 * String code = "6921168509256"; 取前12位的奇数位的和 取前12位的偶数位的和
	 * 将"奇数位和"与"偶数位和的三倍"相加求和 取和的个位数，然后用10减去这个个位数，相减的结果就是条码的验证码
	 * 如果条码的第13位数字和这个验证码相同就说明验证码正确
	 * 
	 * @param code
	 * @return
	 */
	public static boolean certifyCode(String code) {
		if (code == null || code.length() != 13)
			return false;

		// 计算奇数位的和
		int oddSum = 0;
		// 计算偶数位的和
		int even = 0;
		try {
			for (int j = 0, i = 1; j <= 12 && i <= 12; i = i + 2, j = j + 2) {
				oddSum += Integer.valueOf(String.valueOf(code.charAt(i)));
				even += Integer.valueOf(String.valueOf(code.charAt(j)));
			}
			// 将"奇数位和"与"偶数位和的三倍"相加求和
			int sum = oddSum + even * 3;
			// 取和的个位数，然后用10减去这个个位数，相减的结果就是条码的验证码
			int numCode = 10 - sum % 10;
			return (String.valueOf(numCode).equals(String.valueOf(code.charAt(12))));
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 得到10个1--20之间的随机数，要求不能重复(要求用集合)
	 * 
	 * @return
	 */
	public static List<Integer> getRandom() {
		int time = 0;
		Random r = new Random();
		List<Integer> list = new ArrayList<Integer>();
		while (time < 10) {
			String random = String.valueOf(r.nextInt(20) + 1);
			if (list.contains(random)) {
				continue;
			} else {
				list.add(new Integer(random));
				time++;
			}
		}
		return list;

	}

	/**
	 * 给定一个含有n个元素的整型数组a，如果元素出现的次数为奇数次，则输出
	 * @param array
	 */
	public static void printArray(int[] array) {
		//将数组转化成集合
	}
}
