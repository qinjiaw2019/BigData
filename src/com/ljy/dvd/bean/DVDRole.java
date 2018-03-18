package com.ljy.dvd.bean;

import java.io.Serializable;

/**
 * DVD系统角色
 * 
 * @author lijiayan
 *
 */
public abstract class DVDRole implements Show, Serializable {

	
	
	private static final long serialVersionUID = -1967547527588863104L;

	/**
	 * 系统角色类型
	 *
	 */
	public enum RoleType {
		USER, ADMIN
	}

	private String name;
	// 账户
	private String account;
	// 密码
	private String pwd;
	// 账户角色
	private RoleType roleType;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DVDRole) {
			DVDRole role = (DVDRole) obj;
			return role.getAccount().equals(this.getAccount());
		}
		return super.equals(obj);
	}

}
