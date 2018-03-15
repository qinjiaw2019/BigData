package com.qianfeng.kaoti1;

import java.io.Serializable;

public class Company implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String no;
	private String name;
	private int num;
	private String founder;
	private String info;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Company [no=" + no + ", name=" + name + ", num=" + num + ", founder=" + founder + ", info=" + info
				+ "]";
	}
	
	

}
