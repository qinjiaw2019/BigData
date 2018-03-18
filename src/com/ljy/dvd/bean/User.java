package com.ljy.dvd.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.ljy.dvd.manager.DVDManager;

public class User extends DVDRole {

	private static final long serialVersionUID = 9174241987233327482L;
	private List<DVD> borrowList = new ArrayList<>();

	@Override
	public void showDVDList() {
		DVDManager.getInstance().showDVDList(this);
	}

	@Override
	public void showAccountInfo() {
		System.out.println("ID:" + getAccount());
		if (borrowList.size() == 0) {
			System.out.println("没有还未归还的DVD");
			return;
		}
		System.out.println("还未归还DVD:");
		for (DVD dvd : borrowList) {
			System.out.println(dvd.getId() + "\t" + dvd.getName() + "\t借出日期:" + dvd.getBorrowTime());
		}
	}

	/**
	 * 还DVD
	 * 
	 * @param dvdId
	 */
	public void backDVD(String dvdId) {
		// 判断是否借了该DVD
		boolean tag = false;
		for (DVD dvd : borrowList) {
			if (dvd.getId().equals(dvdId)) {
				tag = true;
				break;
			}
		}
		if (!tag) {
			System.out.println("您没有借该DVD");
			return;
		}
		ListIterator<DVD> iterator = borrowList.listIterator();
		while (iterator.hasNext()) {
			DVD dvd = iterator.next();
			if (dvd.getId().equals(dvdId)) {
				iterator.remove();
			}
		}
		int days = DVDManager.getInstance().backDVD(this, dvdId);
		System.out.println("供借出了" + days + "天,请支付" + days + "元");
	}

	public void borrow(String dvdId) {
		DVD dvd = DVDManager.getInstance().borrowDVD(this, dvdId);
		if (dvd != null) {
			borrowList.add(dvd);
			System.out.println("成功接得DVD:" + dvd.getName());
		}
	}
}
