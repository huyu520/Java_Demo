/**
 * @author ivan(ivan@intoms.com)
 * 创建时间:2009-6-10 下午09:55:40
 */
package com.intoms.javabasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import com.intoms.util.log.ILog;

/**
 *
 */
public class Util {

	public static double getRanNum( double begin, double end ) {
		Random ran = new Random();
		
		return begin + ran.nextDouble() * (end - begin);
	}
	
	/**
	 * 将秒数转换成小时和分和秒
	 * 
	 * @param timeSec
	 * @return
	 */
	public static String getTimeDesc(long timeSec) {
		if (timeSec <= 0) {
			return "1秒";
		}

		long day = timeSec / (3600 * 24);
		timeSec -= day * 3600 * 24;
		long hour = timeSec / 3600;
		timeSec -= hour * 3600;
		long min = timeSec / 60;
		long second = timeSec % 60;

		StringBuffer desc = new StringBuffer();
		if (day > 0) {
			desc.append(day + "天");
		}

		if (hour > 0) {
			desc.append(hour + "小时");
		}

		if (min > 0) {
			desc.append(min + "分钟");
		}

		if (second > 0) {
			desc.append(second + "秒");
		}

		return desc.toString();
	}
	
	/**
	 * 将时间(s)转化描述<br/>
	 * 如果有天数，精确到小时<br/>
	 * 如果有小时，精确到分钟<br/>
	 * 如果有分钟，精确到秒<br/>
	 * @param timeDesc
	 * @return
	 */
	public static String getTimeSimpleDesc( int timeSec) {
		if (timeSec <= 0) {
			return "1秒";
		}
		
		StringBuffer desc = new StringBuffer();
		int day = timeSec / (24 * 3600);
		
		if(day > 0) {
			// 天数
			desc.append(day).append("天");
			timeSec -= day * 24 * 3600;
			int hour = timeSec / 3600;
			if(hour > 0) {
				desc.append(hour).append("小时");
			}
		} else {
			// 小时
			int hour = timeSec / 3600;
			if(hour > 0) {
				desc.append(hour).append("小时");
				timeSec -= hour * 3600;
				int min = timeSec / 60;
				if(min > 0) {
					desc.append(min).append("分钟");
				}
			} else {
				// 分钟
				int min = timeSec / 60;
				if(min > 0) {
					desc.append(min).append("分钟");
					timeSec -= min * 60;
					if(timeSec > 0) {
						desc.append(timeSec).append("秒");
					}
				} else {
					desc.append(timeSec).append("秒");
				}
			}
		}
		
		return desc.toString();
	}
	
	public static String getDouble ( double value ) {
		String str = String.valueOf(value);
		if ( str.indexOf(".") > 0 ) {
			int lenth = str.length();
			if ( lenth > str.indexOf(".") + 3 ) {
				return str.substring( 0, str.indexOf(".") + 3 );
			}
		}
		return str; 
	}
	
	
	/**
	 *  将秒数转换成天或时或分或秒
	 *  大于1天  	只返回天
	 *  大于1小时	只返回小时
	 *  大于1分钟	只返回分钟
	 *  否则			返回秒
	 * @param timeSec
	 * @return
	 */
	public static String getLimitTimeDesc(long timeSec) {
		if (timeSec <= 0) {
			return "1秒";
		}

		long day = timeSec / (3600 * 24);
		long hour = timeSec / 3600;
		long min = timeSec / 60;
		long second = timeSec % 60;

		String desc = "";
		if (day >= 3) {
			desc = day + "天";
		}
		else if (hour > 0) {
			desc = hour + "小时";
		}
		else if (min > 0) {
			desc = min + "分钟";
		}
		else if (second > 0) {
			desc = second + "秒";
		}
		return desc;
	}
	
	/**
	 *  将秒数转换成天 小时
	 *  大于1天  	只返回天
	 *  大于1小时	只返回小时
	 *  大于1分钟	只返回分钟
	 *  否则			返回秒
	 * @param timeSec
	 * @return
	 */
	public static String getLimitDayHourDesc(long timeSec) {
		if (timeSec <= 0) {
			return "1秒";
		}
		long hour = timeSec / 3600;
		long min = (timeSec/60) % 60;
		long second = timeSec % 60;

		String desc = "";
		if (hour > 0) {
			desc = hour + "小时";
		}
		if (min > 0) {
			desc += min + "分钟";
		}
		if (hour == 0 && second > 0) {
			desc += second + "秒";
		}
		return desc;
	}
	
