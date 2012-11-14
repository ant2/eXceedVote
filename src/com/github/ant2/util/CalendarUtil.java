package com.github.ant2.util;

import java.util.Calendar;

public class CalendarUtil {

	public static Calendar createCalendar(int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, offset);
		return calendar;
	}

}
