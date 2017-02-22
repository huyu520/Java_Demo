/**
 * 
 */
package com.intoms.intomstest;

import java.util.Random;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2016年11月23日上午10:11:24
 */
public class Practice {
	public static void main(String[] args) {
//		System.out.println("随即产生的验证码:" + genVcode(6));
//		String phoneNum = "183731877a6";
//		System.out.println("格式化后的前的手机号码:" + phoneNum+ "格式化后的手机号码：" + formatPhone(phoneNum));
//		PID value = judgePhoneRight(phoneNum);
//		
//		switch (value) {
//		case OK:
//			System.out.println("正确");
//			break;
//		case ERROR:
//			System.out.println("其他错误");
//			break;
//		case FORMAT_ERROR:
//			System.out.println("格式错误");
//			break;
//		default:
//			System.out.println("未知错误");
//			break;
//		}
	}
	
	/**
	 * 随机产生固定长度验证码
	 * @param length
	 * @return
	 */
	public static String genVcode(int length){
		long start = System.currentTimeMillis();
		String vcode = "";
		Random rand = new Random();
		vcode = rand.nextInt((int)Math.pow(10, length)) +"";
		for(int i = 0; i < length - vcode.length(); i++){
			vcode += rand.nextInt(10)+"";
		}
		long end = System.currentTimeMillis();
		System.err.println("共花费时间:" + (end-start)+"ms");
		return vcode ;
	}
	
	public static String formatPhone(String pid){
		long start = System.currentTimeMillis();
		if(pid.equals("")||pid == null ){
			return "";
		}
		
		String phoneNum = pid.substring(0, 3);
		for(int i = 0; i < 4 ; i++){
			phoneNum += "*";
		}
		phoneNum += pid.substring(7);
		long end = System.currentTimeMillis();
		System.err.println("共花费时间:" + (end-start)+"ms");
		return phoneNum ;
	}
	
	public static PID judgePhoneRight(String pid){
		if(pid.length()!= 11){
			return PID.FORMAT_ERROR;
		}
		
		char[] ch = pid.toCharArray() ;
		for(int i = 1 ;i <ch.length; i++){
			if(ch[i] <47 || ch[i] > 58){
				return PID.ERROR;
			}
		}
		return PID.OK ;
	}
	
	public enum PID{
		OK,
		ERROR,
		FORMAT_ERROR
	}
}
