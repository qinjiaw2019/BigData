package com.ljy.dvd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String getTime() {
		return format.format(System.currentTimeMillis());
	}

	public static String getTime(Date date) {
		return format.format(date);
	}

	public static long getTime(String formatTime) throws ParseException {
		return format.parse(formatTime).getTime();
	}

	public static long getDays(String startTime, String endTime) throws ParseException {
		Date start = format.parse(startTime);
		Date end = format.parse(endTime);
		long day = (start.getTime() - end.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}
}
