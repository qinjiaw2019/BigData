package com.ljy.dvd.manager;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.ljy.dvd.bean.DVD;
import com.ljy.dvd.bean.DVDRole;

public class SystemManager {
	public static final String ALLROLES = "F:\\work\\java\\eclipseProjects\\BigData\\src\\com\\ljy\\dvd\\allroles";
	public static final String ALLDVDS = "F:\\work\\java\\eclipseProjects\\BigData\\src\\com\\ljy\\dvd\\alldvds";

	// 初始化系统
	public static boolean initSystem() {
		// 查询所有的用户包括管理员
		getAllRole();
		// 查询所有的DVD
		getAllDVD();
		return false;
	}
	
	// 退出系统
	public static boolean exitSystem() {
		// 存储用户包括管理员
		saveAllRole();
		// 存储DVD
		saveAllDVD();
		return false;
	}

	// 存储DVD
	private static void saveAllDVD() {
		DVDManager.getInstance().saveAllDVD(ALLDVDS);
	}

	// 存储用户包括管理员
	private static void saveAllRole() {
		UserManager.getInstance().saveAllRole(ALLROLES);
	}

	public static boolean doLogin(String account, String pwd) {
		
		return false;
	}

	public static void doLogout(DVDRole role) {

	}

	public static boolean doRegist(String account, String pwd) {
		return false;
	}

	@SuppressWarnings("unchecked")
	private static void getAllRole() {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(ALLROLES));
			ArrayList<DVDRole> list = (ArrayList<DVDRole>) ois.readObject();
			UserManager.getInstance().setDVDRoles(list);
			ois.close();
		} catch (Exception e) {
			
		}
	}

	@SuppressWarnings("unchecked")
	private static void getAllDVD() {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(ALLDVDS));
			ArrayList<DVD> list = (ArrayList<DVD>) ois.readObject();
			DVDManager.getInstance().setDVDList(list);
			ois.close();
		} catch (Exception e) {
			
		}
	}
}
