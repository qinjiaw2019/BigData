package com.ljy.dvd.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.ljy.dvd.bean.Admin;
import com.ljy.dvd.bean.DVD;
import com.ljy.dvd.bean.DVDRole;
import com.ljy.dvd.bean.DVDRole.RoleType;
import com.ljy.dvd.bean.User;

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

	/**
	 * 显示用户列表
	 */
	public void showUserList() {
		System.out.println("账户\t用户名");
		for(DVDRole role:roles) {
			if (role.getRoleType()==RoleType.USER) {
				System.out.println(role.getAccount()+"\t"+role.getName());
				List<DVD> list = ((User)role).getBorrowDVDList();
				if (list.size()>0) {
					System.out.println("未还DVD:");
					for(DVD dvd:list) {
						System.out.println(dvd.getId()+" "+dvd.getName());
					}
				}else {
					System.out.println("没有未还DVD!");
				}
			}
			System.out.println();
		}
	}
	
	public boolean deleteUser(String account) {
		//1.判断用户是否在列表中
		boolean tag = false;
		for(DVDRole role:roles) {
			if (role.getAccount().equals(account)) {
				if (role.getRoleType()==RoleType.ADMIN) {
					System.out.println("没有删除管理员的权限");
					return false;
				}else {
					tag = true;
				}
			}
		}
		
		if (!tag) {
			System.out.println("没有该用户");
			return false;
		}
		ListIterator<DVDRole> iterator = roles.listIterator();
		while(iterator.hasNext()) {
			DVDRole next = iterator.next();
			if (next.getAccount().equals(account)) {
				if(next.getRoleType()==RoleType.USER) {
					if (((User)next).getBorrowDVDList().size()>0) {
						System.out.println("该用户还有未归还的DVD,不能删除");
						return false;
					}
					iterator.remove();
					return true;
				}
			}
		}
		return false;
	}
}
