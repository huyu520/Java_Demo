package com.intoms.jode_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

public class JodaTimeDemo {
	
	private static final String style = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 测试jodaTime的测试类
	 * @param args
	 */
	public static void main(String[] args) {
//		test1();
//		test2();
		test3();
	}
	
	public static void test1(){
		DateTime dateTime = new DateTime(2017, 03, 07, 12, 00,55);
		System.err.println(dateTime.getHourOfDay());
	}
	
	
	/***
	 * 计算两天相差的天数
	 */
	public static void test2(){
		//jdk  
		Calendar start = Calendar.getInstance();   
		start.set(2012, Calendar.NOVEMBER, 14);  
		  
		Calendar end = Calendar.getInstance();  
		end.set(2012, Calendar.NOVEMBER, 15);  
		  
		long startTim = start.getTimeInMillis();  
		long endTim = end.getTimeInMillis();  
		long diff = endTim-startTim;  
		int days=(int) (diff/1000 / 3600 / 24);  
		System.out.println(days);
		//joda
		LocalDate start1 = new LocalDate(2017, 12, 01);
		LocalDate end1 = new LocalDate(2017, 12, 03);
		System.out.println(Days.daysBetween(start1, end1).getDays());
	}
	/**
	 * 3、获取18天之后的某天在下个月的当前周的第一天日期
	 */
	public static void test3(){
		//jdk
		Calendar cal = Calendar.getInstance() ;
		cal.add(Calendar.DAY_OF_MONTH, 18);
		cal.add(Calendar.MONTH, 1);
		
		SimpleDateFormat simpleForamat = new SimpleDateFormat(style);
		Date date = cal.getTime() ;
		System.out.println(simpleForamat.format(date));
		
		//joda
		String day = new DateTime().plusDays(18).plusMonths(1).dayOfWeek().withMinimumValue().toString(style);
		System.out.println(day);
	}
	
	
	/**计算宝宝两个时间相差多少天**/
	public static void calDiffByDay(DateTime start , DateTime end ){
		LocalDate sDate = new LocalDate(start) ;
		LocalDate eDate = new LocalDate(end);
		
		Days days = Days.daysBetween(sDate, eDate) ;
		int intervelDay = days.getDays() ;
		int intervekHour = end.getHourOfDay() - start.getHourOfDay() ;
		int intervelMinite = end.getMinuteOfHour() - start.getMinuteOfHour();
		int intervelSecond = end.getSecondOfMinute() - start.getSecondOfMinute() ;
		
		if(intervelSecond < 0){
			intervelMinite = intervelMinite - 1 ;
			intervelSecond = intervelSecond + 60 ;
		}
		
		if( intervelMinite < 0 ){
			intervekHour = intervekHour - 1;
			intervelMinite = intervelMinite + 60 ;
		}
		
		if( intervekHour < 0 ){
			intervelDay = intervelDay -1 ;
			intervekHour = intervekHour + 24 ;
		}
		
		System.out.println(intervelDay + "天" + intervekHour +   
                "小时" + intervelMinite + "分钟" + intervelSecond + "秒");  
        System.out.println("############################");  
	}
}
