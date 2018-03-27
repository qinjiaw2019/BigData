package com.ljy.day22;

public class 听写 {
	public static void main(String[] args) {
		int a = 2;
		int b = 1;
		int c = (a++ - b--)*((a<b?a:b)^(a*b++));
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		
		System.out.println("===============");
		int chenji = chenji(5);
		System.out.println(chenji);
	}
	
	static int sum = 1;
	public static int chenji(int i) {
		if(i==1)return sum;
		sum*=i;
		return chenji(--i);
	}
}
