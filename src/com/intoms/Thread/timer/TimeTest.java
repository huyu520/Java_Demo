package com.intoms.Thread.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTest {
	public static void main(String[] args) throws ParseException {
		timer1();
	}
	
	// 第一种方法：设定指定任务task在指定时间time执行 schedule(TimerTask task, Date time)  
    public static void timer1() throws ParseException {  
        Timer timer = new Timer();  
        
        String string = "2017-03-06 17:58:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(string) ;
        timer.schedule(new TimerTask() {  
            public void run() {  
                System.out.println("-------设定要指定任务--------");  
                timer.cancel();
            }  
        }, date);// 设定指定的时间time,此处为2000毫秒  
        
    } 
}
