package com.ljy.day24.反射的例子;

public class NoteBook {
	public void run() {
		System.out.println("电脑开始运行");
	}

	public void useMouse(USB mouse) {
		mouse.open();
		mouse.close();
	}
}
