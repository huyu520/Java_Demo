//package com.intoms.profile;
//
//import com.intoms.util.profiling.UtilTimerStack;
//
//public class UtilTimerTest {
//	public static void main(String[] args) throws Exception {
//		String time = "test user time ";
//		UtilTimerStack.setActive(true);
//		System.setProperty(UtilTimerStack.MIN_TIME, "" + 1000); //设置最小的超时记录时间  
//		UtilTimerStack.push(time);
//		methed(0);
//		UtilTimerStack.pop(time);
//	}
//	
//	public static void methed(int i) throws Exception {
//		System.out.println(i + "");  
//		    UtilTimerStack.push(i + " times");  
//		    if(i<3) methed(i+1); //递归调用，会产生缩进，最后调用i=3时不足1000，不记录  
//		    Thread.sleep(i * 300);  
//		    UtilTimerStack.pop(i + " times"); 
//	}
//}
