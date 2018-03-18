package com.ljy.dvd.bean;

import java.io.Serializable;

public class DVD implements Serializable{
	
	private static final long serialVersionUID = -1213785957236251189L;

	public enum State {
		BORROW, BACK;
	}

	private User borrow;
	// 作品名称
	private String name;
	// 数量
	private int count;
	// 状态
	private State state;
	// 借出次数
	private String borrowTime;
	// 归还日期
	private String backTime;
	
	private String id;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getBorrowTime() {
		return state == State.BACK ? null : borrowTime;
	}

	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}

	public String getBackTime() {
		return state == State.BACK ? null : backTime;
	}

	public void setBackTime(String backTime) {
		this.backTime = backTime;
	}

	public User getBorrow() {
		return borrow;
	}

	public void setBorrow(User borrow) {
		this.borrow = borrow;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DVD) {
			this.id.equals(((DVD) obj).getId());
		}
		return super.equals(obj);
	}
}
