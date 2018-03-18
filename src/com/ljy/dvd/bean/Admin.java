package com.ljy.dvd.bean;

import com.ljy.dvd.manager.DVDManager;

public class Admin extends DVDRole {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5999167496820524055L;

	@Override
	public void showDVDList() {
		DVDManager.getInstance().showDVDList(this);
	}

	@Override
	public void showAccountInfo() {
		System.out.println("ID" + getAccount() + "--管理员");
	}

}
