package com.intoms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderUtil {
	/**
	 * 日期工具类
	 * @author hy
	 * @since 2016-11-14 13:41
	 */
	
	private static final String style = "yyyy-MM-dd HH:mm:ss";
	//获取当前日期格式
	public static String getCurrentTime(){
		return getCurrentTime(style);
	}
	
	//获取当前日期格式
	public static String getCurrentTime(String style){
		return new SimpleDateFormat(style).format(new Date());
	}
	
	/**
	 * 获取前一天的日期
	 * * @see calendar.set(Calendar.YEAR, 2013);
     * @see calendar.set(Calendar.MONTH, 0);
     * @see calendar.set(Calendar.DATE, 1);
	 */
	public static String getYestoday(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return new SimpleDateFormat(style).format(cal.getTime());
	}
	/**
	 * 获得所在星期的第一天
	 */
	
	/**
	 * 获得所在星期的第一天
	 */
	@SuppressWarnings("static-access")
	public static Date getFirstDateByWeek(Date date) {

		Calendar now = Calendar.getInstance();
		now.setTime(date);
		int today = now.get(Calendar.DAY_OF_WEEK);
		int first_day_of_week = now.get(Calendar.DATE) + 2 - today; // 星期一
		now.set(now.DATE, first_day_of_week);
		return now.getTime();
	}

	/**
	 * 获得所在星期的最后一天
	 */
	public static Date getLastDateByWeek(Date date) {

		Calendar now = Calendar.getInstance();
		now.setTime(date);
		int today = now.get(Calendar.DAY_OF_WEEK);
		int first_day_of_week = now.get(Calendar.DATE) + 2 - today; // 星期一
		int last_day_of_week = first_day_of_week + 6; // 星期日
		now.set(now.DATE, last_day_of_week);
		return now.getTime();
	}

	/**
	 * 获得所在月份的最后一天
	 * @param 当前月份所在的时间
	 * @return 月份的最后一天
	 */
	public static Date getLastDateByMonth(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.MONTH, now.get(Calendar.MONTH) + 1);
		now.set(Calendar.DATE, 1);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - 1);
		now.set(Calendar.HOUR, 11);
		now.set(Calendar.MINUTE, 59);
		now.set(Calendar.SECOND, 59);
		return now.getTime();
	}

	/**
	 * 获得所在月份的第一天
	 * @param 当前月份所在的时间 
	 * @return 月份的第一天
	 */
	public static Date getFirstDateByMonth(Date date) {
		
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, 0);
		now.set(Calendar.HOUR, 12);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		return now.getTime();
	}
}
