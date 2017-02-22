package com.intoms.hy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 关于系统时间日期的工具类
 * 
 * @author huyu
 * @version 2016-9-23
 */
public class SystemUtils {
	/**
	 * 获取系统当前时间(秒数)
	 */
	public static int getSystemCurrentSecond() {
		return (int) (System.currentTimeMillis() / 1000);
	}

	/**
	 * 获取当前时间(yyyy-MM-dd)
	 */

	public static String getCurrentTime() {
		return getCurrentTime("yyyy-MM-dd");
	}

	/**
	 * 获取当前时间(yyyy-MM-dd)
	 */
	public static String getCurrentTime(String style) {
		return new SimpleDateFormat(style).format(new Date());
	}

	/**
	 * 获明日前时间(yyyy-MM-dd)
	 */
	public static String getTomorrowTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * 获取前天时间(yyyy-MM-dd)
	 */
	public static String getLastTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * 秒数转换成当前时间
	 * 
	 * @param time
	 *            时间(秒数)
	 * @param style
	 *            返回的格式
	 * @return style格式时间
	 */
	public static String transformDateTime(int time, String style) {
		return transformDateTime(time * 1000L, style);
	}

	public static String transformDateTime(long time, String style) {
		Date date = new Date(time);
		SimpleDateFormat dateFormat = new SimpleDateFormat(style);
		String st = dateFormat.format(date);
		return st;
	}

	/**
	 * 获取时间的字符串显示方式(分钟：秒数)
	 * 
	 * @param time
	 *            时间(秒数)
	 * @return
	 */
	public static String getTimeStr(int time) {
		String timeStr = "";
		int min = time / 60;
		int second = time % 60;
		if (min < 10) {
			timeStr = timeStr + "0";
		}
		timeStr = timeStr + min + ":";
		if (second < 10) {
			timeStr = timeStr + "0";
		}
		timeStr = timeStr + second;

		return timeStr;
	}

	// 把日期转化为毫秒数
	public static long parseLong(String str) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		long i = simpleDateFormat.parse(str).getTime();
		return i;
	}

	public static boolean isCorrect(String str1, String str2) throws ParseException {
		long time1 = parseLong(str1);
		long time2 = parseLong(str2);
		if (time1 > time2) {
			return true;
		}
		return false;
	}

	/**
	 * 转换时间描述(后面有时间重构吧)
	 * 
	 * @param time
	 *            秒数
	 * @return X小时Y分钟Z秒
	 */
	public static String transHMS(long time) {
		if (time <= 0) {
			return "0小时0分钟1秒";
		}

		long hour = time / 3600;
		time = time - 3600 * hour;
		long min = time / 60;
		time = time - 60 * min;
		long sec = time;
		return hour + "小时" + min + "分钟" + sec + "秒";
	}

	/***
	 * 判断两个时间是否大于一个月
	 * 
	 * @throws ParseException
	 *             1
	 */
	public static boolean calDiffMouth(String time1, String time2) throws ParseException {
		if(time1.equals("")||time2.equals("")||time1 == null || time2 == null){
			return false ;
		}
		Calendar cal = Calendar.getInstance();
		long t1 = parseLong(time1);
		long t2 = parseLong(time2);
		cal.setTimeInMillis(t1);
		int y1 = cal.get(Calendar.YEAR);
		int m1 = cal.get(Calendar.MONTH);
		cal.setTimeInMillis(t2);
		int y2 = cal.get(Calendar.YEAR);
		int m2 = cal.get(Calendar.MONTH);
		if (y1 < y2 || ((y1 == y2) && m1 < m2)) {
			return true;
		}
		return false;
	}
}
