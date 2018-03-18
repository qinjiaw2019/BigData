package com.ljy.dvd.bean;

import com.ljy.dvd.manager.DVDManager;
import com.ljy.dvd.manager.UserManager;

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

	public void showUserLists() {
		UserManager.getInstance().showUserList();
	}
	
	public void deleteUser(String account) {
		if(UserManager.getInstance().deleteUser(account)) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
}
