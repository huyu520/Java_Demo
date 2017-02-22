package com.intoms.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(new SimpleDateFormat().format(new Date()));
		System.out.println(new SimpleDateFormat().format(System.currentTimeMillis()));
		System.out.println(new SimpleDateFormat().format(Calendar.getInstance().getTime()));
	}
}
