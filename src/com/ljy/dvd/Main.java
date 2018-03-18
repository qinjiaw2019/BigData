package com.ljy.dvd;

import java.util.Scanner;

import com.ljy.dvd.bean.Admin;
import com.ljy.dvd.bean.DVD;
import com.ljy.dvd.bean.DVDRole;
import com.ljy.dvd.bean.User;
import com.ljy.dvd.bean.DVD.State;
import com.ljy.dvd.bean.DVDRole.RoleType;
import com.ljy.dvd.manager.DVDManager;
import com.ljy.dvd.manager.SystemManager;
import com.ljy.dvd.manager.UserManager;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("测试管理员账号:root 密码:root");
		// 1.初始化系统
		SystemManager.initSystem();
		// 2.显示欢迎
		showWelCome();

		do {
			System.out.println("菜单:\t1.用户登录\t2.用户注册 \t3.退出系统");

			Scanner scanner = new Scanner(System.in);
			int sysMenu = scanner.nextInt();
			switch (sysMenu) {
			case 1:
				do {
					System.out.println("请输入账号:");
					String account = scanner.next();
					System.out.println("请输入密码:");
					String pwd = scanner.next();
					DVDRole dvdRole = UserManager.getInstance().isExist(account);

					if (dvdRole != null) {
						boolean result = UserManager.getInstance().checkPwd(dvdRole, pwd);

						if (result) {
							System.out.println("恭喜 " + account + " 登录成功");
							switch (dvdRole.getRoleType()) {
							case USER:
								EXITLOGIN: do {
									System.out.println("菜单: 1.我的信息 \t2.DVD列表\t3.借DVD\t4.还DVD\t5.退出登录");
									switch (scanner.nextInt()) {
									case 1:
										System.out.println("我的信息:");
										dvdRole.showAccountInfo();
										System.out.println("\n");
										break;
									case 2:
										dvdRole.showDVDList();
										break;
									case 3:
										System.out.println("请输入要借的DVD编号:");
										String dvdId = scanner.next();
										((User) dvdRole).borrow(dvdId);
										break;
									case 4:
										System.out.println("请输入要还的dvd编号");
										String backId = scanner.next();
										((User) dvdRole).backDVD(backId);
										break;
									case 5:
										break EXITLOGIN;

									default:
										break;
									}

								} while (true);
								break;
							case ADMIN:
								EXITLOGIN: do {
									System.out.println("菜单: 1.我的信息\t2.DVD列表\t3.用户列表\t4.删除用户\t5.新增DVD\t6.删除DVD\t7退出登录");
									switch (scanner.nextInt()) {
									case 1:
										System.out.println("我的信息:");
										dvdRole.showAccountInfo();
										System.out.println("\n");
										break;
									case 2:
										dvdRole.showDVDList();
										break;
									case 3:
										((Admin)dvdRole).showUserLists();
										break;
									case 4:
										System.out.println("请输入要删除的用户账户");
										String deleteAccount = scanner.next();
										((Admin)dvdRole).deleteUser(deleteAccount);
										break;
									case 5:
										do {
											System.out.println("请输入DVD编号:");
											String dvdId = scanner.next();
											if (DVDManager.getInstance().isExistDVD(dvdId)) {
												System.out.println("已经存在" + dvdId + "对应的DVD,返回上层请输入B");
												if ("B".equals(scanner.next())) {
													break;
												}
											} else {
												System.out.println("请输入DVD作品名称:");
												String dvdName = scanner.next();
												DVD dvd = new DVD();
												dvd.setCount(0);
												dvd.setName(dvdName);
												dvd.setId(dvdId);
												dvd.setState(State.BACK);
												boolean addResult = DVDManager.getInstance().addDVD(dvd);
												System.out.println(addResult ? "新增DVD成功" : "新增失败");
												break;
											}
										} while (true);
										break;
									case 6:
										System.out.println("请输入要删除的DVD 编号:");
										String deleteId = scanner.next();
										boolean b = DVDManager.getInstance().deleteDVD(deleteId);
										System.out.println(b ? "删除成功" : "删除失败");
										break;
									case 7:
										break EXITLOGIN;
									default:
										break;
									}
								} while (true);
							}
							break;
						} else {
							System.out.println("账号或密码错误,返回请输入B");
							if (scanner.next().equals("B")) {
								break;
							}
						}

					} else {
						System.out.println("输入的账号不存在,返回请输入B");
						if (scanner.next().equals("B")) {
							break;
						}
					}
				} while (true);
				break;
			case 2:
				System.out.println("请设置姓名:");
				String name = scanner.next();
				REGIST: do {
					System.out.println("请设置账号:");
					String account = scanner.next();

					DVDRole dvdRole = UserManager.getInstance().isExist(account);

					if (dvdRole != null) {
						System.out.println("该账号已经存在,请重新设置");
					} else {
						do {
							System.out.println("请设置密码:");
							String pwd1 = scanner.next();
							System.out.println("请确认密码:");
							String pwd2 = scanner.next();
							if (!pwd1.equals(pwd2)) {
								System.out.println("两次密码不一致,请重新设置");
							} else {
								dvdRole = new User();
								dvdRole.setAccount(account);
								dvdRole.setName(name);
								dvdRole.setPwd(pwd1);
								dvdRole.setRoleType(RoleType.USER);
								UserManager.getInstance().addDVDRole(dvdRole);
								System.out.println("注册成功");
								break REGIST;
							}
						} while (true);

					}
				} while (true);
				break;
			case 3:
				SystemManager.exitSystem();
				System.out.println("感谢使用");
				return;
			}

		} while (true);

	}

	private static void showWelCome() {
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|             欢迎使用DVD管理系统                                   |");
		System.out.println("|                                          |");
		System.out.println("============================================");
	}
}