	/**
	 *  将秒数转换成天或时或分或秒
	 *  大于1天  	只返回天
	 *  大于1小时	只返回小时
	 *  大于1分钟	只返回分钟
	 *  否则			返回秒
	 * @param timeSec
	 * @return
	 */
	public static long getLimitTimeDescWithoutString(long timeSec) {
		if (timeSec <= 0) {
			return 1;
		}

		long day = timeSec / (3600 * 24);
		long hour = timeSec / 3600;
		long min = timeSec / 60;
		long second = timeSec % 60;

		long desc = 0;
		if (day >= 3) {
			desc = day ;
		}
		else if (hour > 0) {
			desc = hour;
		}
		else if (min > 0) {
			desc = min;
		}
		else if (second > 0) {
			desc = second ;
		}
		return desc;
	}
	public static String getMinute(long timeSec) {
		if (timeSec <= 0) {
			return "1秒";
		}
		
		long min = timeSec / 60;
		long second = timeSec % 60;
		
		String desc = "";
		if (min > 0) {
			desc = min + "分钟";
		}
		else if (second > 0) {
			desc = second + "秒";
		}
		return desc;
	}
	
	public static String getMinuteAndSec(long timeSec) {
		if (timeSec <= 0) {
			return "1秒";
		}
		
		long min = timeSec / 60;
		long second = timeSec % 60;
		
		String desc = "";
		if (min > 0) {
			desc = min + "分钟" + second + "秒" ;
		}
		else if (second > 0) {
			desc = second + "秒";
		}
		return desc;
	}

	/**
	 * 将秒数转换成小时和分
	 * 
	 * @param timeSec
	 * @return
	 */
	public static String getSecondDesc(long timeSec) {
		if (timeSec <= 0) {
			return "1秒";
		}

		long day = timeSec / (3600 * 24);
		timeSec -= day * 3600 * 24;
		long hour = timeSec / 3600;
		timeSec -= hour * 3600;
		long min = timeSec / 60;
		long second = timeSec % 60;

		StringBuffer desc = new StringBuffer();
		if (day > 0) {
			desc.append(day + "天");
		}

		if (hour > 0) {
			desc.append(hour + "小时");
		}

		if (min > 0) {
			desc.append(min + "分钟");
		}

		if (desc.length() == 0) {
			desc.append(second + "秒");
		}
		return desc.toString();
	}

	/**
	 * 将毫秒数转换成日期格式Long类型
	 * 
	 * @param time
	 * @return
	 */
	public static Long millisConvertToLong(long time) {
		if (time == 0) {
			return Long.valueOf(0);
		}
		Date date = new Date(time);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String st = dateFormat.format(date);
		return Long.valueOf(st.replace("-", ""));
	}

	/**
	 * 将毫秒数转换成日期和时间
	 * 
	 * @param time
	 *            毫秒
	 * @return
	 */
	public static String millisConvertToDate(long time) {
		Date date = new Date(time);
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
		String st = dateFormat.format(date);
		return st;
	}
	
	/**
	 * 毫秒 转成HH:mm:ss
	 * @param minSeconds
	 * @return
	 */
	public static String secondsConverToHour(long minSeconds){
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(minSeconds);
		String st = dateFormat.format(date);
		return st;
	}
	
	public static String millisConvertToDateS(long time) {
		Date date = new Date(time);
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日");
		String st = dateFormat.format(date);
		return st;
	}
	
	public static int getDailyHour () {
		SimpleDateFormat formart = new SimpleDateFormat("HH");
		return Integer.valueOf( formart.format(new Date()) );
	}
	
