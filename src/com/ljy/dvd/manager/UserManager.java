package com.ljy.dvd.manager;

import java.util.ArrayList;
import java.util.List;

import com.ljy.dvd.bean.Admin;
import com.ljy.dvd.bean.DVDRole;
import com.ljy.dvd.bean.DVDRole.RoleType;

public class UserManager {
	private List<DVDRole> roles = new ArrayList<>();

	private static class LazyHolder {
		private static final UserManager INSTANCE = new UserManager();
	}

	private UserManager() {
		// 在这添加一个管理员
		Admin admin = new Admin();
		admin.setAccount("root");
		admin.setPwd("root");
		admin.setName("超级管理员");
		admin.setRoleType(RoleType.ADMIN);
		this.roles.add(admin);
	}

	public static final UserManager getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void setDVDRoles(List<DVDRole> roles) {
		this.roles.addAll(roles);
	}

	public List<DVDRole> getDVDRoles() {
		return roles;
	}

	public DVDRole isExist(String account) {
		// 如果用数据库的话可以避免这样遍历,这样遍历如果数据很多,会变得很慢
		for (DVDRole temp : roles) {
			// 这里密码需要做处理
			if (temp.getAccount().equals(account)) {
				return temp;
			}
		}
		return null;
	}

	// 如果用数据库的话可以避免这样遍历,这样遍历如果数据很多,会变得很慢
	public boolean checkPwd(DVDRole temp, String pwd) {
		return temp.getPwd().equals(pwd);

	}

	public void addDVDRole(DVDRole dvdRole) {
		roles.add(dvdRole);
	}

}
