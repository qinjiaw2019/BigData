package com.ljy.dvd.manager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.ljy.dvd.bean.DVD;
import com.ljy.dvd.bean.DVD.State;
import com.ljy.dvd.bean.DVDRole;
import com.ljy.dvd.bean.User;
import com.ljy.dvd.util.DateUtils;

public class DVDManager {

	private static class LazyHolder {
		private static final DVDManager INSTANCE = new DVDManager();
	}

	private DVDManager() {
	}

	public static final DVDManager getInstance() {
		return LazyHolder.INSTANCE;
	}

	private List<DVD> list = new ArrayList<>();

	public List<DVD> getDVDList() {
		return list;
	}

	public void setDVDList(List<DVD> list) {
		this.list = list;
	}

	public boolean init() {
		return false;
	}

	public void showDVDList(DVDRole role) {

		if (role.getRoleType() == DVDRole.RoleType.USER) {
			System.out.println("编号\tDVD\t\t状态\t共借出次数");
			for (DVD dvd : list) {
				State state = dvd.getState();
				System.out.println(dvd.getId() + "\t" + dvd.getName() + "\t\t" + ((state == State.BORROW) ? "借出" : "可借")+"\t"+dvd.getCount());
			}
		} else {
			System.out.println("编号\tDVD\t\t状态\t借者\t共借出次数");
			for (DVD dvd : list) {
				State state = dvd.getState();
				System.out.println(dvd.getId() + "\t" + dvd.getName() + "\t\t" + ((state == State.BORROW) ? "借出" : "可借")
						+ "\t" + (state == State.BORROW ? dvd.getBorrow().getName() : "")+"\t"+dvd.getCount());
			}
		}
	}

	/**
	 * 判断是否存在该id对应的DVD
	 * 
	 * @return
	 */
	public boolean isExistDVD(String dvdId) {
		for (DVD dvd : list) {
			return dvd.getId().equals(dvdId);
		}
		return false;
	}

	/**
	 * 判断是否已经被借出
	 * 
	 * @param dvdId
	 * @return
	 */
	private boolean isBorrowed(String dvdId) {
		for (DVD dvd : list) {
			if (dvd.getId().equals(dvdId)) {
				return dvd.getState() == State.BORROW;
			}
		}
		throw new IllegalArgumentException("不存在该id对应的DVD");
	}

	private DVD borrow(User user, String dvdId) {
		for (DVD dvd : list) {
			if (dvd.getId().equals(dvdId)) {
				dvd.setBorrow(user);
				dvd.setBorrowTime(DateUtils.getTime());
				dvd.setState(State.BORROW);
				dvd.setCount(dvd.getCount() + 1);
				return dvd;
			}
		}
		return null;
	}

	public DVD borrowDVD(User user, String dvdId) {
		if (isExistDVD(dvdId)) {
			if (!isBorrowed(dvdId)) {
				return borrow(user, dvdId);
			} else {
				System.out.println("该dvd已经被借出");
				return null;
			}
		} else {
			System.out.println("暂时还没有" + dvdId + "对应的DVD");
			return null;
		}
	}

	// 还DVD,返回借出天数
	public int backDVD(User user, String dvdId) {
		Iterator<DVD> iterator = list.iterator();
		try {
			while (iterator.hasNext()) {
				DVD dvd = iterator.next();
				String startTime = dvd.getBorrowTime();
				String endTime = DateUtils.getTime();
				dvd.setBackTime(endTime);
				dvd.setState(State.BACK);
				dvd.setBorrow(null);
				int days = (int) DateUtils.getDays(startTime, endTime);
				return days == 0 ? 1 : days;

			}
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public boolean addDVD(DVD dvd) {
		if (!list.contains(dvd)) {
			list.add(dvd);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteDVD(String dvdId) {
		if (!isExistDVD(dvdId)) {
			System.out.println("不存在该编号的DVD");
			return false;
		} else {
			if (isBorrowed(dvdId)) {
				System.out.println("该DVD已经被借出,无法删除");
				return false;
			} else {
				ListIterator<DVD> iterator = list.listIterator();
				while (iterator.hasNext()) {
					DVD dvd = iterator.next();
					if (dvd.getId().equals(dvdId)) {
						iterator.remove();
						return true;
					}
				}
			}
		}
		return false;
	}
}
