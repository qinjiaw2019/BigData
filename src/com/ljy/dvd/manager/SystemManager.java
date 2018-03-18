package com.ljy.dvd.manager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ljy.dvd.bean.DVD;
import com.ljy.dvd.bean.DVDRole;

public class SystemManager {
	private static final String ALLROLES = "F:\\work\\java\\eclipseProjects\\BigData\\src\\com\\ljy\\dvd\\allroles";
	private static final String ALLDVDS = "F:\\work\\java\\eclipseProjects\\BigData\\src\\com\\ljy\\dvd\\alldvds";

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
		List<DVD> dvdList = DVDManager.getInstance().getDVDList();
		ObjectOutputStream oos; 
		try {
			oos = new ObjectOutputStream(new FileOutputStream(ALLDVDS));
			oos.writeObject(dvdList);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 存储用户包括管理员
	private static void saveAllRole() {
		List<DVDRole> dvdRoles = UserManager.getInstance().getDVDRoles();
		ObjectOutputStream oos; 
		try {
			oos = new ObjectOutputStream(new FileOutputStream(ALLROLES));
			oos.writeObject(dvdRoles);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