	/**
	 * 将毫秒数转当天的小时
	 * 
	 * @param time
	 *            毫秒
	 * @return
	 */
	public static int millisConvertHour() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
		String st = dateFormat.format(date);
		return Integer.valueOf( st );
	}
	/**
	 * 将毫秒数转换成时、分、秒
	 * @param time
	 *            毫秒
	 * @return
	 */
	public static String millisConvertToHour(long time) {
		Date date = new Date(time);
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String st = dateFormat.format(date);
		return st;
	}
	/**
	 * 将毫秒数转换成时、分、秒
	 * @param time
	 *            毫秒
	 * @return
	 */
	public static String millisConvertToHours(long time) {
		Calendar lastSpeakCal = Calendar.getInstance();
		lastSpeakCal.setTimeInMillis( time * 1000 );
		Calendar todayCal = Calendar.getInstance();
		if (	lastSpeakCal.get(Calendar.YEAR) == todayCal.get(Calendar.YEAR)
			 && lastSpeakCal.get(Calendar.MONTH) == todayCal.get(Calendar.MONTH)
			 && lastSpeakCal.get(Calendar.DAY_OF_MONTH) == todayCal.get(Calendar.DAY_OF_MONTH)) {
			
			return  Util.secConvertToProbablyTime( time );
		}
		else {
			return "昨天";
		}
		
	}
	
	/**
	 * 将毫秒数转换成时、分、秒
	 * @param time
	 *            毫秒
	 * @return
	 */
	public static String millisConvertToLimitHour(long time) {
		Date date = new Date(time);
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String st = dateFormat.format(date);
		return st;
	}
	
	public static String millisCoverDateOrHour ( long time ) {
		if ( getTodayDate().equals(getDate(time)) ) {
			return "(" + millisConvertToLimitHour(time*1000) + ")";
		}
		return "(" + millisConvertToDateS(time*1000) + "[" + millisConvertToLimitHour(time*1000) + "])";
	}

	/**
	 * 将秒数转换成日期和时间
	 * 
	 * @param time 秒
	 * @return
	 */
	public static String secConvertToDate(long time) {
		Date date = new Date(time * 1000);
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
		String st = dateFormat.format(date);
		return st;
	}
	
	/**
	 * 将秒数转换成小时和分
	 * 
	 * @param time 秒
	 * @return
	 */
	public static String secConvertToHandM(long time) {
		Date date = new Date(time * 1000);
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String st = dateFormat.format(date);
		return st;
	}
	
	/**
	 * 将秒数转换成日期和时间
	 * 
	 * @param time 秒
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String secConvertToDate_zh(long time) {
		Date date = new Date(time * 1000);
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日 HH时mm分");
		String st = dateFormat.format(date);
		if ( date.getMonth() < 10 ){
			st = st.substring(1);
		}
		return st;
	}
	/**
	 * 将秒数转换成日期和时间
	 * 
	 * @param time 秒
	 * @return
	 */
	public static String secConvertToDate_zh1(long time) {
		Date date = new Date(time * 1000);
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd日HH:mm");
		String st = dateFormat.format(date);
		return st;
	}
	/**
	 * 将秒数转换成日期和时间
	 * 
	 * @param time 秒
	 * @return
	 */
	public static String secConvertToDate2(long time) {
		Date date = new Date(time * 1000);
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm");
		String st = dateFormat.format(date);
		return st;
	}
	
	/**
	 * 将秒数转换成年月日时分秒
	 * @param time
	 * @return
	 */
	public static String secConvertString(long time) {
		Date date = new Date(time * 1000);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String st = dateFormat.format(date);
		return st.trim();
	}
	
	/**
	 * 将秒数转换成年.月.日
	 * @param time
	 * @return
	 */
	public static String secConvertToProbablyDate(long time) {
		Date date = new Date(time * 1000);
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String st = dateFormat.format(date);
		return st.replaceAll("-", ".");
	}
	
	/**
	 * 将秒数转换成年.月.日
	 * @param time
	 * @return
	 */
	public static String getTodayDate() {
		Date date = new Date();
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String st = dateFormat.format(date);
		return st;
	}
	
	public static String getYesterdayDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		String yesterday = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
		return yesterday;
	}
	
	/**
	 * 自定义时间描述格式
	 * @param time
	 * 		时间秒数
	 * @param pattern
	 * @return
	 */
	public static String diyTimeDesc(int time, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		long seconds = time * 1000L;
		return dateFormat.format(new Date(seconds));
	}
	
	/**
	 * 将秒数转换成年.月.日
	 * @param time
	 * @return
	 */
	public static String getDate( long time ) {
		Date date = new Date(time * 1000);
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String st = dateFormat.format(date);
		return st;
	}
	
	/**
	 * 将秒数转换成年.月.日
	 * @param time
	 * @return
	 */
	public static String getFormatDate( long time ) {
		Date date = new Date( time * 1000 );
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String st = dateFormat.format(date);
		return st;
	}
	
	/**
	 * 将毫秒转换成年.月.日
	 * @param time
	 * @return
	 */
	public static String getFormatDate2( long time ) {
		Date date = new Date( time );
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String st = dateFormat.format(date);
		return st;
	}
	
	/**
	 * 将秒数转换成年.月.日
	 * @param time
	 * @return
	 */
	public static String getDate() {
		Date date = new Date();
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String st = dateFormat.format(date);
		return st;
	}

	/**
	 * 将秒数转换成日
	 * @param time
	 * @return
	 */
	public static int secConvertToDay(long time) {
		Date date = new Date(time );
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy'年'MM'月'dd'日'");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		String st = dateFormat.format(date);
		return Integer.valueOf( st );
	}
	/**
	 * 判断是否双单日
	 * @return
	 */
	public static boolean isSingleDay () {
		if (secConvertToDay(System.currentTimeMillis())%2 == 0){
			return false;
		}
		return true;
	}
	/**
	 * 根据日期返回秒 
	 * @param dateTime  格式(2009-07-07 23:59:59)
	 * @return
	 * @throws ParseException 
	 */
	public static long dateConvertToSecond(String dateTime) throws ParseException {
		return dateConvertToSecond(dateTime, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 根据日期返回秒 
	 * @param dateTime  格式(style)
	 * @param style 
	 * @return
	 * @throws ParseException 
	 */
	public static long dateConvertToSecond(String dateTime,String style) throws ParseException {
		DateFormat df = new SimpleDateFormat(style);
		df.setLenient(false);
		Date d = df.parse( dateTime );
		return d.getTime()/1000;
	}
	public static long dateConvertToSecond2(String dateTime) throws ParseException {
		return dateConvertToSecond(dateTime, "yyyy-MM-dd");
	}
	 
	/**
	 * yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getCurDateFormate(){
		DateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		return df.format(new Date());
	}
	public static String getCurTime() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	/**
	 * 判断是否当天时间
	 * @param second
	 * @return
	 */
	public static String yestodyOrDayLyTime ( long second ) {
		Calendar lastSpeakCal = Calendar.getInstance();
		lastSpeakCal.setTimeInMillis( second * 1000 );
		Calendar todayCal = Calendar.getInstance();
		if (	lastSpeakCal.get(Calendar.YEAR) == todayCal.get(Calendar.YEAR)
			 && lastSpeakCal.get(Calendar.MONTH) == todayCal.get(Calendar.MONTH)
			 && lastSpeakCal.get(Calendar.DAY_OF_MONTH) == todayCal.get(Calendar.DAY_OF_MONTH)) {
			
			return  Util.secConvertToProbablyTime( second );
		}
		else {
			return "昨天"+ Util.secConvertToProbablyTime( second );
		}
	}
	/**
	 * 今天不显示 然后显示昨天、前天
	 */
	public static String yestodayAndBeforeYestoday( long second ) {
		Calendar today = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(second * 1000);
		if ( today.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) &&
			today.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR))
		{
			return Util.secConvertToProbablyTime(second);
		}else if ( today.get(Calendar.YEAR)-calendar.get(Calendar.YEAR) == 0 &&
					today.get(Calendar.DAY_OF_YEAR)-calendar.get(Calendar.DAY_OF_YEAR) == 1)
		{
			return "昨天"+ Util.secConvertToProbablyTime(second);
		}else if ( today.get(Calendar.YEAR)-calendar.get(Calendar.YEAR) == 0 &&
						today.get(Calendar.DAY_OF_YEAR)-calendar.get(Calendar.DAY_OF_YEAR) == 2)
		{
			return "前天"+ Util.secConvertToProbablyTime(second);
		}else{
			return Util.secConvertToDate2( second );
		}
	}
	/**
	 * 判断是否当天时间
	 * @param second
	 * @return
	 */
	public static boolean dayLyTime ( long second ) {
		Calendar lastSpeakCal = Calendar.getInstance();
		lastSpeakCal.setTimeInMillis( second * 1000 );
		Calendar todayCal = Calendar.getInstance();
		if (	lastSpeakCal.get(Calendar.YEAR) == todayCal.get(Calendar.YEAR)
			 && lastSpeakCal.get(Calendar.MONTH) == todayCal.get(Calendar.MONTH)
			 && lastSpeakCal.get(Calendar.DAY_OF_MONTH) == todayCal.get(Calendar.DAY_OF_MONTH)) {
			
			return  true;
		}
		return false;
	}
	/**
	 * 将秒数转换成时，分
	 * @param time
	 * @return
	 */
	public static String secConvertToProbablyTime(long time) {
		Date date = new Date(time * 1000);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String st = dateFormat.format(date);
		return st;
	}
	
	/**
	 * 取范围随机数
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getScopeRandom(int min,int max) {
		int i = min + (int)( Math.random() * ( max - min + 1 ) );
		return i;
	}
	
	public static String convertNumToWords(int num) {
		String words = "";
		if ( num == 1 ) {
			words = "一";
		}
		else if ( num == 2 ) {
			words = "二";
		}
		else if ( num == 3 ) {
			words = "三";		
		}
		else if ( num == 4 ) {
			words = "四";
		}
		else if ( num == 5 ) {
			words = "五";
		}
		else if ( num == 6 ) {
			words = "六";
		}
		else if ( num == 7 ) {
			words = "七";
		}
		else if ( num == 8 ) {
			words = "八";
		}
		else if ( num == 9 ) {
			words = "九";
		}
		else if ( num == 10 ) {
			words = "十";
		}
		return words;
	}
	
	public static String numConverDayOfWeek(int num) {
		if ( num == 0 ) {
			return "周天";
		}
		if ( num == 1 ) {
			return "周一";
		}
		if ( num == 2 ) {
			return "周二";
		}
		if ( num == 3 ) {
			return "周三";
		}
		if ( num == 4 ) {
			return "周四";
		}
		if ( num == 5 ) {
			return "周五";
		}
		if ( num == 6 ) {
			return "周六";
		}
		return "";
	}
	
	/**
	 * 获得简短描述：今天，昨天，前天，其他的显示
	 * @param time	毫秒
	 * @return
	 */
	public static String getBrevityDesc(long time) {
		Calendar today = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		String timeDesc = calendar.get(Calendar.MONTH)+1 + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "号";
		if ( today.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && today.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR) ) {
			timeDesc = "今天";
		}
		else if ( today.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && today.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR) == 1 ) {
			timeDesc = "昨天";
		}
		else if ( today.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && today.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR) == 2 ) {
			timeDesc = "前天";
		}
		return timeDesc;
	}
	
	/**
	 * 获得时间的简短描述格式<br/>
	 * 今天的显示 HH:mm<br/>
	 * 昨天的显示2天前,5天前,....
	 * @param time 秒数
	 * @return
	 */
	public static String getSimpleDesc(long time) {
		int targetDays = (int) days(time);
		int nowDays = (int)days(Calendar.getInstance().getTimeInMillis()/1000);
		
		int d_value = nowDays - targetDays;
		if (d_value > 360) {
			return "一年前";
		} else if (d_value > 180) {
			return "半年前";
		} else if (d_value > 90) {
			return "三个月前";
		} else if( d_value > 30 ) {
			return "一个月前";
		} else if( d_value > 15 ) {
			return "15天前";
		} else if( d_value > 10 ) {
			return "10天前";
		} else if( d_value > 5 ) {
			return "5天前";
		} else if( d_value > 2 ) {
			return "2天前"; 
		} else if( d_value > 1	) {
			return "前天";
		} else if( d_value > 0 ) {
			return "昨天";
		} else if( d_value == 0 ) {
			return new SimpleDateFormat("HH:mm").format(new Date(time*1000L));
		} else {
			//TMD的什么情况
			// 发信时间在未来
			return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(time*1000L));
		}
	}
	
	/**
	 * 将秒数转化为到天数
	 * @param secnods
	 * @return
	 */
	public static long days(long secnods) {
		final long daySeconds = 24 * 3600;
		final long hour8Seconds = 8 * 3600;               	 // 时差
		
		return (secnods + hour8Seconds) / daySeconds;
	}
	/**
	 * 获得简短描述：今天，昨天，前天，其他的显示
	 * @param time	毫秒
	 * @return
	 */
	public static String getDesc(long time) {
		Calendar today = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		String timeDesc = "前天:";
		if ( today.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && today.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR) ) {
			timeDesc = secConvertToProbablyTime(time/1000) + ":";
		}
		else if ( today.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && today.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR) == 1 ) {
			timeDesc = "昨天:";
		}
		else if ( today.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && today.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR) == 2 ) {
			timeDesc = "前天:";
		}
		return timeDesc;
	}
	
	/**
	 * 和今天是不是同一个星期
	 * @param time	毫秒
	 * @return
	 */
	public static boolean isSameOfTheWeek(long time) throws ParseException {
		Calendar lastCal = Calendar.getInstance();
		lastCal.setTimeInMillis(time);
		
		Calendar todyCal = Calendar.getInstance();
		
		if ( lastCal.get(Calendar.DAY_OF_WEEK) == 1 ) {
			if ( lastCal.get(Calendar.WEEK_OF_YEAR) == todyCal.get(Calendar.WEEK_OF_YEAR) + 1 ) {
				return true;
			}
			if ( todyCal.get(Calendar.DAY_OF_WEEK) == 1 && lastCal.get(Calendar.WEEK_OF_YEAR) == todyCal.get(Calendar.WEEK_OF_YEAR) ) {
				return true;
			}
			else {
				return false;
			}
		}
		
		if ( todyCal.get(Calendar.DAY_OF_WEEK) == 1 ) {
			if ( todyCal.get(Calendar.WEEK_OF_YEAR) == lastCal.get(Calendar.WEEK_OF_YEAR) + 1 ) {
				return true;
			}
			if ( lastCal.get(Calendar.DAY_OF_WEEK) == 1 && todyCal.get(Calendar.WEEK_OF_YEAR) == lastCal.get(Calendar.WEEK_OF_YEAR) ) {
				return true;
			}
			else {
				return false;
			}
		}
		
		if ( lastCal.get(Calendar.WEEK_OF_YEAR) == todyCal.get(Calendar.WEEK_OF_YEAR) ) {
			return true;
		}
		return false;
	}
	
	public static String encoderMD5(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
        StringBuilder res = new StringBuilder();
        try {
            for (byte b : md.digest(input.getBytes("UTF-8"))) {
                res.append(Integer.toHexString((b & 0xf0) >>> 4));
                res.append(Integer.toHexString(b & 0x0f));
            }
        } catch (UnsupportedEncodingException e) {
            for (byte b : md.digest(input.getBytes())) {
                res.append(Integer.toHexString((b & 0xf0) >>> 4));
                res.append(Integer.toHexString(b & 0x0f));
            }
        }
        return res.toString();
	}
	
	public static String httpRequestGet(String url) {
        String response       = "";
        HttpClient client     = new HttpClient();
        InputStream in        = null;
        BufferedReader reader = null;
        try{
            HttpMethod getMethod = new GetMethod(url);
            client.executeMethod(getMethod);
            in     = getMethod.getResponseBodyAsStream();
            reader           = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String temp      = ""; 
            while((temp = reader.readLine()) != null){
                sb.append(temp);
            }   
            response = sb.toString();
            // 关闭链接
            getMethod.releaseConnection(); 
        }catch (Exception e) {
            ILog.getCommon().error("",e);
        }finally{
            try{
                if(in != null){
                    in.close();
                }   
                if(reader != null){
                    reader.close();
                }
            }catch (IOException e) {
            }
        }
        return response;
    }
	
	/**
     * 获取传值参数值
     * @param paramsOnUseItem
     * @return
     */
    public static String getComeBackParams(String paramsOnTransfer) {
    	ILog.getCommon().debug("ahcming-test======================ahcming-test[paramsOnUseItem]: " + paramsOnTransfer);
    	if( null==paramsOnTransfer || "".equals(paramsOnTransfer)){
    		return null;
    	}
		String url = paramsOnTransfer.replaceAll("AND", "&amp;").replaceAll("EQ", "=");
    	return url;
	}
    
    /**
     * 将int型数字的指定位数进行隐藏
     * @param count			想进行隐藏的int数字
     * @param needHideNum	需要隐藏的位数
     * @return
     */
    public static String getHideNum( int count, int needHideNum ) {
    	String result = String.valueOf(count);
		int resultLength = result.length();
		if ( result.length() >= needHideNum ) {
			result = result.substring(0,resultLength-needHideNum) + "*" + result.substring(resultLength-needHideNum+1);
		}
		return result;
    }
    
    /**
     * 两个时间秒,之间相差的分钟数
     * @param time1
     * @param time2
     * @return
     */
    public static int dateDiffSeconde(int time1,int time2){
    	if(time1>time2){
    		int tmp = time1;
    		time1 = time2;
    		time2 = tmp;
    	}
    	int datediff = time2 - time1;
    	return datediff/60;
    }
    
    public static int dataDiff(String date1,String date2){
    	try {
    		long long1 = Util.dateConvertToSecond2(date1);
        	long long2 = Util.dateConvertToSecond2(date2);
        	int i = (int)((long2 - long1) / 3600 / 24 );
    		return Math.abs(i);
		} catch (Exception e) {
			ILog.getCommon().error("",e);
		}
		return 0;
    }
    
    /**
     * 计算两个时间之间相隔的天数，以日期来计算。例如2012-11-30 至  2012-12-03 相隔天数为 2。不包括起始和结束这两天
     * @param startTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    public static int getDifferNumDay(String startTime,String endTime) throws ParseException{
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	Date dBegin=sdf.parse(startTime);
    	Date dEnd=sdf.parse(endTime);
  	  	Calendar calBegin = Calendar.getInstance();
  	  	calBegin.setTime(dBegin); // 使用给定的 Date 设置此 Calendar 的时间
  	  	calBegin.add(Calendar.DAY_OF_MONTH, 1);
  	  	dBegin = calBegin.getTime();
  	  	Calendar calEnd = Calendar.getInstance();  
  	  	calEnd.setTime(dEnd);  
  	  	int diffDay = 0;
//  	  	System.out.println(dEnd);
//  	  	System.out.println(dBegin);
  	  	while (dEnd.after(dBegin))// 测试此日期是否在指定日期之后
  	  	{
  	  		calBegin.add(Calendar.DAY_OF_MONTH, 1);// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
  	  		dBegin = calBegin.getTime();
  	  		diffDay ++;
  	  	}
  	  	return diffDay;
 	}
    /**
     * 2013-07-31 to 2013-08-01 
     * @param day
     * @return
     * @throws ParseException
     */
    public static String getNextDay(String day) {
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		sdf.setLenient(false);
    		Date date = sdf.parse(day);
    		long t = 12*3600*1000L;
    		long t2 = t + date.getTime();
    		Date d = new Date(t+t2);
    		return sdf.format(d);
		} catch (Exception e) {
			ILog.getCommon().error("",e);
		}
		return "";
		
    }
    public static String getNextDay(String day,int num) {
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		sdf.setLenient(false);
    		Date date = sdf.parse(day);
    		long t = 12*3600*1000L*num;
    		long t2 = t + date.getTime();
    		Date d = new Date(t+t2);
    		return sdf.format(d);
		} catch (Exception e) {
			ILog.getCommon().error("",e);
		}
		return "";
		
    }
    
    public static String phoneNoWithStar( String phoneNo ) {
    	String a1 = phoneNo.substring(0,3);
    	StringBuffer stars = new StringBuffer();
    	for ( int i = 0; i < phoneNo.length()-6; i ++ ) {
    		stars.append("*");
    	}
    	String a2 = phoneNo.substring(phoneNo.length()-3);
    	phoneNo = a1 + stars + a2;
		return phoneNo;
    }
    
    public static void main(String[] args) throws Exception{
		String time = "2013-07-31";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		sdf.setLenient(false);
		Date date = sdf.parse(time);
		System.out.println(sdf2.format(date));
		long t = 12*3600*1000L;
		long t2 = t + date.getTime();
		Date d = new Date(t+t2);
		System.out.println(sdf.format(d));
	}
}
