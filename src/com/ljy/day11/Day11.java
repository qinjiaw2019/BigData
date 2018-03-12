package com.ljy.day11;

public class Day11 {
	public static void main(String[] args) {
		boolean result = checkNameAndPwd("lijiayan","123456");
		System.out.println(result?"验证通过":"用户名或密码不正确");
		System.out.println("===========================");
        checkEmail("lijiayan_mail@163.com");
	}

	public static boolean checkNameAndPwd(String name,String pwd){
		return name.equals("lijiayan")&&pwd.equals(pwd);
	}

	public static boolean checkEmail(String email){
	    return email!=null
                && email.contains("@")
                &&email.contains(".")
                &&!email.startsWith("@")
                &&!email.endsWith(".")
	            &&email.indexOf("@")<email.indexOf(".");
    }

}
