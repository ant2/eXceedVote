package com.github.ant2.util;

import java.util.Calendar;

/**
 * A calendar utility
 * 
 * @author dtinth
 */
public class CalendarUtil {

	/**
	 * Creates a calendar that represents the date offset seconds from now.
	 * 
	 * @param offset
	 *            offset in seconds
	 * @return the new calendar
	 */
	public static Calendar createCalendar(int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, offset);
		return calendar;
	}

}
