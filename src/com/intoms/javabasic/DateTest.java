package com.intoms.javabasic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		//date 
		DateFormat dateFormat = new SimpleDateFormat(Constant.style24);
		String dateTime = dateFormat.format(new Date());
		System.out.println(dateTime);
		
		//calender
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR)+"-" + (cal.get(Calendar.MONTH ) + 1) +"-"+cal.get(Calendar.DAY_OF_MONTH)+ " " + cal.get(Calendar.HOUR_OF_DAY) + ":"+ cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
	
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
	}
	
	public void calendarToDate(){
		Calendar calendar  = Calendar.getInstance() ;
		Date date = calendar.getTime() ;
		
	}
	
	public void dattToCalender(){
		Date date = new Date() ;
		Calendar calendar = Calendar.getInstance() ;
		calendar.setTime(date);
	}
}
